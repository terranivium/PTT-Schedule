package model;

import java.util.ArrayList;

public class ListOfClassAssignments{ // Idea for PTT directors list to approve
	private ArrayList<Staff> staff;
	private ArrayList<Class> allStaffAssignments;
	private boolean pttDirectorSignOff;
	private ArrayList<String> teachingRequests;

	public ListOfClassAssignments(ListOfStaff staff){
		this.staff = staff.getListOfStaff();
		this.pttDirectorSignOff = false;
		this.allStaffAssignments = new ArrayList<>();
		this.teachingRequests = new ArrayList<String>();
	}

	public void bundleAllClasses(){ // retrieve all classes assigned to every staff member and combine to single list
		String teachingRequest;
		for(Staff member : this.staff) {
			if (!member.getAssignedClasses().isEmpty()) {
				teachingRequest = "NAME: " + member.getName() + "  ||   SUBJECT: " + member.getSubjectArea()
						+ "\nMIN CLASS:" + member.getMinClasses() + "  ||   MAX CLASS: " + member.getMaxClasses()
						+ "\n==========================================\n";
				for (Class assigned : member.getAssignedClasses()) {
					teachingRequest += "CLASS: " + assigned.getName() + "  ||   CLASSES/W: " + assigned.getClassesPerWeek() + "\n";
				}
				this.teachingRequests.add(teachingRequest);
			}
		}
	}

	public ArrayList<String> getTeachingRequests(){
		return this.teachingRequests;
	}

	public ArrayList<Staff> getStaff(){
		return this.staff;
	}

}