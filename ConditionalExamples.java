
public class ConditionalExamples {

	public static void main(String[] args) {
		sleepIn(true, false);
		sleepIn(true, true);
		sleepIn(false, false);
		sleepIn(false, true);
		System.out.println("---------------------------------");
		System.out.println(kittyTrouble(true, true));
		System.out.println(kittyTrouble(false, true));
		System.out.println(kittyTrouble(true, false));
		System.out.println(kittyTrouble(false, false));
		System.out.println("---------------------------------");
		notString("not");
		notString("lolnotlol");
		notString("this contains not, the word");
		notString("This doesnt contain it");
		System.out.println("---------------------------------");
		fizzBuzz(6);
		fizzBuzz(10);
		fizzBuzz(15);
		fizzBuzz(8);
	}

	public static void sleepIn(boolean weekday, boolean vacation) {
		if (!weekday || vacation) {
			System.out.println("Sleep in");
		} else {
			System.out.println("Wake up and go to work you stupid little broke bitch");
		}
	}

	public static boolean kittyTrouble(boolean cat1, boolean cat2) {
		//return cat1 & cat2 || !cat1 & !cat2;
		return cat1 == cat2;
	}
	
	public static void notString(String str) {
		if(str.substring(0,3).equals("not")) {
			System.out.println("it is there");
		}
		else {
			System.out.println("not there");
		}
	}
	
	public static void fizzBuzz(int num) {
		if(num % 3 == 0) {
			System.out.print("Fizz ");
		}
		if(num % 5 == 0) {
			System.out.print("Buzz");
		}
		System.out.println();
	}

}
