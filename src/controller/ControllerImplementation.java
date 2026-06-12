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
			int[] input = inputValidator.commandToIntegerParser();
			System.out.println(Arrays.toString(input));
			
		}catch (NullPointerException e) {
			System.out.println("Help Menu");
		}
		return null;
	}
}
