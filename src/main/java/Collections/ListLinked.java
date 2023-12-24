package Collections;

import java.util.LinkedList;

public class ListLinked {
	public static void main(String[] args) {
		LinkedList<String> states = new LinkedList<>();
		states.add("Germany");
		states.add("France");
		states.addLast("Great Britain");
		states.addFirst("Spain");
		states.add(1, "Italy");

		System.out.println("List has " + states.size() + " elements");
		System.out.println(states.get(1));
		states.set(1, "Portugal");

		for (String state : states) {
			System.out.println(state);
		}

		if (states.contains("Germany")) {
			System.out.println("List contains Germany");
		}

		states.remove("Germany");
		states.removeFirst();
		states.removeLast();

		LinkedList<Person> people = new LinkedList<>();
		people.add(new Person("Mike"));
		people.addFirst(new Person("Tom"));
		people.addLast(new Person("Nick"));
		people.remove(1);

		for (Person p : people) {
			System.out.println(p.getName());
		}

		Person first = people.getFirst();
		System.out.println(first.getName());
	}
}
