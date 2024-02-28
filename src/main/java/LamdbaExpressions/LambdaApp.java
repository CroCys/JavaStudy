package LamdbaExpressions;

//Функциональные интерфейсы (Обобщенные)
interface Operationable<T> {
	T calculate(T x, T y);
}

interface Printable {
	void print(String s);
}

interface Operation<T> {
	T calculate();
}

public class LambdaApp {

	//Переменные на уровне класса
	static int a = 10;

	static int b = 20;

	public static void main(String[] args) {
		//Однострочные выражения
		Operationable<Integer> Operation = (x, y) -> x + y;
		Operationable<String> Operation1 = (x, y) -> x + y;
		Operationable<Integer> Operation2 = (x, y) -> x - y;
		Operationable<Integer> Operation3 = (x, y) -> x * y;
		Operationable<Integer> Operation4 = (x, y) -> x / y;

		System.out.println(Operation.calculate(20, 10));
		System.out.println(Operation1.calculate("20", "10"));
		System.out.println(Operation2.calculate(20, 10));
		System.out.println(Operation3.calculate(20, 10));
		System.out.println(Operation4.calculate(20, 10));

		//Блочные выражения
		Operation<Integer> op = () -> {
			a = 30;
			return a + b;
		};
		System.out.println(op.calculate());
		System.out.println(a);

		Operation<Integer> op1 = () -> {
			int c = 2048;
			int d = 8;
			if (c % d == 0) {
				return c / d;
			} else {
				return 0;
			}
		};
		System.out.println(op1.calculate());

		Printable printer = s -> System.out.println(s);
		printer.print("Hello Java!");
	}
}
