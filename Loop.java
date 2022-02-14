
public class Loop {

	public static void main(String args[]) {

	}

	public static void whileLoop() {
		int i = 0;
		while (i < 3) {
			System.out.println("Cats");
			i++;
		}
	}

	public static void forLoop() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Cats");
		}
	}

	public static void doWhile() {
		int i = 0;
		do {
			System.out.println("Cats");
			i++;
		} while (i < 3);
	}
	
	public static void forEach() {
		int[] nums = {0, 1, 2, 3, 4};
		for(int num:nums) {
			System.out.println(num);
		}
	}
}
