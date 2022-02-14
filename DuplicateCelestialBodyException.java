/**
 * Course: COP 3809C.02
 * @author Ryan Sobolewski 
 * Purpose: Programming Assignment 2
 */

package exceptions;

public class DuplicateCelestialBodyException extends Exception{

	//creates a new exception and throws it if there is more than 1 of the same body
	public DuplicateCelestialBodyException(String message) {
		super(message);
	}
}
