package diningphilosophers;

public class Philosopher implements Runnable{

	private int id;
	private Chopstick left;
	private Chopstick right;
	
	//constructor
	public Philosopher(int id, Chopstick left, Chopstick right) {
		this.id  = id;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void run() {
		while(true) {
			eat();
		}
	}
	
	//has the philosopher eat and then sleeps the thread for a random time
	public void eat() {
		try {
			synchronized(left){
				left.take();
				synchronized (right) {
					right.take();
					System.out.println("Philosopher id: " + id + " is eating");
					Thread.sleep((int) (Math.random()*3000));
					right.release();
				}
				left.release();
			}
			think();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//prints that a philosopher is thinking and then sleeps the thread for a random time
	public void think() {
		try {
			System.out.println("Philosopher id: " + id + " is thinking");
			Thread.sleep((int) (Math.random()*3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}