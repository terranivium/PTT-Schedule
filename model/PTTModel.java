package model;

public class PTTModel{ 

	private ClassDirector cdSession;
	private PTTDirector pttSession;
	private File_IO fileIO = new File_IO();
	private ListOfStaff listOfStaff;

	// must make it possible to have multiple class directors

	public PTTModel(){
		try{
			this.initFileIO();
		} catch(Exception e){
			System.out.print("File Read Error...");
		}
	}

	public void initFileIO(){
		this.fileIO.readListOfStaff();
		this.listOfStaff = this.fileIO.getListOfStaff();
	}

	public void newClassDirectorSession(){ // Creates temp object for user sessions
		this.cdSession = new ClassDirector();
	}

	public void newPTTDirectorSession(){ // Creates temp object for user session
		this.pttSession = new PTTDirector();
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