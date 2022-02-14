/**
 * Course: COP 3809C.02
 * @author Ryan Sobolewski 
 * Purpose: Programming Assignment 2
 */
package solarsystem;

import exceptions.InvalidCelestialBodyException;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Moon extends CelestialBody implements iOrbit{

	//Creates a Moon Object that extends CelestialBody that takes in a name and an orbiting body
	//throws exception if the CelestialBody is not a Planet
	private CelestialBody orbits;
	//creates a circle object for the orbit for animation purposes
	private Circle moonOrbit = new Circle();
	public Moon(String name, CelestialBody orbits, Color color, double radius) throws InvalidCelestialBodyException {
		super(name, "Moon", color, radius);
		if(orbits.getType().equals("Planet")) {
			this.orbits = orbits;
		}
		else {
			throw new InvalidCelestialBodyException("A Moon must orbit a Planet");
		}
	}
	
	//returns what the moon is orbiting
	@Override
	public CelestialBody getOrbit() {
		return orbits;
	}
	//sets the orbit path for animation purposes
	public void setOrbitPath(Circle moonOrbit) {
		this.moonOrbit = moonOrbit;
	}
	//returns the orbit path
	public Circle getOrbitPath() {
		return moonOrbit;
	}
	//prints what the moon is orbiting
	@Override
	public void getOrbitInformation() {
		System.out.println(super.getName() + " is orbiting the " + orbits.getType() + " " + orbits.getName());
	}
	
}
