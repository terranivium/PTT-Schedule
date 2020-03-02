package view;

import model.*;
import view.*;

public class PTTView{

	private PTTModel model;
	private PTTView view;

	public PTTView(PTTModel model){
		this.model = model;
	}

	public void drawAdminSelect(){ // Admin Menu 1
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("| Administrator Access Mode |");
		System.out.println("-----------------------------");
		System.out.println("	Select option...");
		System.out.println("		1. View and assign class requirements");
		System.out.println("		2. Return to main menu");
		System.out.println("-----------------------------------------------------");
	}

	public void drawAdminOptions(){ // Admin Menu 2
		System.out.println();
		System.out.println("-------------------");
		System.out.println("| Fill Assignment |");
		System.out.println("-------------------");
		System.out.println("	Please enter a search query for Staff...");
		System.out.println("		Recommended: ");
		System.out.println("		Subject Area, Number of class slots available");
		System.out.println("-----------------------------------------------------");
	}

	public void drawClassDirectorSelect(){ // Class Director Menu 1
		System.out.println();
		System.out.println("------------------------------");
		System.out.println("| Class Director Access Mode |");
		System.out.println("------------------------------");
		System.out.println("	Select option...");
		System.out.println("		1. Create list of class requirements");
		System.out.println("		2. Return to main menu");
		System.out.println("--------------------------------------------");
	}

	public void drawClassDirectorCreate(){ // Class Director Menu 2
		System.out.println();
		System.out.println("------------------------------");
		System.out.println("| List of Class Requirements |");
		System.out.println("------------------------------");
		System.out.println("	Select option...");
		System.out.println("		1. Add class requirement");
		System.out.println("		2. Remove class requirement");
		System.out.println("		3. Sumbmit list and exit");
		System.out.println("-----------------------------------");
	}

	public void drawAdminNameWait(){
		System.out.println();
		System.out.println("To assign a member of staff to this role, type their EXACT name and hit return.");
	}

	public void readyToAssign(){
		System.out.println();
		System.out.println("Press 1 if you are ready to assign Staff member to the role.");
	}

	public void addClassRequirement(){ // When class director wants to add class
		System.out.println();
		System.out.println("Please input a new class title...");
	}

	public void confirmClass(){ // Confirm class director has added class
		System.out.println();
		System.out.println("New class added to list of requirements.");
	}

	public void classError(){ // General error for issue adding class
		System.out.println();
		System.out.println("Error on new class requirement input, please try again...");
	}

	public void removeClassRequirement(){ // When class director wants to remove a class
		System.out.println();
		System.out.println("Please input the class title you wish to remove...");
	}

	public void notValidMatch(){ // String matching error
		System.out.println();
		System.out.println("The class title MUST match exactly to an existing class!");
	}

	public void drawPTTDirectorSelect(){ // PTT Director Menu 1
		System.out.println();
		System.out.println("----------------------------");
		System.out.println("| PTT Director Access Mode |");
		System.out.println("----------------------------");
		System.out.println("	Select option...");
		System.out.println("		1. View and approve list of class assignments");
		System.out.println("		2. Return to main menu");
		System.out.println("---------------------------------------------");
	}

	public void drawMain(){ // Main/root menu
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("| PTT Schedule App, cli_ver. 1.0 |");
		System.out.println("----------------------------------");
		System.out.println("	Select user mode...");
		System.out.println("		1. Class Director");
		System.out.println("		2. Administrator");
		System.out.println(" 		2. PTT Director");
		System.out.println("		4. Quit");
		System.out.println("----------------------------------");
	}

	public void fileOutputConfirmation(){
		System.out.println();
		System.out.println("Writing to .txt file in root folder..."); // change with actula filename
	}

	public void fileInputConfirmation(){
		System.out.println();
		System.out.println("Reading from .txt file in root folder..."); // change with actula filename
	}

	public void fileError(){
		System.out.println();
		System.out.println("File read error..."); // change with actula filename
	}

	public void notValid(){
		System.out.println();
		System.out.println("Please select a valid menu option...");
	}
}