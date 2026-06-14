package flags.argumentRequired;

public class Name implements FlagsCommandRequiredArgumentsRequired{
	private String name = System.getProperty("user.dir");
	
	public Name(Object name) {
		try {
			this.name = (String)name;
		}catch (ClassCastException e) {
			System.out.println("Name is not in string format");
		}catch (Exception e) {
			System.out.println("Unexpected error at Name.java flag");
			e.printStackTrace();
		}
	}

	@Override
	public String run() {
		// TODO Auto-generated method stub
		return name;
	}

}
