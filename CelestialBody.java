/**
 * Course: COP 3809C.02
 * @author Ryan Sobolewski 
 * Purpose: Programming Assignment 2
 */

package solarsystem;

import java.util.ArrayList;
import exceptions.DuplicateCelestialBodyException;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CelestialBody extends Circle{
	//Creates a CelestialBody object and takes in name and type
	private String name;
	private String type;
	private ArrayList<CelestialBody> children = new ArrayList<CelestialBody>();
	public CelestialBody(String name, String type, Color color, double radius) {
		this.name = name;
		this.type = type;
		setRadius(radius);
		setFill(color);
		setOnMouseClicked(e -> getInformation());
	}
	//returns the name
	public String getName() {
		return name;
	}
	//returns type
	public String getType() {
		return type;
	}
	//prints info about the body
	public void getInformation() {
		System.out.println("This is the " + type + " " + name);
	}
	//adds a CelestialBody to the children array list
	//throws exception if the CelestialBody is already in the list
	public void add(CelestialBody child) throws DuplicateCelestialBodyException {
		if(!children.contains(child)) {
			children.add(child);
			System.out.println(child.getName() + " was successfully added to " + name + ".");
		}
		else {
			throw new DuplicateCelestialBodyException("The " + type + " " + name + " is already in the collection");
		}
	}
	//returns the orbiting children
	public ArrayList<CelestialBody> getChildren(){
		return children;
	}
	
}
