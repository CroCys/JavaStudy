package LamdbaExpressions;

interface UserBuilder {
	User create(String name);
}

class ExpressionHelper {
	static boolean isEven(int n) {
		return n % 2 == 0;
	}

	static boolean isPositive(int n) {
		return n > 0;
	}
}

class ExpressionHelper2 {
	boolean isEven(int n) {
		return n % 2 == 0;
	}
}

public class LambdaApp3 {
	public static void main(String[] args) {
		//ССылка на конструктор
		UserBuilder userBuilder = User::new;
		User user = userBuilder.create("Tom");
		System.out.println(user.getName());

		example();
		example2();
	}

	//Статический метод в классе Helper
	static void example() {
		int[] nums = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
		System.out.println(LambdaApp2.sum(nums, ExpressionHelper::isEven));

		Expression expr = ExpressionHelper::isPositive;
		System.out.println(LambdaApp2.sum(nums, expr));
	}

	//Не статический метод в классе Helper2
	static void example2() {
		int[] nums = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
		ExpressionHelper2 expressionHelper2 = new ExpressionHelper2();
		System.out.println(LambdaApp2.sum(nums,expressionHelper2::isEven));
	}
}
