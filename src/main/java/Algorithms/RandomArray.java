package Algorithms;

import java.util.Random;

public class RandomArray {
	public static int[] randomArray() {
		Random random = new Random();
		int[] array = new int[25];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(99) + 1;
		}
		return array;
	}
}