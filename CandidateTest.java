package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exceptions.MinimumAgeException;
import votingsystem.Candidate;

class CandidateTest {
	@Test
	void Candidate_under25_throwsMinimumAgeException() {
		// Checks if MinimumAgeException is thrown
		assertThrows(MinimumAgeException.class, () -> {new  Candidate(18, 'M', "Some", "Candidate", "Non-Affiliate");});
	}
	
	@Test
	void getAge_returns_35() throws MinimumAgeException {
		Candidate c1 = new Candidate(35, 'M', "Some", "Candidate", "Non-Affiliate");
		assertEquals(c1.getAge(), 35);
	}
	
	@Test
	void getVoteCount_returns_0() throws MinimumAgeException {
		Candidate c1 = new Candidate(25, 'M', "Some", "Candidate", "Non-Affiliate");
		assertEquals(c1.getVoteCount(), 0);
	}
	
	@Test
	void getVoteCount_returns_1() throws MinimumAgeException {
		Candidate c1 = new Candidate(25, 'M', "Some", "Candidate", "Non-Affiliate");
		c1.incrementVoteCount();
		assertEquals(c1.getVoteCount(), 1);
	}
	
	@Test
	void gender_setsto_F() throws MinimumAgeException {
		Candidate c1 = new Candidate(25, 'F', "Some", "Candidate", "Non-Affiliate");
		c1.incrementVoteCount();
		assertEquals(c1.getGender(), 'F');
	}
	
	@Test
	void getFullName_returns_SomeSmithR() throws MinimumAgeException {
		Candidate c1 = new Candidate(31, 'M', "Some", "Smith", "Republican");
		assertEquals(c1.getFullName(), "Some Smith - R");
	}
	
	@Test
	void getFullName_returns_JohnCandidateD() throws MinimumAgeException {
		Candidate c1 = new Candidate(25, 'M', "John", "Candidate", "Democrat");
		assertEquals(c1.getFullName(), "John Candidate - D");
	}
}
