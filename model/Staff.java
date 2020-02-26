import java.util.ArrayList;

public class Staff{

	private int maxClasses;
	private int minClasses;
	private ArrayList<Class> assignedClasses = new ArrayList<>();

	private String name;
	private String subjectArea;

	public Staff(String name, String subject, int maxClasses, int minClasses){
		this.name = name;
		this.subjectArea = subjectArea;

		this.maxClasses = maxClasses;
		this.minClasses = minClasses;
	}

	ArrayList<Class> getAssignedClasses(){
		return this.assignedClasses;
	}

	void add(Class assignedClass) {
		if(overMaxClasses){
			System.out.print("This staff member cannot handle additional class responsibilities.");
			return;
		}
		this.assignedClasses.add(assignedClass);
	}

	void remove(Class subAssignedClass){
		if(underMinClasses){
			System.out.print("WARNING! This staff member is under their minimum hours spent.");
		}
		this.assignedClasses.remove(subAssignedClass);
	}

	void reassignRequirements(ListOfClassRequirements requirements){
		if(this.assignedClasses.size() == 0){
			return;
		}

		for(Class class:assignedClasses){
			requirements.add(class);
			assignedClasses.remove(class);
		}
	}

	String getName(){
		return this.name;
	}

	String getSubjectArea(){
		return this.subjectArea;
	}

	int getMaxClasses(){
		return this.maxClasses;
	}

	int getMinClasses(){
		return this.minClasses;
	}

	boolean underMinClasses(){
		if(this.assignedClasses.size() <= minClasses){
			return true;
		}
		return false;
	}

	boolean overMaxClasses(){
		if(this.assignedClasses.size() >= maxClasses){
			return true;
		}
		return false;
	}

}