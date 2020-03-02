package model;

public class ClassDirector{

	private ListOfClassRequirements listOfClassRequirements = new ListOfClassRequirements();

	public ClassDirector(){ // Creates a ListOf Requirements
	}

	public ListOfClassRequirements getListOfClassRequirements(){
		return this.listOfClassRequirements;
	}

	public void newClassRequirement(Class newRequirement){
		this.listOfClassRequirements.add(newRequirement);
	}

	public void subClassRequirement(Class subRequirement){
		this.listOfClassRequirements.remove(subRequirement);
	}
}