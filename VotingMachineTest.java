package test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import exceptions.CandidateNotFoundException;
import exceptions.MinimumAgeException;
import exceptions.MissingCandidateException;
import votingsystem.Candidate;
import votingsystem.Voter;
import votingsystem.VotingMachine;

class VotingMachineTest {
	@Test
	void VotingMachine_Initializes_Candiates_IsEmpty() {
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		// Checks to make sure MissingCandidatesException is thrown for an empty list
		assertThrows(MissingCandidateException.class, () -> {
			new VotingMachine(candidates);
		});
	}

	@Test
	void VotingMachine_Initializes_Candiates_Null() {
		// Checks to make sure MissingCandidatesException is thrown for a null list
		assertThrows(MissingCandidateException.class, () -> {new VotingMachine(null);});
	}

	@Test
	void vote_counts_if_voter_has_not_voted() throws MissingCandidateException, MinimumAgeException, CandidateNotFoundException {
		// Define candidates for test
		Candidate janeDoe = new Candidate(35, 'F', "Jane", "Doe", "Republican");
		Candidate johnSmith = new Candidate(35, 'M', "John", "Smith", "Democrat");
		Candidate fredJohnson = new Candidate(35, 'M', "Fred", "Johnson", "Non-Affiliate");
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		candidates.add(janeDoe);
		candidates.add(johnSmith);
		candidates.add(fredJohnson);
		VotingMachine vm = new VotingMachine(candidates);
		assertEquals(janeDoe.getVoteCount(), 0);
		Voter v1 = new Voter(1, 20, 'M', "Martin", "Amis", "Non-Affiliate");
		vm.vote(v1, janeDoe);
		assertEquals(janeDoe.getVoteCount(), 1);
	}

	@Test
	void vote_does_not_counts_if_voter_has_voted() throws MissingCandidateException, MinimumAgeException, CandidateNotFoundException {
		// Define candidates for test
		Candidate janeDoe = new Candidate(35, 'F', "Jane", "Doe", "Republican");
		Candidate johnSmith = new Candidate(35, 'M', "John", "Smith", "Democrat");
		Candidate fredJohnson = new Candidate(35, 'M', "Fred", "Johnson", "Non-Affiliate");
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		candidates.add(janeDoe);
		candidates.add(johnSmith);
		candidates.add(fredJohnson);
		VotingMachine vm = new VotingMachine(candidates);
		assertEquals(janeDoe.getVoteCount(), 0);
		Voter v1 = new Voter(1, 20, 'M', "Martin", "Amis", "Non-Affiliate");
		vm.vote(v1, janeDoe);
		assertEquals(janeDoe.getVoteCount(), 1);
		vm.vote(v1, janeDoe);
		// Votes again
		assertEquals(janeDoe.getVoteCount(), 1);
	}

	@Test
	void tally_prints_correct_message() throws MissingCandidateException, MinimumAgeException, CandidateNotFoundException {
		// Set up to capture tally() print to terminal 
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		// Define candidates for test
		Candidate janeDoe = new Candidate(35, 'F', "Jane", "Doe","Republican");
		Candidate johnSmith = new Candidate(35, 'M', "John", "Smith", "Democrat");
		Candidate fredJohnson = new Candidate(35, 'M', "Fred", "Johnson","Non-Affiliate");
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		candidates.add(janeDoe);
		candidates.add(johnSmith);
		candidates.add(fredJohnson);
		VotingMachine vm = new VotingMachine(candidates);
		assertEquals(janeDoe.getVoteCount(), 0);
		Voter v1 = new Voter(1, 20, 'M', "Martin", "Amis", "Non-Affiliate");
		vm.vote(v1,janeDoe);
		vm.tally();
		assertEquals("Jane Doe - R has 1 votes.\r\n" +             "John Smith - D has 0 votes.\r\n" +             "Fred Johnson - NA has 0 votes.\r\n" +             "Jane Doe - R won with 1 votes.\r\n", outContent.toString());
	}
	
	@Test
	void vote_fails_if_candidate_not_in_collection() throws MissingCandidateException, MinimumAgeException {
		// Define candidates for test
		Candidate janeDoe = new Candidate(35, 'F', "Jane", "Doe", "Republican");
		Candidate johnSmith = new Candidate(35, 'M', "John", "Smith", "Democrat");
		Candidate fredJohnson = new Candidate(35, 'M', "Fred", "Johnson", "Non-Affiliate");
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		candidates.add(janeDoe);
		candidates.add(johnSmith);
		VotingMachine vm = new VotingMachine(candidates);
		assertEquals(fredJohnson.getVoteCount(), 0);
		Voter v1 = new Voter(1, 20, 'M', "Martin", "Amis", "Non-Affiliate");
		assertThrows(CandidateNotFoundException.class, () -> {vm.vote(v1, fredJohnson);});
		assertEquals(fredJohnson.getVoteCount(), 0);
	}
}