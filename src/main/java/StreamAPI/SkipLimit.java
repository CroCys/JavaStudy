package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class SkipLimit {
	public static void main(String[] args) {
		SkipLimit skipLimit = new SkipLimit();
		skipLimit.skipLimit();
		System.out.println();
		skipLimit.book();
	}

	void skipLimit() {
		// SKIP пропускает n элементов, возвращает новый поток в котором пропущены первые n элементов
		// LIMIT возвращает поток не более n элементов
		Stream<String> phoneStream = Stream.of("iPhone 6 S", "Lumia 950", "Samsung Galaxy S 6", "LG G 4", "Nexus 7");
		phoneStream.skip(1).limit(2).forEach(s -> System.out.println(s));
	}

	void book() {
		List<String> phones = new ArrayList<>();
		phones.addAll(Arrays.asList(new String[] {"iPhone 6 S", "Lumia 950", "Huawei Nexus 6P",
				"Samsung Galaxy S 6", "LG G 4", "Xiaomi MI 5",
				"ASUS Zenfone 2", "Sony Xperia Z5", "Meizu Pro 5",
				"Lenovo S 850"}));

		int pageSize = 3; // Кол-во элементов на страницу
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Введите номер страницы: ");
			int page = scanner.nextInt();

			if (page < 1) break; // Если число меньше 1, выходим из цикла

			phones.stream().skip((page - 1) * pageSize).limit(pageSize).forEach(s -> System.out.println(s));
		}
	}
}
