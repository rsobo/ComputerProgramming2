
public class PrintNumber implements Runnable{

	private int num;
	
	public PrintNumber(int num) {
		this.num = num;
	}
	@Override
	public void run() {
		for(int i = 0; i < num; i++) {
			System.out.println("Number " + num + ", Counter " + i);
		}
	}

}
