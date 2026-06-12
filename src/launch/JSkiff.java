package launch;

import controller.Controller;
import controller.ControllerImplementation;

public class JSkiff {
	public static void main(String[] args) {
		Controller controller = new ControllerImplementation(args);
		controller.isInputValid();
	}
}
