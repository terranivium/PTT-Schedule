package model;

import java.util.ArrayList;

// Generated via .txt file input
public class ListOfStaff{

	private ArrayList<Staff> listOfStaff = new ArrayList<>();

	public ListOfStaff(){
	}

	public ArrayList<Staff> getListOfStaff(){
		return this.listOfStaff;
	}

	public void add(Staff newStaff) {
		this.listOfStaff.add(newStaff);
	}

	public void remove(Staff subStaff){
		this.listOfStaff.remove(subStaff);
	} // unused in implementation.

	public void find(String search){
		for(Staff curVal : this.listOfStaff){
			if(curVal.getName().contains(search)){
				curVal.print();
			} else System.out.println("No matching staff name.");
			if(curVal.getSubjectArea().contains(search)){
				curVal.print();
			} else System.out.println("No matching subject area.");
		}
	}

	public Staff findStaff(String search){
		for(Staff curVal : this.listOfStaff){
			if(curVal.getName().equals(search)){
				return curVal;
			}
		}
		return null;
	}

	public void print(){
		for(Staff printVal : this.listOfStaff){
			printVal.print();
		}
	}
}