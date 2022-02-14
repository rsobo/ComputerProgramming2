/**
 * Course: COP 3809C.02
 * @author Ryan Sobolewski 
 * Purpose: Programming Assignment 2
 */
package solarsystem;

import javafx.scene.paint.Color;

public class Star extends CelestialBody{

	//creates a Star Object that extends CelestialBody and takes in a name and how hot the surface is
	private int surfaceTemp;
	public Star(String name, int surfaceTemp) {
		super(name, "Star", Color.YELLOW, 75.0);
		this.surfaceTemp = surfaceTemp;
	}
	
	//returns temp of surface
	public int getSurfaceTemp() {
		return surfaceTemp;
	}

}
