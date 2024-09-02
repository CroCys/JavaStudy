package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectExample {
	public static void main(String[] args) {
		CollectExample collectExample = new CollectExample();
		collectExample.toListExample();
		System.out.println();
		collectExample.toSetExample();
		System.out.println();
		collectExample.toMapExample();
		System.out.println();
		collectExample.example();
	}

	void toListExample() {
		List<String> phones = new ArrayList<>();
		Collections.addAll(phones, "iPhone 8", "HTC U12", "Huawei Nexus 6P",
				"Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
				"Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

		List<String> filteredPhones = phones.stream().filter(s -> s.length() < 10).collect(Collectors.toList());
		// Если нам надо создать какой-то определенный тип коллекции
//		List<String> filteredPhones2 = phones.stream().filter(s -> s.length() < 10).collect(Collectors.toCollection(ArrayList::new));
//		List<String> filteredPhones3 = phones.stream().filter(s -> s.length() < 10).collect(Collectors.toCollection(LinkedList::new));


		for (String s : filteredPhones) {
			System.out.println(s);
		}
	}

	void toSetExample() {
		List<String> phones = new ArrayList<>();
		Collections.addAll(phones, "iPhone 8", "HTC U12", "Huawei Nexus 6P",
				"Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
				"Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

		Set<String> filteredPhones = phones.stream().filter(s -> s.length() < 10).collect(Collectors.toSet());
		// Если нам надо создать какой-то определенный тип коллекции
//		Set<String> filteredPhones2 = phones.stream().filter(s -> s.length() < 10).collect(Collectors.toCollection(HashSet::new));
//		Set<String> filteredPhones3 = phones.stream().filter(s -> s.length() < 10).collect(Collectors.toCollection(LinkedHashSet::new));

		for (String s : filteredPhones) {
			System.out.println(s);
		}
	}

	void toMapExample() {
		Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 8", 54000),
				new Phone("Nokia 9", 45000),
				new Phone("Samsung Galaxy S9", 40000),
				new Phone("LG G6", 32000));

		Map<String, Integer> phones = phoneStream.collect(Collectors.toMap(phone -> phone.getName(), o -> o.getPrice()));
		phones.forEach((s, integer) -> System.out.println(s + " " + integer));
	}

	void example() {
		Stream<String> phones = Stream.of("iPhone 8", "HTC U12", "Huawei Nexus 6P",
				"Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
				"Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

		List<String> filteredPhones = phones.filter(s -> s.length() < 12).collect(
				() -> new ArrayList<String>(),
				(list, item) -> list.add(item),
				(list1, list2) -> list1.addAll(list2));

		filteredPhones.forEach(s -> System.out.println(s));
	}
}
