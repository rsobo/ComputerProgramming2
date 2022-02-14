import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithoutSync {
	private static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		// create executor
		// Create and launch 100 threads
		for (int i = 0; i < 100; i++) {
			executor.execute(new Runnable() {
				public void run() {
					account.deposit(1);
				}
			}); // submit task
		}
		executor.shutdown();
		// shut down executor
		// Wait until all tasks are finished
		while (!executor.isTerminated()) {
		}
		System.out.println("What is balance? " + account.getBalance());
	}
	// An inner class for account
	private static class Account {
		private static Lock lock = new ReentrantLock();
			private int balance = 0;
			public int getBalance() {return balance;}
			//public synchronized void deposit(int amount)
			public void deposit(int amount) {
				int newBalance = balance + amount;
				// This delay is deliberately added to magnify the
				// data-corruption problem and make it easy to see.
				try {Thread.sleep(5);} 
				catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				balance = newBalance;}
		}
}