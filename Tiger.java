
public class Tiger extends Animal{

	public Tiger(String name, double weight) {
		super(name, weight);
	}
	
	@Override
	public void eat() {
		System.out.println("Eating meat...");
	}
	@Override
	public void move() {
		System.out.println("Flap feathery wings...");
	}
	
}