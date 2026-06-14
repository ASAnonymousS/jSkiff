package input;

import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.LinkedList;

public class InputValidatorImplementation implements InputValidator{
	Input input;
	private final Set<String> commands = new LinkedHashSet<String>(Arrays.stream(Commands.values())
																			.map(Commands::toString)
																			.map(String::toLowerCase)
																			.collect(Collectors.toCollection(LinkedHashSet::new)));
	private final Set<String> optionalArguments = new LinkedHashSet<String>(Stream.concat(Arrays.stream(Flags.values())
																								.map(Flags::getShortForm),
																						  Arrays.stream(Flags.values())
																								.map(Flags::getFullForm))
																						  .collect(Collectors.toCollection(LinkedHashSet::new)));
	
	public InputValidatorImplementation(Input input) {
		this.input = input;
	}
	
	@Override
	public Object[] commandToIntegerParser() {
		// TODO Auto-generated method stub
		List<Object> parsedResult = new LinkedList<>();
		
		int isCommandFirstInputOrGlobalArgument = isCommandFirstInputOrGlobalArgument();
		
		return switch (isCommandFirstInputOrGlobalArgument) {
		case 0: {
			Commands commands = Commands.valueOf(input.args()[0].toUpperCase());
			parsedResult.add(commands.getCommandValue());

			List<Object> optionalArguments= new LinkedList<>();
			for(int i = 1; i<input.args().length; i++)
			{
				if(Flags.reverseMapper(input.args()[i]) != null) {
					Flags currentArgument = Flags.reverseMapper(input.args()[i]);
					optionalArguments.add(currentArgument.getOptionalArgumentValue());
					if(currentArgument.isArgumentRequired() && ++i < input.args().length)
						optionalArguments.add(input.args()[i]);
					else
						yield null;
				}
			}

			yield Stream.concat(parsedResult.stream(), optionalArguments.stream())
					.toArray();
		}
		case 1: {
			Flags optionalArguments = Flags.reverseMapper(input.args()[0]);
			parsedResult.add(optionalArguments.getOptionalArgumentValue());
			
			yield parsedResult.stream()
					.toArray();
		}
		default:
			yield null;
		};
	}

	private boolean isSingleCommandPresent() {
		// TODO Auto-generated method stub
		boolean singleCommand = false;
		for(String input : input.args())
			if(commands.contains(input))
			{
				if(!singleCommand)
					singleCommand = true;
				else
					return false;
			}
		return singleCommand;
	}

	private boolean isOptionalArgumentPresent() {
		// TODO Auto-generated method stub
		for(String input : input.args())
			if(optionalArguments.contains(input))
				return true;
		return false;
	}
	
	private boolean isGlobalArgumet(String globalArgument) {
		Flags optionalArguments = Flags.reverseMapper(globalArgument.toLowerCase());
		if(optionalArguments.isCommandRequired() == false && optionalArguments.isArgumentRequired() == false)
			return true;
		return false;
	}
	
	private int isCommandFirstInputOrGlobalArgument() {
		if(isSingleCommandPresent() && commands.contains(input.args()[0]))
			return 0;
		else if(isOptionalArgumentPresent() && isGlobalArgumet(input.args()[0]))
			return 1;
		return 2;
	}
}
