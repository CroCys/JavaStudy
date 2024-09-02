package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsGrouping {
	public static void main(String[] args) {
		CollectorsGrouping grouping = new CollectorsGrouping();
		System.out.println("Группировка");
		grouping.groupingByExample();
		System.out.println("Группировка по соответствию");
		grouping.partitioningByExample();
		System.out.println("Кол-во элементов в группе");
		grouping.countingExample();
		System.out.println();
		System.out.println("Подсчет суммы");
		grouping.summingExample();
		System.out.println();
		System.out.println("Мин и Макс в каждой группе");
		grouping.maxByMinByExample();
		System.out.println();
		System.out.println("Поиск среднего значения");
		grouping.summarizingExample();
		System.out.println();
		System.out.println("В группу будут выделятся названия смартфонов, причем группа будет представлять объект List");
		grouping.mappingExample();
	}

	void groupingByExample() {
		/*
		Для создания групп в метод phoneStream.collect() передается вызов функции Collectors.groupingBy(),
		которая с помощью выражения Phone::getCompany группирует объекты по компании. В итоге будет создан объект Map,
		в котором ключами являются названия компаний, а значениями - список связанных с компаниями телефонов
		 */
		Stream<Phone2> phoneStream = Stream.of(new Phone2("iPhone X", "Apple", 600),
				new Phone2("Pixel 2", "Google", 500),
				new Phone2("iPhone 8", "Apple", 450),
				new Phone2("Galaxy S9", "Samsung", 440),
				new Phone2("Galaxy S8", "Samsung", 340));

		Map<String, List<Phone2>> phonesByCompany = phoneStream.collect(Collectors.groupingBy(Phone2::getCompany));

		for (Map.Entry<String, List<Phone2>> item : phonesByCompany.entrySet()) {
			System.out.println(item.getKey());
			for (Phone2 phone2 : item.getValue()) {
				System.out.println(phone2.getName());
			}
			System.out.println();
		}
	}

	void partitioningByExample() {
		// Делит элементы на группы по принципу, соответствует ли элемент определенному условию
		Stream<Phone2> phoneStream = Stream.of(new Phone2("iPhone X", "Apple", 600),
				new Phone2("Pixel 2", "Google", 500),
				new Phone2("iPhone 8", "Apple", 450),
				new Phone2("Galaxy S9", "Samsung", 440),
				new Phone2("Galaxy S8", "Samsung", 340));

		Map<Boolean, List<Phone2>> phonesByCompany = phoneStream.collect(Collectors.partitioningBy(phone2 -> phone2.getCompany() == "Apple"));

		for (Map.Entry<Boolean, List<Phone2>> item : phonesByCompany.entrySet()) {
			System.out.println(item.getKey());
			for (Phone2 phone2 : item.getValue()) {
				System.out.println(phone2.getName());
			}
			System.out.println();
		}
	}

	void countingExample() {
		// Для вычисления количества элементов в каждой группе
		Stream<Phone2> phoneStream = Stream.of(new Phone2("iPhone X", "Apple", 600),
				new Phone2("Pixel 2", "Google", 500),
				new Phone2("iPhone 8", "Apple", 450),
				new Phone2("Galaxy S9", "Samsung", 440),
				new Phone2("Galaxy S8", "Samsung", 340));

		Map<String, Long> phonesByCompany = phoneStream.collect(Collectors.groupingBy(Phone2::getCompany, Collectors.counting()));

		for (Map.Entry<String, Long> item : phonesByCompany.entrySet()) {
			System.out.println(item.getKey() + " - " + item.getValue());
		}
	}

	void summingExample() {
		// Применяется для подсчета суммы
		Stream<Phone2> phoneStream = Stream.of(new Phone2("iPhone X", "Apple", 600),
				new Phone2("Pixel 2", "Google", 500),
				new Phone2("iPhone 8", "Apple", 450),
				new Phone2("Galaxy S9", "Samsung", 440),
				new Phone2("Galaxy S8", "Samsung", 340));

		Map<String, Integer> phonesByCompany = phoneStream.collect(Collectors.groupingBy(Phone2::getCompany, Collectors.summingInt(Phone2::getPrice)));

		for (Map.Entry<String, Integer> item : phonesByCompany.entrySet()) {
			System.out.println(item.getKey() + " - " + item.getValue());
		}
	}

	void maxByMinByExample() {
		// Применяются для подсчета минимального и максимального значения в каждой группе
		Stream<Phone2> phoneStream = Stream.of(new Phone2("iPhone X", "Apple", 600),
				new Phone2("Pixel 2", "Google", 500),
				new Phone2("iPhone 8", "Apple", 450),
				new Phone2("Galaxy S9", "Samsung", 440),
				new Phone2("Galaxy S8", "Samsung", 340));

		Map<String, Optional<Phone2>> phonesByCompany = phoneStream.collect(Collectors.groupingBy(Phone2::getCompany, Collectors.minBy(Comparator.comparing(Phone2::getPrice))));

		for (Map.Entry<String, Optional<Phone2>> item : phonesByCompany.entrySet()) {
			System.out.println(item.getKey() + " - " + item.getValue().get().getPrice());
		}
	}

	void summarizingExample() {
		/*
		Метод Collectors.summarizingInt(Phone::getPrice)) создает набор, в который помещаются цены для всех телефонов каждой из групп.
		Данный набор инкапсулируется в объекте IntSummaryStatistics. У этих объектов есть ряд методов,
		который позволяют выполнить различные атомарные операции над набором
		 */
		Stream<Phone2> phoneStream = Stream.of(new Phone2("iPhone X", "Apple", 600),
				new Phone2("Pixel 2", "Google", 500),
				new Phone2("iPhone 8", "Apple", 450),
				new Phone2("Galaxy S9", "Samsung", 440),
				new Phone2("Galaxy S8", "Samsung", 340));

		Map<String, IntSummaryStatistics> priceSummary = phoneStream.collect(Collectors.groupingBy(Phone2::getCompany, Collectors.summarizingInt(Phone2::getPrice)));

		for (Map.Entry<String, IntSummaryStatistics> item : priceSummary.entrySet()) {
			System.out.println(item.getKey() + " - " + item.getValue().getAverage());
		}
	}

	void mappingExample() {
		// Метод mapping позволяет дополнительно обработать данные и задать функцию отображения объектов из потока на какой-нибудь другой тип данных
		Stream<Phone2> phoneStream = Stream.of(new Phone2("iPhone X", "Apple", 600),
				new Phone2("Pixel 2", "Google", 500),
				new Phone2("iPhone 8", "Apple", 450),
				new Phone2("Galaxy S9", "Samsung", 440),
				new Phone2("Galaxy S8", "Samsung", 340));

		Map<String, List<String>> phonesByCompany = phoneStream.collect(Collectors.groupingBy(Phone2::getCompany, Collectors.mapping(Phone2::getName, Collectors.toList())));

		for (Map.Entry<String, List<String>> item : phonesByCompany.entrySet()) {
			System.out.println(item.getKey());
			for (String name : item.getValue()) {
				System.out.println(name);
			}
		}
	}
}
