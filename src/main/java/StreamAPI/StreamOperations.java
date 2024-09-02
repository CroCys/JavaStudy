package StreamAPI;

import java.util.stream.Stream;

public class StreamOperations {
	public static void main(String[] args) {
		StreamOperations streams = new StreamOperations();
		streams.takeWhile();
		System.out.println();
		streams.dropWhile();
		System.out.println();
		streams.concat();
		System.out.println();
		streams.distinct();
	}

	void takeWhile() {
		// Выбирает из потока элементы, пока они соответствуют условию
		Stream<Integer> numbers = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
		// Захватит не все отрицательные числа
//		numbers.takeWhile(integer -> integer < 0).forEach(integer -> System.out.println(integer));
		// Сначала сортируем и захватываем все отрицательные числа
		numbers.sorted().takeWhile(integer -> integer < 0).forEach(integer -> System.out.println(integer));
	}

	void dropWhile() {
		// Пропускает элементы потока, которые соответствуют условию
		Stream<Integer> numbers = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
		// Сначала сортируем и захватываем все
		numbers.sorted().dropWhile(integer -> integer < 0).forEach(integer -> System.out.println(integer));
	}

	void concat() {
		// Объединяем элементы 2х потоков, возвращая объединенный поток
		Stream<String> people1 = Stream.of("Tom", "Bob", "Sam");
		Stream<String> people2 = Stream.of("Alice", "Kate", "Sam");

		Stream.concat(people1, people2).forEach(s -> System.out.println(s));
	}

	void distinct() {
		// Возвращает только уникальные элементы в виде потока
		Stream<String> people = Stream.of("Tom", "Bob", "Sam", "Alice", "Kate", "Sam");
		people.distinct().forEach(s -> System.out.println(s));
	}
}