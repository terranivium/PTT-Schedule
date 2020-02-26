public class ClassDirector extends Staff{

	private ListOfClassRequirements listOfClassRequirements = new ListOfClassRequirements();

	public ClassDirector(){
	}

	ListOfRequirements getListOfClassRequirements(){
		return this.listOfCLassRequirements;
	}

	void newClassRequirement(Class newRequirement){
		this.listOfClassRequirements.add(newRequirement);
	}

	void subClassRequirement(Class subRequirement){
		this.listOfClassRequirements.remove(subRequirement);
	}


}