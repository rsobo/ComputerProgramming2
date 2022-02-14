package part1;

/**
 * Course: COP 3809C.02
 * @author Ryan Sobolewski 
 * Purpose: Programming Assignment 3
 */

public class GenericStackArray<T> {

	//creates the generic array and an index variable
	private T[] arr = (T[]) new Object[10];
	private int index = 0;
	
	//returns array size
	public int getSize() {
		return arr.length;
	}
	
	//returns the value of the element at index - 1
	public T peek() {
		return arr[index-1];
	}
	
	//checks to see if the array is full, if true then it creates a new array that is double the size of the previous array
	//then adds the new element to the array
	public void push(T t) {
		if(index == getSize()-1) {
			T[] arr2 = (T[]) new Object[getSize() * 2];
			for(int i = 0; i < getSize()-1; i++) {
				arr2[i] = arr[i];
			}
			arr2[index] = t;
		}
		else {
			arr[index] = t;
			index++;
		}
	}
	
	//returns and removes the top element
	public T pop() {
		T t = peek();
		arr[index] = null;
		index--;
		return t;
	}
}
