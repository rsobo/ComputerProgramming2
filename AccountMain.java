package account;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountMain {

	private static Account account = new Account();
	
	public static void main(String[] args) {
		ExecutorService exeService = Executors.newFixedThreadPool(2);
		exeService.execute(() -> {
			try {
				account.deposit(5);
				while(true) {
					account.deposit((int) (Math.random() * 100 + 1));
					Thread.sleep(1000);
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		exeService.execute(() -> {
			while(true) {
				account.withdraw((int) (Math.random() * 100 + 1));
			}
		});
		exeService.shutdown();
	}

}
