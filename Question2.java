package parallel;
/** Course: COP 3809C.02
* @author Ryan Sobolewski 
* Purpose: Classwork 2
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question2 {

	private static Integer sum = new Integer(0);
	
	public static void main(String[] args) {
		int num = 0;
		ExecutorService exeService = Executors.newFixedThreadPool(1000);
		for(int i = 0; i < 1000; i++) {
			exeService.execute(new Add(i));
		}
		exeService.shutdown();
		System.out.println("with sync");
	}
	
	private static class Add implements Runnable{

		int num = 0;
		public Add(int num) {
			this.num = num;
		}
		@Override
		public synchronized void run() {
			sum++;
			System.out.println("Thread #" + num + " and sum is " + sum);
		}
		
	}

}
