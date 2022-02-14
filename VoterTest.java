package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exceptions.MinimumAgeException;
import votingsystem.Voter;

class VoterTest {
	@Test
	void Voter_under18_throws_MinimumAgeException() {
		assertThrows(MinimumAgeException.class, () -> {new Voter(1, 17, 'M', "John", "Smith", "Non-Affiliate");});
	}
	
	@Test
	void getVoterId_returns_1() throws MinimumAgeException {
		Voter v1 = new Voter(1, 20, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(v1.getVoterID(), 1);
	}
	
	@Test
	void getVoterId_returns_2() throws MinimumAgeException {
		Voter v1 = new Voter(2, 20, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(v1.getVoterID(), 2);
	}
	
	@Test
	void getAge_returns_20() throws MinimumAgeException {
		Voter v1 = new Voter(1, 20, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(v1.getAge(), 20);
	}
	
	@Test
	void getAge_returns_30() throws MinimumAgeException {
		Voter v1 = new Voter(1, 30, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(v1.getAge(), 30);
	}
	
	@Test
	void gender_setsto_M() throws MinimumAgeException {
		Voter v1 = new Voter(1, 30, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(v1.getGender(), 'M');
	}
	
	@Test
	void getFullName_returns_JohnSmith() throws MinimumAgeException{
		Voter v1 = new Voter(1, 20, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(v1.getFullName(), "John Smith");
	}
	
	@Test
	void hasVoted_returns_false() throws MinimumAgeException {
		Voter v1 = new Voter(1, 20, 'M', "John", "Smith", "Non-Affiliate");assertFalse(v1.hasVoted());
	}
}
