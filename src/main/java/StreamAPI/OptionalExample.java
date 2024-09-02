package StreamAPI;

import java.util.*;

public class OptionalExample {
	public static void main(String[] args) {
		OptionalExample optionalExample = new OptionalExample();
		optionalExample.isPresentExample();
		System.out.println();
		optionalExample.orElseExample();
		System.out.println();
		optionalExample.orElseGetExample(); // Возвращаем значение по умолчанию через функцию, здесь рандом число
		System.out.println();
//		optionalExample.orElseThrowExample(); // Вручную выбрасываем исключение
		System.out.println();
		optionalExample.ifPresentOrElse();
	}

	void isPresentExample() {
		// Возвращает true, если значение присутствует в Optional,
		List<Integer> numbers = new ArrayList<>();
		Optional<Integer> min = numbers.stream().min(Integer::compare);
		if (min.isPresent()) {
			System.out.println(min.get());
		}
		System.out.println("Не выбрасываем исключение так как используем isPresent");
	}

	void orElseExample() {
		// Определить значение, которое будет возвращаться, если Optional не получит из потока значения
		// Пустой список
		List<Integer> numbers = new ArrayList<>();
		Optional<Integer> min = numbers.stream().min(Integer::compare);
		System.out.println(min.orElse(-1)); // -1

		// Непустой список
		numbers.addAll(Arrays.asList(new Integer[]{4, 5, 6, 7, 8, 9}));
		min = numbers.stream().min(Integer::compare);
		System.out.println(min.orElse(-1)); // 4
	}

	void orElseGetExample() {
		// Задать функцию, которая будет возвращать значение по умолчанию
		List<Integer> numbers = new ArrayList<>();
		Optional<Integer> min = numbers.stream().min(Integer::compare);
		Random rnd = new Random();
		System.out.println(min.orElseGet(() -> rnd.nextInt(100)));
	}

	void orElseThrowExample() {
		// Позволяет сгенерировать исключение, если Optional не содержит значения
		List<Integer> numbers = new ArrayList<>();
		Optional<Integer> min = numbers.stream().min(Integer::compare);
		System.out.println(min.orElseThrow(IllegalStateException::new));
	}

	void ifPresentOrElse() {
		List<Integer> numbers = new ArrayList<>();
		Optional<Integer> min = numbers.stream().min(Integer::compare);
		min.ifPresentOrElse(integer -> System.out.println(integer), () -> System.out.println("Value not found"));
	}
}
