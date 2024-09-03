package StreamAPI;

import java.util.Arrays;

public class ArraysParallel {
	public static void main(String[] args) {
		ArraysParallel parallel = new ArraysParallel();
		parallel.example();
		System.out.println();
		parallel.example2();
		System.out.println();
		parallel.parallelSortExample();
		System.out.println();
		parallel.parallelPrefixExample();
	}

	void example() {
		int[] numbers = initializeArray(6);
		for (int i : numbers) {
			System.out.println(i);
		}
	}

	void example2() {
		Phone[] phones = new Phone[]{new Phone("iPhone8", 54000), new Phone("Pixel 2", 45000), new Phone("Samsung Galaxy S9", 40000), new Phone("Nokia 9", 32000)};

		Arrays.parallelSetAll(phones, i -> {
			phones[i].setPrice(phones[i].getPrice() - 10000);
			return phones[i];
		});

		for (Phone p : phones)
			System.out.printf("%s - %d \n", p.getName(), p.getPrice());
	}

	void parallelSortExample() {
		int[] nums = {30, -4, 5, 29, 7, -8};
		Arrays.parallelSort(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}

	void parallelPrefixExample() {
		int[] numbers = {1, 2, 3, 4, 5, 6};
		Arrays.parallelPrefix(numbers, (left, right) -> left * right);

		for (int i : numbers) {
			System.out.println(i);
		}
	}

	public static int[] initializeArray(int size) {
		int[] values = new int[size];
		Arrays.parallelSetAll(values, i -> i * 10);
		return values;
	}
}
