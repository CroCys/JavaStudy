package Collections;


import java.util.*;

public class Map {
	public static void main(String[] args) {
		HashMap<Integer, String> states = new HashMap<>();
		states.put(1, "Germany");
		states.put(2, "Spain");
		states.put(3, "France");
		states.put(4, "Italy");

		String getElementByKey = states.get(1);
		System.out.println("Element with key 1: " + getElementByKey);

		Set<Integer> keys = states.keySet();
		System.out.println("All keys: " + keys);

		Collection<String> values = states.values();
		System.out.println("All values: " + values);

		states.replace(2, "Russia");
		System.out.println("Replace value for key 2: " + states);

		states.remove(3);
		System.out.println("Remove value for key 3: " + states);

		states.put(3, "Britain");
		System.out.println("Add value for key 3: " + states);

		for (java.util.Map.Entry<Integer, String> item : states.entrySet()) {
			System.out.println("Key: " + item.getKey() + " " + "Value: " + item.getValue());
		}

		java.util.Map<String, Person> people = new HashMap<>();
		people.put("123", new Person("Tom"));
		people.put("456", new Person("Bill"));
		people.put("789", new Person("Nick"));

		for (java.util.Map.Entry<String, Person> item : people.entrySet()) {
			System.out.println("key: " + item.getKey() + " " + "Value: " + item.getValue().getName());
		}
	}
}