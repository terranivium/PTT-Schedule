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
	private int readInput; // Holds user input for condition checks
	private String stringChecker; // String search query story

	public PTTController(PTTModel model, PTTView view){
		this.model = model;
		this.view = view;
	}

	public void initFileHandling(){
		this.model.initFileIO();
	}

	public void runtimeMenu(){
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
				this.view.drawClassDirectorSelect();
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

	public void runtimeClassDirector(){
		do {
			this.readInput = this.systemInput.nextInt();
			this.systemInput.nextLine();
			if (this.readInput == 1) {
				this.model.newClassDirectorSession(); // Create new ClassDirector
				this.view.drawClassDirectorCreate(); // CD Menu
				this.readInput = this.systemInput.nextInt();
				this.systemInput.nextLine();
				if(this.readInput == 1){
					this.view.addClassRequirement();
					this.stringChecker = this.systemInput.nextLine(); // Checks string input
					this.readInput = this.systemInput.nextInt();
					try {
						this.model.getCdSession().newClassRequirement(new Class(this.stringChecker, this.readInput)); //this should create a new Class in class requirements
					} catch(Exception e){
						this.view.classError();
						this.runtimeClassDirector();
					}
					this.view.confirmClass();
					this.runtimeClassDirector();
				} else if(this.readInput == 2){
					this.view.removeClassRequirement();
					this.stringChecker = systemInput.nextLine();
					this.model.getCdSession().getListOfClassRequirements().remove(this.model.getCdSession().getListOfClassRequirements().searchClass(this.stringChecker)); // finds Class to remove and then removes it
					// confirm removal of class
					this.runtimeClassDirector();
				} else if(this.readInput == 3){
					// submit listOfClassRequirements should be done here
					this.runtimeMenu();
				} else {
					this.view.notValid();
					this.view.drawClassDirectorCreate();
				}
			} else if (this.readInput == 2) {
				this.runtimeMenu();
			} else {
				this.view.notValid();
				this.view.drawClassDirectorSelect();
			}
		} while (this.readInput != 2);
		this.runtimeMenu();
	}

	public void runtimeAdmin(){
		// When administrator menu option chosen
		this.model.newAdminSession();
		// go through each listOfClass requirements
		if(this.model.getClassDirectors().get(0) != null){
			for(ClassDirector cd:this.model.getClassDirectors()){
				Iterator<Class> goThrough = cd.getListOfClassRequirements().getGoThrough();
				while(goThrough.hasNext()){
					Class classE = goThrough.next();
					classE.print(); // print Class requirement 1
					for(;;){ // force admin to assign class to staff before progressing
						this.view.drawAdminOptions();
						this.stringChecker = this.systemInput.nextLine();
						this.systemInput.nextLine();
						this.model.getListOfStaff().find(stringChecker); // allow admin to search for appropriate staff
						this.view.readyToAssign();
						this.readInput = this.systemInput.nextInt();
						this.systemInput.nextLine();
						if (this.readInput == 1){
							break;
						}
					}
					for(;;){
						this.view.drawAdminNameWait();
						this.stringChecker = this.systemInput.nextLine();
						this.systemInput.nextLine();

						if(this.model.getListOfStaff().findStaff(stringChecker).assignClass(classE, cd.getListOfClassRequirements())){
							break;
						}
					}
					this.model.getListOfStaff().findStaff(stringChecker).assignClass(classE, cd.getListOfClassRequirements());
				}
			}
		}
	}

	public void runtimePTT(){
		// When ptt director menu option chosen

		// sets boolean on listOfClassAssignments, if conditions are met (all requirements met, no issues with staff numOfClasses)
		// outputs file of class assignments
	}
}