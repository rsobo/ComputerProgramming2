package recursion;

public class PalindromeChecker {

	public static boolean isPalindrome(String s) {
		//creates 2 substrings of the first and last letter
		String str1 = s.substring(0,1);
		String str2 = s.substring(s.length()-1);
		//checks for base case as well as checks the last 2 letters if there is an even number of letters in the original string
		if((s.length() == 1 || s.length() == 0) || (s.length() == 2 && str1.equals(str2))) {
			return true;
		}
		//if the last and first match then recursion
		else if(str1.equals(str2)) {
			return isPalindrome(s.substring(1, s.length()-1));
		}
		return false;
	}
	//main
	public static void main(String args[]) {
		System.out.println(isPalindrome("moon"));
		System.out.println(isPalindrome("noon"));
		System.out.println(isPalindrome("racecar"));
	}
}
