package recursion;

public class ComputeFactorials {
	
	public static long factorial(int n) {
		if(n == 0) {
			return 1;
		}
		else {
			return n * factorial(n-1);
		}
	}

	public static void main(String[] args) {
		System.out.println(factorial(5));
	}

}
