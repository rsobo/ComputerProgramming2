import java.util.ArrayList;

public class FinalExamGenerics {

	public static <T> void main(String[] args) {
		//creates integer array list
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(4);
		list1.add(1);
		list1.add(3);
		//creates string arraylist
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("C");
		list2.add("A");
		list2.add("D");
		list2.add("B");
		//sorts lists
		sort(list1);
		sort(list2);
		//prints lists
		System.out.println(list1);
		System.out.println(list2);
	}

	// Sorts all elements in the ArrayList in descending order
	// You cannot use any helper methods to sort for you
	// (e.g. "A","C","B" -> "C","B","A")
	public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
		//creates tracking variables
		T currentVal;
		int currentIndex;
		int reali = 0;
		//loops through the list and swaps values if one is less than the one before it
		for (int i = 0; i < list.size() - 1; i++) {
			currentVal = list.get(i);
			currentIndex = i; 
			reali = i;
			for (int j = i + 1; j < list.size(); j++) { 
				//compares elements and swaps
				if (currentVal.compareTo(list.get(j)) < 0) {
					list.set(i, list.get(j));
					list.set(j, currentVal);
					i++;
				}
			}
			i = reali;
		}
	}
}
