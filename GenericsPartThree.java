package part3;

/**
* Course: COP 3809C.02
* @author Ryan Sobolewski 
* Purpose: Programming Assignment 3
*/


import java.util.ArrayList;

public class GenericsPartThree<E> {

	// Returns a new ArrayList that contains the non-duplicate elements from the original list.
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
		ArrayList<E> list2 = new ArrayList<E>();
		for(int i = 0; i < list.size(); i++) {
			if(!list2.contains(list.get(i))) {
				list2.add(list.get(i));
			}
		}
		return list2;
	}
	
	// Returns the maximum element in a two-dimensional array.
	public static <E extends Comparable<E>> E max(E[][] list) {
		E max = list[0][0];
		//loops through the array to check max value
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j < list[0].length; j++) {
				if(list[i][j].compareTo(max) > 0) {
					max = list[i][j];
				}
			}
		}
		return max;
	}
	
	//Returns the minimum element in a two-dimensional array.
	public static <E extends Comparable<E>> E min(E[][] list) {
		E min = list[0][0];
		//loops through the array to check min value
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j < list[0].length; j++) {
				if(list[i][j].compareTo(min) < 0) {
					min = list[i][j];
				}
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		//creates a 2d array and an array list
		Integer[][] ints =  {{1, 5, 4, 2, 10},
							{4, 2, 8, 3, 13},
							{9, 1, 7, 3, 19}};
		ArrayList<Integer> list = new ArrayList();
		list.add(1);
		list.add(4);
		list.add(2);
		list.add(4);
		list.add(5);
		System.out.println(removeDuplicates(list));
		System.out.println(max(ints));
		System.out.println(min(ints));
	}
}
