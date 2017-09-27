package attendance;

public class Student implements Attendee {
	
	private String firstName;
	private String lastName;
	private boolean present = false;

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public boolean isPresent() {
		return present;
	}
	
	public void setPresent(boolean present) {
		this.present = present;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public boolean matches(String first, String last) {
		return firstName.equals(first) && lastName.equals(last);
	}
	
	public boolean matches(String last) {
		return lastName.equals(last);
	}
	
	public String getReportString() {
		String shortS1 = lastName;
		if (lastName.length() > 20) {
			shortS1 = lastName.substring(0,17) + "...";
		}
		while (shortS1.length() < 20) {
			shortS1 += " ";
		}
		if (firstName.length() > 20) {
			shortS1 += firstName.substring(0,17) + "...";
		}
		else {
			shortS1 += firstName;
		}
		while (shortS1.length() < 40) {
			shortS1 += " ";
		}
		if (present) {
			shortS1 += "PRESENT";
		}
		else {
			shortS1 += "ABSENT";
		}
		return shortS1;
	}
}
