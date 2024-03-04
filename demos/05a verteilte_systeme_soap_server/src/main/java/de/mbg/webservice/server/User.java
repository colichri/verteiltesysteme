package de.mbg.webservice.server;

public class User {

	private String shortName;
	private String firstName;
	private String lastName;

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [shortName=" + shortName + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
