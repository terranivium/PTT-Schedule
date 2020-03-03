package model;

import java.util.ArrayList;

public class Staff{

	private int maxClasses;
	private int minClasses;
	private int numClasses;
	private ArrayList<Class> assignedClasses = new ArrayList<Class>();

	private String name;
	private String subjectArea;

	public Staff(String name, String subjectArea, int maxClasses, int minClasses){
		this.name = name;
		this.subjectArea = subjectArea;
		this.maxClasses = maxClasses;
		this.minClasses = minClasses;
	}

	public ArrayList<Class> getAssignedClasses(){
		return this.assignedClasses;
	}

	public boolean assignClass(Class assignedClass, ListOfClassRequirements requirements) {
		if(!assignedClass.getSubjectArea().equals(this.subjectArea)){
			System.out.print("This staff member is not part of the " + assignedClass.getSubjectArea() + " staff.");
			return false;
		}
		if(overMaxClasses()){
			System.out.print("This staff member cannot handle additional class responsibilities.");
			return false;
		}
		this.assignedClasses.add(assignedClass);
		this.numClasses += assignedClass.getClassesPerWeek(); // assigning a class will add that classesPerWeek to staff's numClasses
		requirements.remove(assignedClass);
		return true;
	}

	public boolean subClass(Class subAssignedClass, ListOfClassRequirements requirements){
		if(underMinClasses()){
			System.out.print("WARNING! This staff member is now under their minimum class requirements.");
		}
		this.assignedClasses.remove(subAssignedClass);
		this.numClasses -= subAssignedClass.getClassesPerWeek(); // removing a class will free up staff's numClasses
		requirements.add(subAssignedClass);
		return true;
	}

//	public void reassignRequirements(ListOfClassRequirements requirements){ // return all staff members classes to list of requirements, improve
//		if(this.numClasses == 0){
//			return;
//		}
//		for(Class class:assignedClasses){
//			requirements.add(class);
//			assignedClasses.remove(class);
//		}
//	}

	public String getName(){
		return this.name;
	}

	public String getSubjectArea(){
		return this.subjectArea;
	}

	public int getMaxClasses(){
		return this.maxClasses;
	}

	public int getMinClasses(){
		return this.minClasses;
	}

	public int getNumClasses(){
		return this.numClasses;
	}

	public boolean underMinClasses(){
		return this.numClasses < this.minClasses;
	}

	public void print(){
	}

	public boolean overMaxClasses(){
		return this.numClasses > this.maxClasses;
	}
}