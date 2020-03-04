package model;

import java.util.ArrayList;

public class PTTDirector{
	private ListOfClassAssignments teachingRequests;
	private ArrayList<String> approvedRequests;
	private ArrayList<String> unapprovedRequests;

	public PTTDirector() {
		this.approvedRequests = new ArrayList<String>();
		this.unapprovedRequests = new ArrayList<String>();
	}

	public void approveRequest(String teachingRequest){
		this.approvedRequests.add(teachingRequest);
		}

	public void declineRequest(String teachingRequest){
		this.unapprovedRequests.add(teachingRequest);
	}

	public void sendToFile(){
		if(!approvedRequests.isEmpty()) {
			File_IO.writeApprovedRequests(this.approvedRequests);
		}
		else{
			System.err.println("There are no requests to write to the file.");
		}

		}

	}

