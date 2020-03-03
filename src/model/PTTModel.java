package model;

import java.util.ArrayList;

public class PTTModel{ 

	private ClassDirector cdSession;
	private PTTDirector pttSession;
	private File_IO fileIO;
	private ListOfStaff listOfStaff;

	// must make it possible to have multiple class directors

	public PTTModel(){
		this.fileIO = new File_IO();
	}

	public void initFileIO(){
		this.fileIO.readListOfStaff();
		this.listOfStaff = this.fileIO.getListOfStaff();
	}

	public void newClassDirectorSession(){ // Creates temp object for user session
		this.cdSession = new ClassDirector();
	}

	public void newPTTDirectorSession(){ // Creates temp object for user session
		PTTDirector pttSession = new PTTDirector();
	}

	public ClassDirector getCdSession(){
		return this.cdSession;
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