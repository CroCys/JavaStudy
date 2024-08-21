package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Andrew", 30));
		employees.add(new Employee("Charlie", 35));
		employees.add(new Employee("Bob", 25));
		employees.add(new Employee("Anton", 30));

		System.out.println("Изначальный массив: ");
		System.out.println(employees);

		// Используем Comparable в классе Employee
		System.out.println("Естественная сортировка по возрасту:");
		Collections.sort(employees);
		System.out.println(employees);

		// Сортировка по имени. Используем созданный NameComparator
		employees.sort(new NameComparator());
		System.out.println("Сортировка по возрасту:");
		System.out.println(employees);

		// Сортировка по имени и возрасту
		employees.sort(new NameComparator().thenComparing(new AgeComparator()));
		System.out.println("Сортировка по имени:");
		System.out.println(employees);
	}
}
