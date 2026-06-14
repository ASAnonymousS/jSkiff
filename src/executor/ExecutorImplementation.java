package executor;

import commands.*;
import flags.*;

public class ExecutorImplementation implements Executor{
	private final Object[] input;
	
	public ExecutorImplementation(Object[] input) {
		this.input = input;
	}

	@Override
	public boolean isExecutable() {
		for(int i = 0; i<input.length; i++)
		{
			try{
				switch((int)input[i]) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 21:
					break;
				case 22:
					break;
				case 41:
					break;
				case 42:
					break;
				case 61:
					break;
				default: System.out.println("Oops you forgot to add the case for the newly implemented command " + (int)input[i] + " in the ExecutorImplementation Class");
					return false;
				}
			} catch(ClassCastException e) {
				System.out.println("Need to properly fix the code logic");
			}
		}
		return true;
	}

	@Override
	public void beginExecution() {
		
	}
	
	
}
