package votingsystem;

import exceptions.MinimumAgeException;

public class Candidate extends Person{

	//creates new Candidate object
	private int voteCount;
	public Candidate(int age, char gender, String firstName, String lastName, String politicalParty) throws MinimumAgeException {
		super(age, gender, firstName, lastName, politicalParty);
		if(age < 25) {
			//throws exception if the candidate is not 25 y/o
			throw new MinimumAgeException("Candidate must be at least 25 years old");
		}
		this.voteCount = 0;
	}
	
	//returns # of votes the candidate has
	public int getVoteCount() {
		return voteCount;
	}
	
	//increases voteCount by 1
	public void incrementVoteCount() {
		voteCount++;
	}
	
	//returns full name + political party
	public String getFullName() {
		String party = super.politicalParty.substring(0, 1);
		switch (party) {
			case "D":
				return super.firstName + " " + super.lastName + " - " + party;
			case "R":
				return super.firstName + " " + super.lastName + " - " + party;
			case "N":
				return super.firstName + " " + super.lastName + " - NA";
			default:
				return super.firstName + " " + super.lastName;
		}
	}
	
}
