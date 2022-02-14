package votingsystem;

import exceptions.MinimumAgeException;

public class Voter extends Person {

	//creates new voter object
	private int voterID;
	private boolean voted;
	public Voter(int voterID, int age, char gender, String firstName, String lastName, String politicalParty) throws MinimumAgeException {
		super(age, gender, firstName, lastName, politicalParty);
		if(age < 18) {
			//throws exception is the voter is not 18+y/o
			throw new MinimumAgeException("Voter must be at least 18 years old");
		}
		this.voterID = voterID;
		this.voted = false;
	}

	//returns voter id #
	public int getVoterID() {
		return voterID;
	}
	
	//returns true if they have voted already
	public boolean hasVoted() {
		return voted;
	}
	
	//sets voted to true
	public void voted() {
		voted = true;
	}
	
	//overrides full name function
	@Override
	public String getFullName() {
		return super.firstName + " " + super.lastName;
	}

}
