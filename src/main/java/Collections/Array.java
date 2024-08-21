package Collections;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		System.out.println("Введите элементы массива:");

		Scanner userInput = new Scanner(System.in);

		String[][] firstArray = new String[2][2];
		int row = firstArray.length;
		int col = firstArray[0].length;

		for (int i = 0; i < firstArray.length; i++) {
			for (int j = 0; j < firstArray[i].length; j++) {
				firstArray[i][j] = userInput.nextLine();
			}
		}
		userInput.close();

		System.out.println("Количество строк: " + row + " Количество столбцов: " + col + " Длина массива = " + (row * col));
		System.out.println("Последний элемент: " + firstArray[firstArray.length - 1][firstArray.length - 1]);
		System.out.println("Введенный массив: ");

		for (String[] num : firstArray) {
			for (String s : num) {
				System.out.print(s + ", ");
			}
		}
	}
}