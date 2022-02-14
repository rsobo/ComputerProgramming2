
public class TaskThreadDemo {

	public static void main(String args[]) {
		//creates tasks
		PrintNumber print10 = new PrintNumber(10);
		Runnable print20 = new PrintNumber(20);
		
		Thread thread1 = new Thread(print10);
		Thread thread2 = new Thread(print20);
		Thread thread3 = new Thread(new PrintNumber(100));
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
