package input;

public enum Commands {
	INIT(1,true),
	BUILD(2,true),
	RUN(3,true),
	FREE(4,true);
	
	private final int commandValue;
	private final boolean optionalArgumentsAllowed;
	
	private Commands(int commandValue, boolean optionalArgumentsAllowed) {
		this.commandValue = commandValue;
		this.optionalArgumentsAllowed = optionalArgumentsAllowed;
	}

	public int getCommandValue() {
		return commandValue;
	}

	public boolean isOptionalArgumentsAllowed() {
		return optionalArgumentsAllowed;
	}
}
