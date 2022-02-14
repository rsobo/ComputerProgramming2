
public class Zoo {

	public static void main(String[] args) {

		//Animal monkey = new Animal("Monkey", 20);
		Tiger tigger = new Tiger("Tiger", 300);
		Bird john = new Bird("Bird", 5);
		Parrot sam = new Parrot("Parrot", 6);
		tigger.getInfo();
		john.getInfo();
		sam.getInfo();
		sam.fly();
		System.out.println("---------------------------------");
		
		Parrot[] parrots = new Parrot[3];
		parrots[0] = new Parrot("Polly", 2.5);
		parrots[1] = new Parrot("Paul", 4);
		parrots[2] = new Parrot("Kathy", 1);
		
		for(int i = 0; i < parrots.length; i++) {
			parrots[i].fly();
		}
	}

}
