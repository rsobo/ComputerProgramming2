/**
 * Course: COP 3809C.02
 * @author Ryan Sobolewski 
 * Purpose: Programming Assignment 2
 */
package solarsystem;

import exceptions.InvalidCelestialBodyException;
import javafx.scene.paint.Color;

public class Planet extends CelestialBody implements iOrbit {
	
	//Creates a Planet Object that extends CelestialBody that takes in a name and an orbiting body
	//throws exception if the CelestialBody is not a Star
	CelestialBody orbits;
	public Planet(String name, CelestialBody orbits, Color color, double radius) throws InvalidCelestialBodyException{
		super(name, "Planet", color, radius);
		if(orbits.getType().equals("Star")) {
			this.orbits = orbits;
		}
		else {
			throw new InvalidCelestialBodyException("A Planet must orbit a Star");
		}
	}
	//returns what the planet is orbiting
	@Override
	public CelestialBody getOrbit() {
		return orbits;
	}
	//prints out the info about what the planet is orbiting
	@Override
	public void getOrbitInformation() {
		System.out.println(super.getName() + " is orbiting the " + orbits.getType() + " " + orbits.getName());
	}

}
