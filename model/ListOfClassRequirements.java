package model;

import java.util.ArrayList;
import java.util.Iterator;

// Generated by Class Director
public class ListOfClassRequirements{

	private ArrayList<Class> listOfClassRequirements = new ArrayList<>();
	private Iterator<Class> goThrough;

	public ListOfClassRequirements(){

	}

	public ArrayList<Class> getListOfClassRequirements(){
		return this.listOfClassRequirements;
	}

	public Iterator<Class> getGoThrough(){
		goThrough = this.listOfClassRequirements.iterator();
		return this.goThrough;
	}

	public void add(Class newRequirement) {
		this.listOfClassRequirements.add(newRequirement);
	}

	public void remove(Class subRequirement){
		this.listOfClassRequirements.remove(subRequirement);
	}

	public int requirementsRemaining(){
		return this.listOfClassRequirements.size();
	}

	public boolean requirementsMet(){
		if(this.requirementsRemaining() == 0){
			return true;
		}
		return false;
	}

	public String find(String search){ // See ClassDirector for find function to return Class
		for(Class curVal : listOfClassRequirements){
			if(curVal.getName().contains(search)){
				curVal.print();
			}
			if(curVal.getName().contains(search)) {
				curVal.print();
			}
		}
		return "Your search has returned empty...";
	}

	public String find(int search){ // See ClassDirector for find function to return Class
		for(Class curVal : listOfClassRequirements){
			if(curVal.getClassesPerWeek() == search){
				curVal.print();
			}
		}
		return "Your search has returned empty...";
	}

	public Class searchClass(String currSearch){
		for(Class selClass : this.listOfClassRequirements){ // .find function which will return a Class rather than a String
			if(selClass.getName().equals(currSearch)) {
				return selClass;
			}
		}
		return null;
	}

	public void print(){
		for(Class printVal : listOfClassRequirements){
			printVal.print();
		}
	}
}