package votingsystem;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.CandidateNotFoundException;
import exceptions.MinimumAgeException;
import exceptions.MissingCandidateException;

public class Election {

	// runs the election
	public static void main(String[] args) {
		
		try {
			//creates scanner
			Scanner in = new Scanner(System.in);
			int i = 1;
			ArrayList<Candidate> candidate = new ArrayList<Candidate>();
			//creates candidates
			while(i == 1) {
				System.out.println("Enter candidate's first name: ");
				String firstName = in.next();
				System.out.println("Enter candidate's last name: ");
				String lastName = in.next();
				System.out.println("Enter candidate's age: ");
				int age = in.nextInt();
				System.out.println("Enter candidate's gender: ");
				char gender = in.next().charAt(0);
				System.out.println("Enter candidate's political party: ");
				String party = in.next();
				Candidate c = new Candidate(age, gender, firstName, lastName, party);
				candidate.add(c);
				System.out.println("Would you like to enter another candidate? (Enter 1 if yes)");
				i = in.nextInt();
				VotingMachine vm = new VotingMachine(candidate);
				i = 1;
				//creates voter and lets them vote
				while(i == 1) {
					System.out.println("Enter voters ID: ");
					int id = in.nextInt();
					System.out.println("Enter voters first name: ");
					firstName = in.next();
					System.out.println("Enter voters last name: ");
					lastName = in.next();
					System.out.println("Enter voters age: ");
					age = in.nextInt();
					System.out.println("Enter voters gender: ");
					gender = in.next().charAt(0);
					System.out.println("Enter voters political party: ");
					party = in.next();
					Voter v;
					v = new Voter(id, age, gender, firstName, lastName, party);
					System.out.println("Who does " + v.getFullName() + " vote for?");
					int x = in.nextInt();
					vm.vote(v, candidate.get(x));
				}
				
				System.out.println("Would you like to enter another voter? (Enter 1 if yes)");
				i = in.nextInt();
			}
			
		} catch (MissingCandidateException|CandidateNotFoundException|MinimumAgeException e) {
			e.printStackTrace();
		}
	}

}
