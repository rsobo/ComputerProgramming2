import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(3);
		exe.execute(new PrintNumber(10));
		exe.execute(new PrintNumber(20));
		exe.execute(new PrintNumber(100));
		exe.shutdown();
		
	}
}
