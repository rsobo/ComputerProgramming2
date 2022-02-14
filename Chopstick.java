package diningphilosophers;

public class Chopstick {

	private int id;
	private boolean inUse;
	
	//constructor
	public Chopstick(int id) {
		this.id = id;
		inUse = false;
	}
	
	//puts down the chopstick
	public synchronized void release() {
		System.out.println("Chopstick   id: " + id + " has been set down");
		inUse = false;
	}
	
	//picks up the chopstick
	public synchronized void take() {
		System.out.println("Chopstick   id: " + id + " has been picked up");
		inUse = true;
	}
	
	//returns the variable inUse
	public boolean inUse() {
		return inUse;
	}
}
