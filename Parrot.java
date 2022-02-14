
public class Parrot extends Bird implements iFly{
	
	public Parrot(String name, double weight) {
		super(name, weight);
	}
	
	@Override
	public void fly() {
		System.out.println(name + " is Flying...");
	}

}
