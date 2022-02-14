package part2;

/**
 * Course: COP 3809C.02
 * @author Ryan Sobolewski 
 * Purpose: Programming Assignment 3
 */

import java.util.ArrayList;

public class GenericStack<T> extends ArrayList{

	//returns the top element
	public T peek() {
		return (T) get(size()-1);
	}
	
	//adds a new element
	public void push(T t) {
		add(t);
	}
	
	//removes and returns the top element
	public T pop() {
		T t = peek();
		remove(size()-1);
		return t;
	}
}
