import java.util.ArrayList;

public class FinalExamThreads {

	static int sum = 0;

	public static void main(String[] args) {
		//creates an array list of 800 threads
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for(int i = 0; i < 800; i++) {
			//loops through each thread and adds it the list list. It also gets the random num and adds it to the sum
			threads.add(new Thread(() -> {
				sum += (int) (Math.random() * 50 + 1);
			}));
		}
		//loops through the list of threads to start them
		threads.forEach(e -> {
			e.start();
		});
		System.out.println(sum);
	}

}
