package Algorithms;

public class Sorts {
	public static int[] bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

	public static int[] sortBySelect(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		return array;
	}

	public static int[] insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i;
			while (j > 0 && array[j - 1] >= temp) {
				array[j] = array[j - 1];
				--j;
			}
			array[j] = temp;
		}
		return array;
	}

	public static int[] shellSort(int[] array) {
		int length = array.length;
		int step = length / 2;
		while (step > 0) {
			for (int numberOfGroup = 0; numberOfGroup < length - step; numberOfGroup++) {
				int j = numberOfGroup;
				while (j >= 0 && array[j] > array[j + step]) {
					int temp = array[j];
					array[j] = array[j + step];
					array[j + step] = temp;
					j--;
				}
			}
			step = step / 2;
		}
		return array;
	}

	public static int[] quickSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}

	private static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int pivotIndex = partition(array, left, right);

			quickSort(array, left, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, right);
		}
	}

	private static int partition(int[] array, int left, int right) {
		int pivot = array[right];
		int i = left - 1;

		for (int j = left; j < right; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, right);
		return i + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}