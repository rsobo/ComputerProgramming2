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
}