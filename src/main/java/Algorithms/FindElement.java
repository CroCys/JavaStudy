package Algorithms;

import java.util.Arrays;

public class FindElement {
	public static void main(String[] args) {
		int[] array = RandomArray.randomArray();
		System.out.println(Arrays.toString(Sorts.quickSort(array)));
		int target = 28;
		int resultIterative = binarySearchIterative(array, target);
		int resultRecursive = binarySearchRecursive(array, target);

		System.out.println("Индекс элемента " + target + " (рекурсивный): " + resultRecursive);
		System.out.println("Индекс элемента " + target + " (итеративный): " + resultIterative);
	}

	public static int binarySearchIterative(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public static int binarySearchRecursive(int[] array, int target) {
		return binarySearchRecursive(array, target, 0, array.length - 1);
	}

	private static int binarySearchRecursive(int[] array, int target, int left, int right) {
		if (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				return binarySearchRecursive(array, target, mid + 1, right);
			} else {
				return binarySearchRecursive(array, target, left, mid - 1);
			}
		}
		return -1;
	}
}