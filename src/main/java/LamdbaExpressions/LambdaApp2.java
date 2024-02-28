package LamdbaExpressions;

interface Expression {
	boolean isEqual(int n);
}

public class LambdaApp2 {
	public static void main(String[] args) {
		example();
		example2();
	}

	static void example() {
		Expression func = (n) -> n % 2 == 0;
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(sum(nums, func));
	}

	static void example2() {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int x = sum(nums, (n) -> n > 5);
		System.out.println(x);
	}

	//Лямбда как параметр метода
	public static int sum(int[] numbers, Expression func) {
		int result = 0;
		for (int i : numbers) {
			if (func.isEqual(i))
				result += i;
		}
		return result;
	}
}
