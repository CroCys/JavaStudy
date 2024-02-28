package LamdbaExpressions;

interface Operation2 {
	int execute(int x, int y);
}

public class LambdaApp4 {
	public static void main(String[] args) {
		Operation2 func = action(1);
		int a = func.execute(6, 5);
		System.out.println(a);

		int b = action(2).execute(8, 2);
		System.out.println(b);

		Operation2 func2 = action(3);
		int c = func2.execute(4, 4);
		System.out.println(c);

		int d = action(4).execute(15, 5);
		System.out.println(d);
	}

	//Лямбда как результат метода
	private static Operation2 action(int number) {
		switch (number) {
			case 1:
				return (x, y) -> x + y;
			case 2:
				return (x, y) -> x - y;
			case 3:
				return (x, y) -> x * y;
			case 4:
				return (x, y) -> x / y;
			default:
				return (x, y) -> 0;
		}
	}
}
