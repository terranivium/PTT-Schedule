package controller;

import java.util.Iterator;
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
	private Iterator<Class> goThrough;

	public PTTController(PTTModel model, PTTView view){
		this.model = model;
		this.view = view;
	}

	public void initFileHandling(){
		this.model.initFileIO();
	}

	public void runtimeMenu() throws InterruptedException {
		try{
			this.initFileHandling();
		} catch(Exception e){
			this.view.fileError();
		}
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
							this.stringChecker = this.systemInput.nextLine();
							this.systemInput.nextLine();
						} while(this.stringChecker.equals(""));
						try{
							this.model.getCdSession().subClassRequirement(this.model.getCdSession().getListOfClassRequirements().searchClass(this.stringChecker)); // finds Class to remove and then removes it
						} catch(Exception e){
							this.view.classError();
							Thread.sleep(500);
							this.runtimeClassDirector();
						}
						this.view.confirmClass();
						Thread.sleep(500);
						this.runtimeClassDirector();
					} else if(this.readInput == 3){ // View current list of class requirements
						this.model.getCdSession().getListOfClassRequirements().print();
						Thread.sleep(500);
						this.runtimeClassDirector(); // replace with scanner to check if user wishes to exit
					} else if (this.readInput == 4) {
						this.runtimeMenu();
					} else {
						this.view.notValid();
						Thread.sleep(500);
						this.runtimeClassDirector();
					}
				} while (this.readInput != 4);
			} else if (this.readInput == 2) {
				this.runtimeMenu();
			} else {
				this.view.notValid();
				Thread.sleep(500);
			}
		} while (this.readInput != 2);
	}

	public void runtimeAdmin() throws InterruptedException {
		// When administrator menu option chosen
		this.model.newAdminSession();
		do {
			this.readInput = this.systemInput.nextInt();
			this.systemInput.nextLine();
			if (this.readInput == 1) {
				if (this.model.getClassDirectors() != null) {
					for (ClassDirector cd : this.model.getClassDirectors()){
						goThrough = cd.getListOfClassRequirements().getGoThrough();
						while (goThrough.hasNext()) {
							Class currentClass = null;
							try {
								currentClass = goThrough.next();
								currentClass.print(); // print Class requirement 1..n
							} catch(Exception e){
								System.out.println("End of required classes, please contact PTT Director");
								this.runtimeMenu();
							}
							this.view.drawAdminOptions();
							do{
								this.stringChecker = this.systemInput.next();
								this.systemInput.nextLine();
								this.model.getListOfStaff().find(stringChecker); // allow admin to search for appropriate staff
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
									this.model.getListOfStaff().findStaff(stringChecker).assignClass(currentClass, cd.getListOfClassRequirements());
									successfulAssignment = 	this.model.getListOfStaff().findStaff(stringChecker).assignClass(currentClass, cd.getListOfClassRequirements());
								} catch (Exception e){
									this.view.classError();
									Thread.sleep(500);
								}
								if(successfulAssignment) {
									this.view.confirmClass();
									Thread.sleep(500);
									break;
								} else{
									this.view.classError();
								}
							}
						}
					}
				} else {
					this.view.noClassDirectors();
					Thread.sleep(500);
					this.runtimeMenu();
				}
			} else if (this.readInput == 2) {
				this.runtimeMenu();
			} else {
				this.view.notValid();
				Thread.sleep(500);
				this.view.drawAdminSelect();
			}
		} while (this.readInput != 2);
	}

	public void runtimePTT(){
		// When ptt director menu option chosen

		// sets boolean on listOfClassAssignments, if conditions are met (all requirements met, no issues with staff numOfClasses)
		// outputs file of class assignments
	}
}