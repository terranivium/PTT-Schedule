package model;

public class ListOfClassAssignments{ // Idea for PTT directors list to approve
	
	private ArrayList<Class> allStaffAssignments = new ArrayList<>();
	private boolean pttDirectorSignOff = false;

	public ListOfClassAssignments(){
		this.pttDirectorSignOff = pttDirectorSignOff;
		this.allStaffAssignments = allStaffAssignments;
	}

	public void addAllAssignedClasses(ListOfStaff master){ // retrieve all classes assigned to every staff member and combine to single list
		for(Staff staff:master){
			for(Class assigned:staff.getAssignedClasses()){
				this.allStaffAssignments.add(assigned);
			}
		}
	}
}