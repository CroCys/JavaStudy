package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Parallel {
	public static void main(String[] args) {
		Parallel parallel = new Parallel();
		parallel.example();
		System.out.println();
		parallel.example2();
	}

	void example() {
		Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5, 6);
		Optional<Integer> result = numberStream.parallel().reduce((integer, integer2) -> integer * integer2);
		System.out.println(result.get());
	}

	void example2() {
		List<String> people = Arrays.asList("Tom", "Bob", "Sam", "Kate", "Tim");

		System.out.println("Последовательный поток");
		people.stream().filter(s -> s.length() == 3).forEach(System.out::println);

		/*
		И чтобы сохранить порядок следования, необходимо применять метод forEachOrdered.
		Но если нам порядок не важен, то мы можем отключить его сохранение и тем самым
		увеличить производительность, использовав метод .unordered()
		*/
		System.out.println("\nПараллельный поток");
		people.parallelStream().filter(s -> s.length() == 3).forEach(System.out::println);
	}
}
