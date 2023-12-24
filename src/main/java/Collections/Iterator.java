package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Iterator {
	public static void main(String[] args) {
		List<String> states = new ArrayList<>();
		states.add("Germany");
		states.add("France");
		states.add("Italy");
		states.add("Spain");

		System.out.println("From start to end: ");

		java.util.Iterator<String> firstIterator = states.iterator();
		while (firstIterator.hasNext()) {
			System.out.println(firstIterator.next());
		}

		System.out.println("From start to end with ListIterator: ");

		ListIterator<String> secondIterator = states.listIterator();
		while (secondIterator.hasNext()) {
			System.out.println(secondIterator.next());
		}

		System.out.println("From end to start witch changing Spain on Portugal: ");

		secondIterator.set("Portugal");

		while (secondIterator.hasPrevious()) {
			System.out.println(secondIterator.previous());
		}
	}
}
