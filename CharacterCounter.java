package recursion;

public class CharacterCounter {

	public static int CountCharacter(String input, char a){
		int count = 0;
		//checks to see if the character matches then adds 1 to count
		if(input.charAt(0) == a) {
			count++;
		}
		//if the string length is longer than 1 then recursion
		//with this there technically odes not need to be a base case
		if(input.length() > 1){
			count += CountCharacter(input.substring(1), a);
		}
		//returns the count
		return count;
	}
	//main
	public static void main(String[] args) {
		System.out.println(CountCharacter("Welcome", 'e'));
		System.out.println(CountCharacter("more words and lots of o's", 'o'));
	}

}
