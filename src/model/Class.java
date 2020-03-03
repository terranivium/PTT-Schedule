package model;

public class Class{

	private String name;
	private String subjectArea;
	private int classesPerWeek;

	public Class(String name, int classesPerWeek){
		this.name = name;
		this.classesPerWeek = classesPerWeek;
	}

	public String getName(){
		return this.name; 
	}

	public String getSubjectArea(){
		return this.subjectArea;
	}

	public int getClassesPerWeek(){
		return this.classesPerWeek;
	}

	public void print(){

	}
}