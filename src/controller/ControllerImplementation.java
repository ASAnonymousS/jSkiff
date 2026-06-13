package controller;

import java.util.Arrays;

import help.HelpMenu;
import input.Input;
import input.InputValidator;
import input.InputValidatorImplementation;

public class ControllerImplementation implements Controller{
	Input input;
	
	public ControllerImplementation(String[] args) {
		input = new Input(args);
	}

	@Override
	public String isInputValid() {
		InputValidator inputValidator = new InputValidatorImplementation(input);
		try{
			Object[] input = inputValidator.commandToIntegerParser();
			if(input != null){
				if((int)input[0] == 5) {
					HelpMenu.displayManualPage();
				}
			}
			else {
				HelpMenu.displayShortHelpMenu();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
