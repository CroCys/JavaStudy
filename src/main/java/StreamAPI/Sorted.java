package StreamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class Sorted {
	public static void main(String[] args) {
		Sorted sorted = new Sorted();
		sorted.standartSorted();
		System.out.println();
		sorted.customSorted();
	}

	void standartSorted() {
		ArrayList<String> phones = new ArrayList<>();

		Collections.addAll(phones, "iPhone X", "Nokia 9", "Huawei Nexus 6P",
				"Samsung Galaxy S8", "LG G6", "Xiaomi MI6",
				"ASUS Zenfone 3", "Sony Xperia Z5", "Meizu Pro 6",
				"Pixel 2");

		phones.stream()
				.filter(s -> s.length() < 12) // Фильтруем оставляем все что меньше 12
				.sorted() // Сортировка по возрастанию
				.forEach(s -> System.out.println(s));
	}

	void customSorted() {
		Stream<Phone2> phone2Stream = Stream.of(new Phone2("iPhone X", "Apple", 600), new Phone2("Pixel 2", "Google", 500), new Phone2("iPhone 8", "Apple", 450), new Phone2("Nokia 9", "HDM Global", 150), new Phone2("Galaxy S9", "Samsung", 300));
		phone2Stream.sorted(new Phone2Comparator()).forEach(phone2 -> System.out.printf("%s (%s) - %d \n", phone2.getName(), phone2.getCompany(), phone2.getPrice()));
	}
}
