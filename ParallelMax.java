package parallel;

import java.lang.reflect.Array;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelMax {

	public static void main(String[] args) {
		int[] list = new int[9001];
		for(int i = 0; i < list.length; i++) {
			list[i] = i;
		}
		long startTime = System.currentTimeMillis();
		System.out.println("Max is " + max(list));
		long endTime = System.currentTimeMillis();
		System.out.println("Runtime was " + (endTime-startTime) + "ms");
	}
	
	private static int max(int[] list) {
		RecursiveTask<Integer> task = new MaxTask(list, 0, list.length);
		ForkJoinPool pool = new ForkJoinPool();
		return pool.invoke(task);
	}
	
	private static class MaxTask extends RecursiveTask<Integer>{
		private final static int THRESHOLD = 1000;
		private int[] array;
		private int low, high;
		
		public MaxTask(int[] array, int low, int high) {
			this.array = array;
			this.high = high;
			this.low = low;
		}
		@Override
		protected Integer compute() {
			if(high - low < THRESHOLD) {
				int max = array[0];
				for(int i = low; i < high; i++) {
					if(array[i] > max) {
						max = array[i];
					}
				}
				return max;
			}else {
				int mid = (low + high)/2;
				RecursiveTask<Integer> left = new MaxTask(array, low, mid);
				RecursiveTask<Integer> right = new MaxTask(array, mid, high);
				
				right.fork();
				left.fork();
				
				return Math.max(left.join().intValue(), right.join().intValue());
			}
		}

	}

}
