package LamdbaExpressions;

import java.util.Scanner;

//Проверка некоторого условия
interface Predicate<T> {
	boolean test(T t);
}

//Принимает 2 объекта и выполняет бинарную операцию, возвращает в виде объекта
interface BinaryOperator<T> {
	T apply(T t1, T t2);
}

//Принимает объект выполняет операции и возвращает результата в виде объекта
interface UnaryOperator<T> {
	T apply(T t);
}

//Функция перехода от объекта типа Т к объекту типа R
interface Function<T, R> {
	R apply(T t);
}

//Выполняет некоторое действие над объектом типа Т, ничего не возвращая
interface Consumer<T> {
	void accept(T t);
}

//Не принимает никаких объектов, но возвращает объект типа Т
interface Supplier<T> {
	T get();
}

public class FunctionalInterfaces {
	public static void main(String[] args) {
		Predicate<Integer> isPositive = x -> x > 0;
		System.out.println(isPositive.test(5));
		System.out.println(isPositive.test(-7));

		BinaryOperator<Integer> multiply = (x, y) -> x * y;
		System.out.println(multiply.apply(3, 5));
		System.out.println(multiply.apply(10, -2));

		UnaryOperator<Integer> square = x -> x * x;
		System.out.println(square.apply(5));
		System.out.println(square.apply(7));

		Function<Integer, String> convert = x -> String.valueOf(x) + " долларов";
		System.out.println(convert.apply(5));
		Function<String, Integer> convert2 = x -> Integer.parseInt(x) + 9;
		System.out.println(convert2.apply("11"));

		Consumer<Integer> printer = x -> System.out.printf("%d долларов \n", x);
		printer.accept(600);

		Supplier<User> userSupplier = () -> {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Введите имя: ");
			String name = scanner.nextLine();
			return new User(name);
		};

		User user1 = userSupplier.get();
		User user2 = userSupplier.get();

		System.out.println("Имя user1: " + user1.getName());
		System.out.println("Имя user2: " + user2.getName());
	}
}
