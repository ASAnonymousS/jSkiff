package input;

import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class InputValidatorImplementation implements InputValidator{
	Input input;
	private final Set<String> commands = new LinkedHashSet<String>(Arrays.stream(Commands.values())
																			.map(Commands::toString)
																			.map(String::toLowerCase)
																			.collect(Collectors.toCollection(LinkedHashSet::new)));
	private final Set<String> optionalArguments = new LinkedHashSet<String>();
	
	public InputValidatorImplementation(Input input) {
		this.input = input;
	}
	
	@Override
	public int[] commandToIntegerParser() {
		// TODO Auto-generated method stub
		LinkedList<Integer> parsedResult = new LinkedList<>();
		
		boolean isCommandFirstInput = isCommandFirstInput();
		boolean isOptionalArgumentPresent = isOptionalArgumentPresent();
		
		if(!isCommandFirstInput)
			return null;
		else {
			Commands command = Commands.valueOf(input.args()[0].toUpperCase());
			parsedResult.add(command.getCommandValue());
			
			return parsedResult.stream()
					.mapToInt(Integer::intValue)
					.toArray();
		}
	}

	private boolean isSingleCommandPresent() {
		// TODO Auto-generated method stub
		boolean singleCommand = false;
		for(String input : input.args())
			if(commands.contains(input) && !singleCommand)
				singleCommand = true;
			else
				return false;
		return singleCommand;
	}

	private boolean isOptionalArgumentPresent() {
		// TODO Auto-generated method stub
		for(String input : input.args())
			if(commands.contains(input))
				return true;
		return false;
	}
	
	private boolean isCommandFirstInput() {
		if(isSingleCommandPresent() && commands.contains(input.args()[0]))
			return true;
		return false;
	}
}
