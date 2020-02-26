import model.*;
import view.*;

public class PTTController{

	private PTTModel model;
	private PTTView view;

	public PTTController(PTTModel model, PTTView view){
		this.model = model;
		this.view = view;
	}

	public void runtimeMenu(){
		this.view.drawMain();
	}

	public void runtimePTT(){
	}

	public void runtimeAdmin(){
	}

	public void runtimeClassDirector(){
	}
}