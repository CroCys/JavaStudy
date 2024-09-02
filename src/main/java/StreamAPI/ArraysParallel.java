package StreamAPI;

import java.util.Arrays;

public class ArraysParallel {
	public static void main(String[] args) {
		ArraysParallel parallel = new ArraysParallel();
		parallel.example();
		System.out.println();
		parallel.example2();
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

	public static int[] initializeArray(int size) {
		int[] values = new int[size];
		Arrays.parallelSetAll(values, i -> i * 10);
		return values;
	}
}
