import model.*;
import controller.*;
import view.*;

public class AssExMain{
	public static void main(String[] args) throws InterruptedException {
		PTTModel model = new PTTModel();
		PTTView view = new PTTView(model);
		PTTController controller = new PTTController(model, view);

		controller.runtimeMenu();
	}
}