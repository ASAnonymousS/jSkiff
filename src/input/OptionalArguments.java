package input;

public enum OptionalArguments {
	HELP("-h","--help",false,false,11),
	VERSION("-v","--version",false,false,12),
	NAME("-n","--name",false,true,13),
	DIRECTORY("-d","--directory",true,true,14),
	WATCHABLE("-w","--watch",true,false,15);
	
	private final String shortForm;
	private final String fullForm;
	private final boolean isCommandRequired;
	private final boolean isArgumentRequired;
	private final int optionalArgumentValue;

	private OptionalArguments(String shortForm, String fullForm, boolean isCommandRequired, boolean isArgumentRequired,
			int optionalArgumentValue) {
		this.shortForm = shortForm;
		this.fullForm = fullForm;
		this.isCommandRequired = isCommandRequired;
		this.isArgumentRequired = isArgumentRequired;
		this.optionalArgumentValue = optionalArgumentValue;
	}

	public String getShortForm() {
		return shortForm;
	}

	public String getFullForm() {
		return fullForm;
	}

	public boolean isCommandRequired() {
		return isCommandRequired;
	}


	public boolean isArgumentRequired() {
		return isArgumentRequired;
	}


	public int getOptionalArgumentValue() {
		return optionalArgumentValue;
	}
	
	public static OptionalArguments reverseMapper(String shortOrLongForm) {
		return switch (shortOrLongForm) {
		case "-h", "--help":
			yield HELP;
		case "-v", "--version":
			yield VERSION;
		case "-n", "--name":
			yield NAME;
		case "-d", "--directory":
			yield DIRECTORY;
		case "-w", "--watch":
			yield WATCHABLE;
		default:
			yield null;
//			throw new IllegalArgumentException("Unexpected value: " + shortOrLongForm);
		};
	}
}
