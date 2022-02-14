package votingsystem;

import java.util.ArrayList;

import exceptions.CandidateNotFoundException;
import exceptions.MissingCandidateException;

public class VotingMachine {

	//creates new voting machine object
	private ArrayList<Candidate> candidates = new ArrayList<Candidate>();
	public VotingMachine(ArrayList<Candidate> candidates) throws MissingCandidateException {
		this.candidates = candidates;
		if(candidates == null || candidates.isEmpty()) {
			//throws exception if the caniddate list is null/empty
			throw new MissingCandidateException("The candidate list cannot be null or empty");
		}
	}
	
	//lets a voter vote if they havent already and if the canididate is in the list	
	public void vote(Voter v, Candidate c) throws CandidateNotFoundException {
		if(v.hasVoted() == false && candidates.contains(c)) {
			c.incrementVoteCount();
			v.voted();
		}
		else if(!candidates.contains(c)) {
			//throws exception if the candidate is not in the list
			throw new CandidateNotFoundException("Candidate does not exist in the caniddates collection");
		}
	}
	
	//prints out all candidates and their votes and the winner
	public void tally() {
		candidates.forEach((n) -> System.out.println(n.getFullName() + " has " + n.getVoteCount() + " votes."));
		int votes = -1;
		int index = 0;
		//loops through candidate list checking vote #
		for(int i = 0; i < candidates.size(); i++) {
			if(candidates.get(i).getVoteCount() > votes) {
				votes = candidates.get(i).getVoteCount();
				index = i;
			}
		}
		System.out.println(candidates.get(index).getFullName() + " won with " + votes + " votes.");
	}
}
