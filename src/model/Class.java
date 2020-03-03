package model;

public class Class{

	private String name; // must match Staff subject area
	private int classesPerWeek;

	public Class(String name, int classesPerWeek){
		this.name = name;
		this.classesPerWeek = classesPerWeek;
	}

	public String getName(){
		return this.name; 
	}

	public int getClassesPerWeek(){
		return this.classesPerWeek;
	}

	public void print(){
		System.out.printf("Class Subject: %s | Classes per week: %d", this.name, this.classesPerWeek);
	}
}