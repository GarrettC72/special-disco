package arrays;

public class Person {
	
	public static final String[] FIRST_START = {"Chr", "Ma","L","Gr","Ph","B","Th"};
	public static final String[] FIRST_MIDDLE = {"isti", "cha","era","eta","ala","ina","ara"};
	public static final String[] FIRST_END = {"", "na","n","r","tian","s","rs","mp","les"};
	
	public static final String[] LAST_START = {"Tr", "Br","L","Gr","Sh","B","Th"};
	public static final String[] LAST_MIDDLE = {"om", "o","an","ola","et","e","is"};
	public static final String[] LAST_END = {"", "son","ers","rian","ston","ck","sk"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	
	public Person(String firstName, String lastName, Borough home) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.home = home;
	}
	
	public String toString() {
		return "My name is " + firstName + " " + lastName + " and I live in " + home + ".";
	}
}
