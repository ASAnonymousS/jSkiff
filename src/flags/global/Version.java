package flags.global;

import java.util.List;

public class Version implements FlagsGlobal {
	private final Integer majorVersion = 0;
	private final Integer minorVersion = 0;
	private final Integer patchVersion = 0;
	private final List<String> version= List.of(majorVersion.toString(), minorVersion.toString(), patchVersion.toString());
	
	@Override
	public Boolean run() {
		System.out.println(String.join(".", version));
		return null;
	}
	
	
}
