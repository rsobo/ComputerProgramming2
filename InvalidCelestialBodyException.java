/**
 * Course: COP 3809C.02
 * @author Ryan Sobolewski 
 * Purpose: Programming Assignment 2
 */

package exceptions;

public class InvalidCelestialBodyException extends Exception{

	//creates a new exception and throws if there is a body that DNE
	public InvalidCelestialBodyException(String message) {
		super(message);
	}
}
