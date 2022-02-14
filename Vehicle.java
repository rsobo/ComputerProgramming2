/**
 * Course: COP 3809C
 * @author Ryan Sobolewski
 * Purpose: HW1
 */

public class Vehicle {    
	private String vehicleType;    
	private int numberOfWheels;
   
	// Constructor for class Vehicle    
	// Sets the vehicle type and number of wheels    
	public Vehicle(String vehicleType, int numberOfWheels) {        
		this.vehicleType = vehicleType;        
		this.numberOfWheels = numberOfWheels;    
	}    
	
	public String getVehicleType(){
	        return vehicleType;    
	}    

	public int getNumberOfWheels(){
	        return numberOfWheels;    
	}
	
	public void move() {
		System.out.println("Driving forward at 10 mph");
	}
}