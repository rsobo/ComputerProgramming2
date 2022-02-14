package parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FinalExamParallel {
	
    public static void main(String[] args) {
    	//creates an array of 5000 elements
    	Comparable[] list = new Comparable[5000];
		for(int i = 0; i < list.length; i++) {
			list[i] = i;
		}
		System.out.println("Min is: "+ min(list));
    }

    //calls paralleltask
    public static int min(Comparable[] list) {
    	RecursiveTask<Integer> task = new ParallelTask(list, 0, list.length);
		ForkJoinPool pool = new ForkJoinPool();
		return pool.invoke(task);
    }

    //runs the different forks to find the min
    private static class ParallelTask<T extends Comparable<T>> extends RecursiveTask<T> {

    	private final static int THRESHOLD = 1000;
    	private T[] list;
    	private int low;
    	private int high;
    	public ParallelTask(T[] array, int low, int high) {
    		this.list = array;
    		this.low = low;
    		this.high = high;
    	}
		@Override
		protected T compute() {
			if(high - low < THRESHOLD) {
				T min = list[0];
				for(int i = low; i < high; i++) {
					if(list[i].compareTo(min) < 0) {
						min = list[i];
					}
				}
				return min;
			}else {
				int mid = (low + high)/2;
				RecursiveTask<Integer> left = new ParallelTask(list, low, mid);
				RecursiveTask<Integer> right = new ParallelTask(list, mid, high);
				
				right.fork();
				left.fork();
				if(left.join().compareTo(right.join()) < 0) {
					return (T) left.join();
				}
				else {
					return (T) right.join();
				}
			}
			
		}
    }
}