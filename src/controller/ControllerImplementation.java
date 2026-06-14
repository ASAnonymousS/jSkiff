package controller;

import flags.global.Help;
import input.Input;
import input.InputValidator;
import input.InputValidatorImplementation;

public class ControllerImplementation implements Controller{
	Input input;
	Object[] parsedInput;
	
	public ControllerImplementation(String[] args) {
		input = new Input(args);
	}

	@Override
	public void isInputValid() {
		InputValidator inputValidator = new InputValidatorImplementation(input);
		try{
			Object[] input = inputValidator.commandToIntegerParser();
			if(input != null){
				parsedInput = input;
			}
			else {
				new Help().run();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
