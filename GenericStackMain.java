
public class GenericStackMain {

	public static void main(String[] args) {
		GenericStack<String> stack = new GenericStack<>();
		stack.push("Dog");
		stack.push("Cat");
		stack.push("Rabbit");
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
