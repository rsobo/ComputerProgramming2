
public abstract class Animal {

	protected String name;
	private double weight;
	public Animal(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public void getInfo() {
		System.out.println("This is " + name + ". They weigh " + weight + " lbs.");
	}
	
	public void eat() {
		System.out.println("Eating...");
	}
	
	public void sleep() {
		System.out.println("am slep...");
	}
	
	public abstract void move();
	
	
}