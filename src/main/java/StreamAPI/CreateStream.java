package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreateStream {
	public static void main(String[] args) {
		long count = IntStream.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5).filter(i -> i > 0).count();
		System.out.println(count);

		// Создание из коллекции
		List<String> cities = new ArrayList<>();
		Collections.addAll(cities, "Paris", "London", "Madrid");
		cities.stream() // Получаем поток
				.filter(s -> s.length() == 6) // Применяем фильтрацию по длине строки (промежуточная операция)
				.forEach(s -> System.out.println(s)); // Выводим отфильтрованные строки в консоль (терминальная операция)

		Stream<String> citiesStream = cities.stream(); // Получаем поток
		citiesStream = citiesStream.filter(s -> s.length() == 6); // Применяем фильтрацию по длине строки (промежуточная операция)
		citiesStream.forEach(s -> System.out.println(s)); // Выводим отфильтрованные строки в консоль (терминальная операция)

		// Создание из массива
		Stream<String> citiesArrayStream = Arrays.stream(new String[]{"Paris", "London", "Madrid"});
		citiesArrayStream.forEach(s -> System.out.println(s));

		// Использование соответствующих перегруженных версий метода
		IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
		intStream.forEach(i -> System.out.println(i));

		// Использование соответствующих перегруженных версий метода
		LongStream longStream = Arrays.stream(new long[]{100, 200, 300, 400, 500, 600, 700, 800, 900});
		longStream.forEach(l -> System.out.println(l));

		// Использование соответствующих перегруженных версий метода
		DoubleStream doubleStream = Arrays.stream(new double[]{1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9});
		doubleStream.forEach(v -> System.out.println(v));

		// Создание через метод of класса Stream
		Stream<String> citiesStream2 = Stream.of("Paris", "London", "Madrid");
		citiesStream2.forEach(s -> System.out.println(s));

		// Можно передать массив
		String[] citiesArray = {"Paris", "London", "Madrid"};
		Stream<String> citiesStream3 = Stream.of(citiesArray);

		IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
		intStream1.forEach(i -> System.out.println(i));

		LongStream longStream1 = LongStream.of(100, 200, 300, 400, 500, 600, 700, 800, 900);
		longStream1.forEach(l -> System.out.println(l));

		DoubleStream doubleStream1 = DoubleStream.of(1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9);
		doubleStream1.forEach(v -> System.out.println(v));
	}
}