
public class ExceptionExample {

	public static void main(String[] args) {
		try{
			System.out.println(divide(1, 1));
			int nums[] = {1, 2};
			nums[3] = 1;
			throw new ArrayIndexOutOfBoundsException();
		}catch(ArithmeticException | ArrayIndexOutOfBoundsException ex){
			System.err.println(ex.getMessage());
		} finally{
			System.out.println("This always runs");
		}
	}
	
	public static int divide(int a, int b) {
		return a/b;
	}
}
