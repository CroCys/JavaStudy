package LeetCode;

import java.util.Scanner;

public class PalindromeNumberSolution {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int x = userInput.nextInt();
		System.out.println("x = " + x);
		System.out.println("Result: " + isPalindrome(x));
	}

	public static boolean isPalindrome(int x) {
		int original = x;
		int reversed = 0;
		while (x > 0) {
			int digit = x % 10;
			reversed = reversed * 10 + digit;
			System.out.println("Текущая цифра: " + digit + ", перевернутое число: " + reversed);
			x /= 10;
			System.out.println("Оставшееся число: " + x);
		}
		System.out.println("Исходное число: " + original + ", перевернутое число: " + reversed);
		return original == reversed;
	}
}