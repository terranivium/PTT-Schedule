import model.*;
import view.*;

public class PTTView{

	private PTTModel model;
	private PTTView view;

	public PTTView(PTTModel model){
		this.model = model;
	}

	public void drawMain(){
		System.out.println("\n----------------------------------");
		System.out.println("| PTT Schedule App, cli_ver. 1.0 |");
		System.out.println("----------------------------------");
		System.out.println("	Select user mode...");
		System.out.println("		1. Class Director");
		System.out.println("		2. Administrator");
		System.out.println(" 		2. PTT Director");
		System.out.println("		4. Quit");
		System.out.println("----------------------------------");
	}

	public void fileOutputConfirmation() {
		System.out.println("Writing to .txt file in root folder...\n"); // change with actula filename
	}

	public void fileInputConfirmation() {
		System.out.println("Reading from .txt file in root folder...\n"); // change with actula filename
	}

	public void notValid() {
		System.out.println("Please select a valid menu option...");
	}
}