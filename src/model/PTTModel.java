package model;

import java.util.ArrayList;

public class PTTModel{ 

	private ClassDirector cdSession;
	private Admin adminSession;
	private PTTDirector pttSession;
	private ArrayList<ClassDirector> classDirectors = new ArrayList<>();
	private File_IO fileIO;
	private ListOfStaff listOfStaff;

	// must make it possible to have multiple class directors

	public PTTModel(){
	}

	public void initFileIO(){
		this.fileIO.readListOfStaff();
		this.listOfStaff = this.fileIO.getListOfStaff();
	}

	public void newClassDirectorSession(){ // Creates temp object for user session
		ClassDirector cdSession = new ClassDirector();
		this.classDirectors.add(cdSession); // allows access to list of requirements for each session
	}

	public void newAdminSession(){ // Creates temp object for user session
		Admin adminSession = new Admin();
	}

	public ArrayList<ClassDirector> getClassDirectors(){
		return this.classDirectors;
	}

	public void newPTTDirectorSession(){ // Creates temp object for user session
		PTTDirector pttSession = new PTTDirector();
	}

	public ClassDirector getCdSession(){
		return this.cdSession;
	}

	public Admin getAdminSession(){
		return this.adminSession;
	}

	public PTTDirector getPttSession(){
		return this.pttSession;
	}

	public File_IO getFileIO(){
		return this.fileIO;
	}

	public ListOfStaff getListOfStaff(){
		return this.listOfStaff;
	}
}