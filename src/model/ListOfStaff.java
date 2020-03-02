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
	}

	public void find(String search){
		for(Staff curVal : this.listOfStaff){
			if(curVal.getName().contains(search)){
				curVal.print();
			}
			if(curVal.getSubjectArea().contains(search)){
				curVal.print();
			}
//			if(curVal.getMaxClasses().contains(search)){
//				return curVal.print();
//			}
//			if(curVal.getMinClasses().contains(search)){
//				return curVal.print();
//			}
//			if(curVal.getNumClasses().contains(search)){
//				return curVal.print();
//			}
			if(curVal.getAssignedClasses().contains(search)){
				curVal.print();
			}
		}
		// view no results returned
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