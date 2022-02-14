
public class Fish extends Animal{

	public Fish(String name, double weight) {
		super(name, weight);
	}
	
	@Override
	public void move() {
		System.out.println("swim swim swim...");
	}
}
