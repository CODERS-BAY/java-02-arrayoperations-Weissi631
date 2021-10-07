package exercise.arraysTDD;

import java.util.Iterator;

/**
 * Utility class which performs various operations with integer arrays.
 */
public class ArrayOperations {
	private final int[] numbers; // array that needs to be sorted.
	private final int[] unsorted; // reference array which stays unsorted.

	public ArrayOperations(int[] numbers) {
		this.numbers = numbers;
		this.unsorted = numbers.clone();
	}

	/*
	 * ********************************************************** Please implement
	 * the following methods. * It is intended that they are not static. *
	 ***********************************************************/

	/**
	 * Prints out the numbers array.
	 */

	public void print() {
		for (int i = 0; i < numbers.length; i++) {
			if (i == 0) {
				System.out.print("[" + numbers[i] + ", ");
			} else if (i == numbers.length - 1) {
				System.out.println(numbers[i] + "]");
			} else {
				System.out.print(numbers[i] + ", ");
			}
		}
	}

	/**
	 * @return the sorted numbers array.
	 * @see <a
	 *      href="sorting algortihms">http://faculty.cs.niu.edu/~hutchins/csci241/sorting.htm</a>
	 */
	public int[] sort() {
		int temp = 0;
		for (int i = 0; i < unsorted.length; i++) {
			for (int j = 1; j < unsorted.length; j++) {
				if (unsorted[j-1] > unsorted[j]) {
					temp = unsorted[j-1];
					unsorted[j-1] = unsorted[j];
					unsorted[j] = temp;
				}
			}
		}
		return unsorted;
	}

	/**
	 * @return the sorted array in reverse order
	 */
	public int[] revertSort() {
		int [] reverseSort = new int[numbers.length];
		int j = numbers.length - 1;
		for (int i = 0 ; i < numbers.length; i++) {
			reverseSort[j] = numbers[i];
			j = j - 1;
			
		}
		return reverseSort;
	}

	/**
	 * @return the unsorted array in reverted order.
	 */
	public int[] reverted() {
		int[] reversed = new int[numbers.length];
		int j = 0;
		for (int i = numbers.length -1; i>=0; i--) {
			reversed[j] = numbers[i];
			j++;
		}
		return reversed;
	}

	/**
	 * @param value which should be searched for.
	 * @return true if the array contains the value, false otherwise.
	 */
	public boolean contains(int value) {
		for (int i = 0; i < numbers.length; i++) {
			if (value == numbers[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the average value of all elements summed up.
	 */
	public double average() {
		return sumOfArray() / numbers.length;
	}

	/**
	 * @return the average value of all elements summed up, but without the highest
	 *         and the lowest value.
	 */
	public double trimmedMean() {
		return (sumOfArray() - maxValue() - minValue()) / (numbers.length - 2);
	}

	/**
	 * @return the max value of the array. In the array [1,9,3] max would be 9.
	 */
	public int maxValue() {
		int max = numbers[0];
		int i = 0;
		for (i = 0; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		return max;
	}

	/**
	 * @return the min value of the array. In the array [1,9,3] min would be 1.
	 */
	public int minValue() {
		int min = numbers[0];
		int i = 0;
		for (i = 0; i < numbers.length; i++) {
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}
		return min;
	}

	/***********************************************************
	 * 
	 * Feel free to add as many private helper methods as * you like. *
	 ***********************************************************/

	private double sumOfArray() {
		double sum1 = 0;
		int i = 0;
		for (i = 0; i < numbers.length; i++) {
			sum1 = sum1 + numbers[i];
		}
		return sum1;
	}
}
