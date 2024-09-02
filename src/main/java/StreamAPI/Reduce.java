package StreamAPI;

import java.util.Optional;
import java.util.stream.Stream;

public class Reduce {
	public static void main(String[] args) {
		Reduce reduce = new Reduce();
		reduce.example();
		System.out.println();
		reduce.example2();
	}

	void example() {
		// n1 op n2
		Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5, 6);
		Optional<Integer> result = numberStream.reduce((integer, integer2) -> integer * integer2);
		System.out.println(result.get());

		// identity op n1 op n2
		Stream<String> wordStream = Stream.of("мама", "мыла", "раму");
		Optional<String> sentence = wordStream.reduce((s, s2) -> s + " " + s2);
		System.out.println(sentence.get());
	}

	void example2() {
		Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6", 54000),
				new Phone("Lumia 950", 45000),
				new Phone("Samsung Galaxy S6", 40000),
				new Phone("LG G4", 32000));

		int sum = phoneStream.reduce(0, (phone, phone2) -> {
					if (phone2.getPrice() < 50000)
						return phone + phone2.getPrice();
					else
						return phone + 0;
				},
				(integer, integer2) -> integer + integer2);
		System.out.println(sum); // 117000
	}
}
