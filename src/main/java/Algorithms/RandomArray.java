package Algorithms;

import java.util.Random;

public class RandomArray {
	private int arrayLength;

	public int getArrayLength() {
		return arrayLength;
	}

	public void setArrayLength(int arrayLength) {
		if (arrayLength <= 0) {
			throw new IllegalArgumentException("Длина массива должна быть больше 0");
		}
		this.arrayLength = arrayLength;
	}

	public void setRandomArrayLength() {
		Random random = new Random();
		setArrayLength(arrayLength = random.nextInt(99) + 1);
	}

	public int[] generate() {
		Random random = new Random();
		int[] array = new int[arrayLength];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(99) + 1;
		}
		return array;
	}
}