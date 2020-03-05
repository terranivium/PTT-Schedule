package model;

import java.io.*;
import java.util.ArrayList;

public class File_IO {
	private ListOfStaff listOfStaff;
	private String[] headers;
	private String[] attributes;
	private String classNames;

	public File_IO() { // Constructor
		this.listOfStaff = new ListOfStaff();
	}

	void readListOfStaff() { // reads cards from .txt file and creates card objects
		BufferedReader br = null;
		String filePath = new File("src/ListOfStaff.txt").getAbsolutePath(); // finds absolute path based off expected string
		try {
			br = new BufferedReader(new FileReader(filePath));
			String read = null;
			read = br.readLine(); // reads first line of text into a string array
			this.headers = read.split("\\s+");
			while ((read = br.readLine()) != null) { // while there is another line in the txt file to read
				attributes = read.split("\\s+");
				this.listOfStaff.add(new Staff(attributes[0], attributes[1], Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3])));
				classNames += attributes[1] + " ";
			}
			System.out.println("File successfully read.");
		} 

		catch (FileNotFoundException e) {
            System.err.println("ERROR! The file located at: [" + filePath + "] does not exist.");
		}

		catch (IOException e) {
			System.err.println("ERROR! Please check the file directory has been entered correctly or that the file exists.");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.err.println("ERROR! Could not close reader.");

				}
			}
			System.out.println("--- File Reading Finished ---");
		}
	}

	static void writeApprovedRequests(ArrayList<String> approvedRequests) { // reads cards from .txt file and creates card objects
		BufferedWriter bw = null;
		File file = new File("src/ListOfStaff.txt");
		String filePath = file.getAbsolutePath(); // finds absolute path based off expected string
		try {
			bw = new BufferedWriter(new FileWriter(filePath));
			bw.write("////////////////APPROVED TEACHING REQUESTS/////////////////\n"
			+"==========================================\n\n");
			for(String request : approvedRequests) {
				bw.write(request);
			}
			bw.close();
			file.renameTo(new File("approvedStaffForTraining.txt")); //renames file name
			System.out.println("Successfully wrote to file.");
		}
		catch (FileNotFoundException e) {
			System.err.println("ERROR! The file located at: [" + filePath + "] does not exist.");
		}
		catch (IOException e) {
			System.err.println("ERROR! Please check the file directory has been entered correctly or that the file exists.");
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.err.println("ERROR! Could not close file writer.");

				}
			}
			System.out.println("--- File Writing Finished ---");
		}
	}

//	protected static void writeApprovedRequests(ArrayList<String> approvedRequests){
//		try {
//			File teachingAssignments = new File("src/ApprovedAssignments.txt");
//			if (teachingAssignments.createNewFile()) {
//				System.out.println("File created: " + teachingAssignments.getName());
//			} else {
//				System.out.println("File already exists.");
//			}
//		} catch (IOException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}
//		try {
//
//			FileWriter assignmentWriter = new FileWriter("src/ApprovedAssignments.txt");
//			assignmentWriter.write(String.valueOf(approvedRequests));
//			assignmentWriter.close();
//			System.out.println("Successfully wrote to the file.");
//		} catch (IOException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}
//	}

		// Getter methods
	public ListOfStaff getListOfStaff() {
		return this.listOfStaff;
	}

	public String getClassNames(){ return this.classNames;}
}