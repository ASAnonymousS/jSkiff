package flags.argumentRequired;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class Directory implements FlagsCommandRequiredArgumentsRequired{
	private Path directory = Path.of(System.getProperty("user.dir"));
	
	public Directory(Object directory) {
		try {
			this.directory = Path.of((String)directory);
		}catch(ClassCastException e) {
			System.out.println("Path is not a string object");
		}catch (InvalidPathException e) {
			System.out.println("Path is not parsable, re-check it");
		}catch (IllegalArgumentException e) {
			System.out.println("Path is not a string, please write string value");
		}catch(NullPointerException e) {
			System.out.println("Path cannot be null value");
		}catch(Exception e) {
			System.out.println("Unexpected exception");
			e.printStackTrace();
		}
	}

	@Override
	public Path run() {
		// TODO Auto-generated method stub
		return directory;
	}

}
