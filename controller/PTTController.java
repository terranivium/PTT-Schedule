package controller;

import java.util.Scanner;

import model.*;
import model.Class;
import view.*;

public class PTTController{

	private PTTModel model;
	private PTTView view;
	private Scanner systemInput = new Scanner(System.in); // User input instance
	private int readInput; // Holds user menu input for condition checks
	private int intChecker; // int for class creation and queries
	private String stringChecker; // String search query story
	private Class currentClass = null;

	public PTTController(PTTModel model, PTTView view){
		this.model = model;
		this.view = view;
	}

	public void runtimeMenu() throws InterruptedException {
		this.view.drawMain();
		do {
			this.readInput = this.systemInput.nextInt();
			this.systemInput.nextLine();
			if (this.readInput == 1) { // Class Director Mode
				this.model.newClassDirectorSession(); // Create new ClassDirector
				this.runtimeClassDirector();
			} else if (this.readInput == 2) {
				this.view.drawAdminSelect();
				this.runtimeAdmin();
			} else if (this.readInput == 3) {
				this.model.newPTTDirectorSession();
				this.view.drawPTTDirectorSelect();
				this.runtimePTT();
			} else if (this.readInput == 4) {
				// closes scanner, ends runtime
				this.systemInput.close();
				System.exit(0);
			} else {
				this.view.notValid();
				this.view.drawMain();
			}
		} while (this.readInput != 4);
	}

	public void runtimeClassDirector() throws InterruptedException {
		this.view.drawClassDirectorSelect();
		do {
			this.readInput = this.systemInput.nextInt();
			this.systemInput.nextLine();
			if (this.readInput == 1) {
				this.view.drawClassDirectorCreate(); // CD Menu
				do {
					this.readInput = this.systemInput.nextInt();
					this.systemInput.nextLine();
					if (this.readInput == 1) { // Add class requirement
						this.view.addClassRequirement();
						do {
							this.stringChecker = this.systemInput.next(); // Checks string input
							this.systemInput.nextLine();
						} while(this.stringChecker.equals(""));
						this.view.addNumClasses();
						do {
							this.intChecker = this.systemInput.nextInt(); // Check input hours
							this.systemInput.nextLine();
						} while(this.intChecker <= 0);
						try {
							this.model.getCdSession().newClassRequirement(new Class(this.stringChecker, this.intChecker)); //this should create a new Class in class requirements
						} catch (Exception e) {
							this.view.classError();
							Thread.sleep(500);
							this.runtimeClassDirector();
						}
						this.view.confirmClass();
						Thread.sleep(500);
						this.runtimeClassDirector();
					} else if (this.readInput == 2) { // Remove class requirement
						this.view.removeClassRequirement();
						do {
							this.stringChecker = this.systemInput.next();
							this.systemInput.nextLine();
						} while(this.stringChecker.equals(""));
						try{
							this.model.getCdSession().subClassRequirement(this.model.getCdSession().getListOfClassRequirements().searchClass(this.stringChecker)); // finds Class to remove and then removes it
						} catch(Exception e){
							this.view.classError();
							Thread.sleep(300);
							this.runtimeClassDirector();
						}
						this.view.confirmClass();
						Thread.sleep(300);
						this.runtimeClassDirector();
					} else if(this.readInput == 3){ // View current list of class requirements
						this.model.getCdSession().getListOfClassRequirements().print();
						Thread.sleep(1000);
						this.runtimeClassDirector(); // replace with scanner to check if user wishes to exit
					} else if (this.readInput == 4) {
						this.runtimeMenu();
					} else {
						this.view.notValid();
						Thread.sleep(300);
						this.runtimeClassDirector();
					}
				} while (this.readInput != 4);
			} else if (this.readInput == 2) {
				this.runtimeMenu();
			} else {
				this.view.notValid();
				Thread.sleep(300);
			}
		} while (this.readInput != 2);
	}

	public void runtimeAdmin() throws InterruptedException {
		// When administrator menu option chosen
		do {
			this.readInput = this.systemInput.nextInt();
			this.systemInput.nextLine();
			if (this.readInput == 1) {
				if (this.model.getCdSession() != null) {
						while (this.model.getCdSession().getListOfClassRequirements().getGoThrough().hasNext()){
							currentClass = this.model.getCdSession().getListOfClassRequirements().getGoThrough().next(); // current class requirement to be assigned
							System.out.println();
							currentClass.print(); // print Class requirement 1..n
							Thread.sleep(1000);
							do {
								this.view.drawAdminOptions();
								this.stringChecker = this.systemInput.next();
								this.systemInput.nextLine();
								this.model.getListOfStaff().find(stringChecker); // allow admin to search for appropriate staff
								Thread.sleep(1000);
								this.view.readyToAssign();
								this.stringChecker = this.systemInput.next();
								this.systemInput.nextLine();
							} while (!this.stringChecker.equals("Y"));
							boolean successfulAssignment = false;
							while(!successfulAssignment){
								this.view.drawAdminNameWait();
								this.stringChecker = this.systemInput.next();
								this.systemInput.nextLine();
								try{
								//	this.model.getListOfStaff().findStaff(stringChecker).assignClass(currentClass, this.model.getCdSession().getListOfClassRequirements());
									successfulAssignment = 	this.model.getListOfStaff().findStaff(stringChecker).assignClass(currentClass, this.model.getCdSession().getListOfClassRequirements());
								} catch (Exception e){
									this.view.classError();
									Thread.sleep(300);
								}
								if(successfulAssignment) {
									this.view.confirmClass();
									Thread.sleep(300);
								} else{
									this.view.classError();
								}
							}
						}
						System.out.println("End of required classes, please contact PTT Director");
						this.runtimeMenu();
				} else {
					this.view.noClassDirectors();
					Thread.sleep(300);
					this.runtimeMenu();
				}
			} else if (this.readInput == 2) {
				this.runtimeMenu();
			} else {
				this.view.notValid();
				Thread.sleep(300);
				this.view.drawAdminSelect();
			}
		} while (this.readInput != 2);
	}

	public void runtimePTT() throws InterruptedException{
		ListOfClassAssignments teachingRequests = new ListOfClassAssignments(model.getListOfStaff());
		teachingRequests.bundleAllClasses();
		do {
			this.readInput = this.systemInput.nextInt();
			this.systemInput.nextLine();
			if (this.readInput == 1) {
				do {
					if (teachingRequests.getTeachingRequests().isEmpty()) {
						this.view.noTeachingRequests();
						this.runtimeMenu();
					} else {
						for (String request : teachingRequests.getTeachingRequests()) {
							Thread.sleep(500);
							this.view.approveRequestScreen();
							System.out.println(request);
							this.readInput = this.systemInput.nextInt();
							this.systemInput.nextLine();
							if (this.readInput == 1) {
								this.model.getPttSession().approveRequest(request);
								//teachingRequests.getTeachingRequests().remove(request);
							} else if (this.readInput == 2) {
								this.model.getPttSession().declineRequest(request);							}
						}
						teachingRequests.getTeachingRequests().clear();
					}
			}while(!teachingRequests.getTeachingRequests().isEmpty());
				System.out.println("All available teaching requests have been reviewed...");
				Thread.sleep(1000);
				System.out.println("Writing to File...");
				this.model.getPttSession().sendToFile();
			}
			this.runtimeMenu();
		} while (this.readInput != 2);

		// When ptt director menu option chosen

		// sets boolean on listOfClassAssignments, if conditions are met (all requirements met, no issues with staff numOfClasses)
		// outputs file of class assignments
	}
}