package part2;

/**
 * Course: COP 3809C.02
 * @author Ryan Sobolewski 
 * Purpose: Programming Assignment 3
 */

public class MainGenericStack {

	public static void main(String[] args) {
		//creates an instance of a generic stack array
		GenericStack<String> stack = new GenericStack<>();
		stack.push("Dog");
		stack.push("Cat");
		stack.push("Rabbit");
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
