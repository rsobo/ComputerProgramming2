package account;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

	private static Lock lock = new ReentrantLock();
	private static Condition newDeposit = lock.newCondition();
	
	private int balance = 0;
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int amount) {
		lock.lock();
		try {
			//check balance
			while(balance < amount) {
				System.out.println("Waiting for a deposit");
				newDeposit.await();
			}
			balance -= amount;
			System.out.println("Withdrew $" + amount + ", new balance is $" + getBalance());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			//lock.unlock();
		}
	}
	
	public void deposit(int amount) {
		lock.lock();
		try {
			balance += amount;
			System.out.println("Deposited $" + amount + ", new balance is $" + getBalance());
			newDeposit.signalAll();
		}finally {
			lock.unlock();
		}
	}
	
}
