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

	public String find(String search){
		for(Staff curVal : listOfRequirements){
			if(curVal.getName().contains(search)){
				return curVal.print();
			}
			if(curVal.getSubjectArea().contains(search)){
				return curVal.print();
			}
			if(curVal.getMaxClasses().contains(search)){
				return curVal.print();
			}
			if(curVal.getMinClasses().contains(search)){
				return curVal.print();
			}
			if(curVal.getAssignedClasses().contains(search)){
				return curVal.print();
			}
		}
		return "Your search has returned empty...";
	}

	public void print(){
		for(Staff printVal : listOfRequirements){
			System.out.print(printVal.print() + "\n");
		}
	}
}