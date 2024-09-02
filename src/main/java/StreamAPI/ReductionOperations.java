package StreamAPI;

import java.util.*;

public class ReductionOperations {
	public static void main(String[] args) {
		ReductionOperations reductionOperations = new ReductionOperations();
		reductionOperations.count();
		System.out.println();
		reductionOperations.findFirstAny();
		System.out.println();
		reductionOperations.allAnyNoneMatch();
		System.out.println();
		reductionOperations.minMax();
		System.out.println();
		reductionOperations.example();
	}

	void count() {
		List<String> names = new ArrayList<>();
		names.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice"}));
		System.out.println(names.stream().count()); // 4

		System.out.println(names.stream().filter(s -> s.length() <= 3).count()); // 3
	}

	void findFirstAny() {
		List<String> names = new ArrayList<>();
		names.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice"}));

		Optional<String> first = names.stream().findFirst();
		System.out.println(first.get()); // Tom потому что ищем первый элемент

		Optional<String> any = names.stream().findAny();
		System.out.println(any.get()); // Tom берем случайный, нередко первый элемент
	}

	void allAnyNoneMatch() {
		List<String> names = new ArrayList<>();
		names.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice"}));

		// Есть ли строка длиной в 3 символа
		boolean all = names.stream().allMatch(s -> s.length() == 3);
		System.out.println(all);
		// Есть ли строка длиной больше 3 символов
		boolean any = names.stream().anyMatch(s -> s.length() > 3);
		System.out.println(any);
		// Нет ли строки Bill, нет = true, есть = false
		boolean none = names.stream().noneMatch(s -> s.equals("Bill"));
		System.out.println(none);
	}

	void minMax() {
		List<Integer> numbers = new ArrayList<>();
		numbers.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));

		Optional<Integer> min = numbers.stream().min(Integer::compare);
		Optional<Integer> max = numbers.stream().max(Integer::compare);

		System.out.println(min.get()); // 1
		System.out.println(max.get()); // 9
	}

	void example() {
		List<Phone> phones = new ArrayList<>();
		phones.addAll(Arrays.asList(new Phone[]{
				new Phone("iPhone 8", 52000),
				new Phone("Nokia 9", 35000),
				new Phone("Samsung Galaxy S9", 48000),
				new Phone("HTC U12", 36000)}));

		Phone min = phones.stream().min(new PhoneComparator()).get();
		Phone max = phones.stream().max(new PhoneComparator()).get();

		System.out.printf("MIN Name: %s Price: %d \n", min.getName(), min.getPrice());
		System.out.printf("Max Name: %s Price: %d \n", max.getName(), max.getPrice());
	}
}