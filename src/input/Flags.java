package input;

enum Flags {
	HELP("-h","--help",false,false,21),
	VERSION("-v","--version",false,false,22),
	WATCHABLE("-w","--watch",true,false,41),
	NAME("-n","--name",true,true,61),
	DIRECTORY("-d","--directory",true,true,62);
	
	private final String shortForm;
	private final String fullForm;
	private final boolean isCommandRequired;
	private final boolean isArgumentRequired;
	private final int flagValue;

	private Flags(String shortForm, String fullForm, boolean isCommandRequired, boolean isArgumentRequired,
			int flagValue) {
		this.shortForm = shortForm;
		this.fullForm = fullForm;
		this.isCommandRequired = isCommandRequired;
		this.isArgumentRequired = isArgumentRequired;
		this.flagValue = flagValue;
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
		return flagValue;
	}
	
	public static Flags reverseMapper(String shortOrLongForm) {
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
