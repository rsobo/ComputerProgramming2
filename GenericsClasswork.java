
public class GenericsClasswork {

	// Returns the maximum element in the array
	public static <T extends Comparable<T>> T max(T[] list) {
		T max = list[0];
		for (int i = 1; i < list.length; i++) {
			if (max.compareTo(list[i]) < 0) {
				max = list[i];
			}
		}
		return max;
	}

	// Returns the minimum element in the array
	public static <T extends Comparable<T>> T min(T[] list) {
		T min = list[0];
		for (int i = 1; i < list.length; i++) {
			if (min.compareTo(list[i]) > 0) {
				min = list[i];
			}
		}
		return min;
	}

	// Exchanges the positions of two different elements in an array
	public static <T> void swap(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		Integer[] ints = { 1, 5, 4, 2, 10 };
		System.out.println(max(ints));
		System.out.println(min(ints));
	}
	
	/*
	 * Q1: because using generics can apply to multiple different data types
	 * Q2: no they cannot be static bc they can constantly changing
	 */

}
