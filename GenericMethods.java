
public class GenericMethods {

	public static <T> void printArray(T[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
		System.out.println();
	}
	
	public static <T extends Comparable<T>> void sort(T[] array) {
		T currentMin;
		int currentIndex;
		for(int i = 0; i < array.length-1; i++) {
			currentMin = array[i];
			currentIndex = i;
			for(int j = i + 1; j < array.length; j++) {
				if(currentMin.compareTo(array[j]) > 0){
					currentMin = array[j];
					currentIndex = j;
				}
				if(currentIndex != i) {
					array[currentIndex] = array[i];
					array[i] = currentMin;
				}
			}
		}
		printArray(array);
	}
	
	public static void main(String[] args) {
		String[] strings = {"London", "Paris", "New York"};
		printArray(strings);
		sort(strings);
	}

}
