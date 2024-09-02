package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class forEachFilterMap {
	List<String> cities = new ArrayList<>();

	public static void main(String[] args) {
		forEachFilterMap forEachFilterMap = new forEachFilterMap();
		forEachFilterMap.forEach();
		System.out.println();
		forEachFilterMap.filter();
		System.out.println();
		forEachFilterMap.map();
		System.out.println();
		forEachFilterMap.flatMap();
	}

	void forEach() {
		Stream<String> citiesStream = Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель");

		System.out.println("Все города: ");
		citiesStream.forEach(s -> System.out.println(s));
		// Или
//		citiesStream.forEach(System.out::println);
	}

	void filter() {
		Stream<String> citiesStream = Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель");

		System.out.println("Все города == 6: ");
		citiesStream.filter(s -> s.length() == 6).forEach(s -> System.out.println(s));

		Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", 54000), new Phone("Lumia 950", 45000), new Phone("Samsung Galaxy S 6", 40000));

		System.out.println("Телефоны < 50000: ");
		phoneStream.filter(phone -> phone.getPrice() < 50000).forEach(phone -> System.out.println(phone.getName()));
	}

	void map() {
		Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", 54000), new Phone("Lumia 950", 45000), new Phone("Samsung Galaxy S 6", 40000));

		// Преобразование от типа Phone к типу String
//		phoneStream.map(phone -> "Название: " + phone.getName() + " цена: " + phone.getPrice()).forEach(s -> System.out.println(s));

		// Преобразование от типа int к типу double
		phoneStream.mapToDouble(phone -> phone.getPrice()).forEach(v -> System.out.println(v));
	}

	void flatMap() {
		Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", 54000), new Phone("Lumia 950", 45000), new Phone("Samsung Galaxy S 6", 40000));

		phoneStream.flatMap(phone -> Stream.of(
						String.format("Название: %s цена без скидки: %d", phone.getName(), phone.getPrice()),
						String.format("Название: %s цена со скидкой: %d", phone.getName(), phone.getPrice() - (int) (phone.getPrice() * 0.1))))
				.forEach(s -> System.out.println(s));
	}
}
