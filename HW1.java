
public class HW1 {

	public static void main(String[] args) {
		System.out.println(multiplyDivide(1, 2));
		System.out.println(multiplyDivide(3, 2));
		System.out.println(multiplyDivide(2, 2));
		System.out.println("---------------------------------");
		System.out.println(makes30(9, 30));
		System.out.println(makes30(9, 9));
		System.out.println(makes30(5, 25));
		System.out.println("---------------------------------");
		System.out.println(last3Times("Cat"));
		System.out.println(last3Times("Java"));
		System.out.println(last3Times("a"));
		System.out.println("---------------------------------");
		int nums[] = {1, 1, 2, 3, 1};
		System.out.println(noTriples(nums));
		int nums2[] = {1, 1, 2, 2, 2};
		System.out.println(noTriples(nums2));
		int nums3[] = {1, 1, 1, 2, 2, 2, 3};
		System.out.println(noTriples(nums3));
		System.out.println("---------------------------------");

	}
	//Function takes 2 int's and multiplies them
	//unless the int's are the same then it is multiplied then divided by 2
	public static int multiplyDivide(int x, int y) {
		if(x== y) {
			return (x * y) / 2;
		}
		else {
			return x * y;
		}
	}
	//return true if the sum of the 2 int's is 30 or one of them is 30
	public static boolean makes30(int x, int y) {
		return x == 30 || y == 30 || (x + y) == 30;
	}
	//repeats last 3 characters 3 times
	public static String last3Times(String str) {
		String str2;
		if(str.length() >= 3) {
			str2 = str.substring(str.length()-3, str.length());
		}
		else {
			str2 = str;
		}
		return str2 + str2 + str2;
	}
	
	public static boolean noTriples(int[] nums) {
		int count = 0;
		int first = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(first == nums[i]) {
				count++;
			}
			if(count == 3) {
				return false;
			}
			else {
				first = nums[i];
			}
		}
		return true;
	}
}
