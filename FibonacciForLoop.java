/**
 * Course: COP 3809C.02
 * @author Ryan Sobolewski 
 * Purpose: Fibonacci
 */

package recursion;

public class FibonacciForLoop {

	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 1;
		//loops through and adds the previous and current number and prints it
		for (int i = 0; i <= 20; i++) {
			System.out.print(num1 + ", ");
			int sum = num1 + num2;
			num1 = num2;
			num2 = sum;
		}
	}
}