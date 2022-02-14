package diningphilosophers;

import java.util.ArrayList;

public class DiningPhilosophers {
	
	public static void main(String[] args) {
		ArrayList<Chopstick> chop = new ArrayList<>();
		ArrayList<Philosopher> phil = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			chop.add(new Chopstick(i));
		}
		//adds the philosophers to the to the array list with each assigned chopstick
		//then loops through and creates a thread and starts each thread
		phil.add(new Philosopher(0, chop.get(0), chop.get(1)));
		phil.add(new Philosopher(1, chop.get(1), chop.get(2)));
		phil.add(new Philosopher(2, chop.get(2), chop.get(3)));
		phil.add(new Philosopher(3, chop.get(3), chop.get(4)));
		phil.add(new Philosopher(4, chop.get(0), chop.get(4)));
		phil.forEach(p -> new Thread(p).start());
	}
}
