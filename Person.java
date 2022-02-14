package votingsystem;

public abstract class Person {

	//creates a new person object
	private int age;
	private char gender;
	protected String firstName, lastName, politicalParty;
	public Person(int age, char gender, String firstName, String lastName, String politicalParty) {
		this.age = age;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.politicalParty = politicalParty;
	}
	
	//returns age
	public int getAge() {
		return age;
	}
	
	//returns gender
	public char getGender() {
		return gender;
	}
	
	//full name abstract function
	public abstract String getFullName();
}
