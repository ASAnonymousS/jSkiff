package executor;

import commands.*;
import flags.*;
import flags.argumentRequired.*;
import flags.global.*;
import flags.commandRequired.*;

public class ExecutorImplementation implements Executor{
	private final Object[] input;
	private Commands commands = null;
	private Flags flags = null;
	
	public ExecutorImplementation(Object[] input) {
		this.input = input;
	}

	@Override
	public void beginExecution() {
		if(!isExecutable())
			return;
		
	}
	
	//This function is meant to return false only if some new command or flag is added in the input section and it is not being reflected over here.
	private boolean isExecutable() {
		boolean isExecutable = true;
		if(!parseCommandOrGlobalFlag())
			isExecutable = false;
		else if(!parseOptionalFlags())
			isExecutable = false;
		
		
		return isExecutable;
	}
	
	private boolean parseCommandOrGlobalFlag() {
		try{
			switch((int)input[0]) {
			// Commands section
			case 1: commands = new Init();
				break;
			case 2: commands = new Build();
				break;
			case 3: commands = new Run();
				break;
			case 4: commands = new Free();
				break;
			case 5: commands = new Manual();
				break;
			// Global Flags section
			case 21: flags = new Help();
				break;
			case 22: flags = new Version();
				break;
			default:
				System.out.println("Your new command or global flag "+ (int)input[0] +" is not added to the command list at ExecutorImplementation Class");
				return false;
			}
			return true;
		} catch(ClassCastException e) {
			System.out.println("You have enterd an argument instead of command or global flag first");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean parseOptionalFlags() {
		if(input.length == 1)
			return false;
		else
			for(int i = 1; i<input.length; i++) {
				try{
					switch((int)input[i]) {
					// Command Required section
					case 41: flags = new Watch();
						break;
					// Argument Required section
					case 61: flags = new Name(input[i+1]);
						break;
					case 62: flags = new Directory(input[i+1]);
						break;
					default:
						System.out.println("Your new command or global flag "+ (int)input[0] +" is not added to the command list at ExecutorImplementation Class");
						return false;
					}
					return true;
				} catch(ClassCastException e) {
					System.out.println("You have enterd an argument instead of command or global flag first");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return true;
	}
}
