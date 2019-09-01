package task;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Task {

	/**
	 * 
	 * @param array - map of a compartment where each number of array means height of wall. Width of each bar is 1
	 * @return how much liquid can be stored into a given compartment
	 */
	public int compute(int[] array) {
		int result = 0;
		int first;
		int last;
		int max = Arrays.stream(array).max().getAsInt();
		for(int i = 1 ; i <= max ; i++) {
				first = firstOf(array,i);
				last = lastOf(array,i);
				for(int j = 0 ; j < array.length ; j++) {
					if((j > first) & (j < last) & (array[j] < i)) {
						result++;
					}
				}	
		}
		return result;
	}
	
	/**
	 * 
	 * @param array 
	 * @param number
	 * @return first index of array element which is equal or more than number
	 * @throws NoSuchElementException if array doesn't contain element which is equal or more than number
	 */
	private int firstOf(int[] array, int number) {
		for(int i = 0 ; i < array.length ; i++) {
			if(array[i] >= number) {
				return i;
			}
		}
		throw new NoSuchElementException();
	}
	
	/**
	 * 
	 * @param array
	 * @param number
	 * @return last index of array element which is equal of more than number
	 * @throws NoSuchElementException - if array doesn't contain element which is equal or more than number
	 */
	private int lastOf(int[] array, int number) {
		for(int i = array.length-1 ; i >=0 ; i--) {
			if(array[i] >= number) {
				return i;
			}
		}
		throw new NoSuchElementException();
	}

}
