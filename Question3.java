package parallel;

import java.util.concurrent.RecursiveTask;

/** Course: COP 3809C.02
 * @author Ryan Sobolewski 
 * Purpose: Classwork 2
 */

public class Question3 {

	public static void main(String[] args) {
		Runnable print10 = (Runnable) new PrintNTimes(10, "Thread 1");
		Runnable print20 = (Runnable) new PrintNTimes(20, "Thread 2");
		Runnable print100 = (Runnable) new PrintNTimes(100, "Thread 3");
		Thread thread1 = new Thread(print10);
		Thread thread2 = new Thread(print20);
		Thread thread3 = new Thread(print100);
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	private static class PrintNTimes implements Runnable{

		private int n = 0;
		private String name;
		public PrintNTimes(int n, String name) {
			this.n = n;
			this.name = name;
		}
		@Override
		public void run() {
			for(int i = 0; i < n; i++) {
				System.out.println(name + ": " + i);
			}
		}
		
	}

}
