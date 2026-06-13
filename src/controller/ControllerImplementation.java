package controller;

import java.util.Arrays;

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
				System.out.println(Arrays.toString(input));
			}
			else {
				System.out.println("Help Menu");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
