package model;

import java.io.*;

public class File_IO {
	private ListOfStaff listOfStaff;
	private String[] headers;

	public File_IO() { // Constructor
		this.listOfStaff = new ListOfStaff();
	}

	void readListOfStaff() { // reads cards from .txt file and creates card objects
		BufferedReader br = null;
		String filePath = new File("ListOfStaff.txt").getAbsolutePath(); // finds absolute path based off expected string
		try {
			br = new BufferedReader(new FileReader(filePath));
			String read = null;
			read = br.readLine(); // reads first line of text into a string array
			this.headers = read.split("\\s+");
			while ((read = br.readLine()) != null) { // while there is another line in the txt file to read
				String[] attributes = read.split("\\s+");
				this.listOfStaff.add(new Staff(attributes[0], attributes[1], attributes[2], attributes[3]));
			}
			System.out.println("File successfully read.");
		} 

		catch (FileNotFoundException e) {
            System.err.println("ERROR! The file located at: [" + filePath + "] does not exist.");
		}

		catch (IOException e) {
			System.err.println("ERROR! Please check the file directory has been entered correctly or that the file exists.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
	
	// Getter methods
	public ListOfStaff getListOfStaff() {
		return this.listOfStaff;
	}
}