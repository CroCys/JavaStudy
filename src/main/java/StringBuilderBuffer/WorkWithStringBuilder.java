package StringBuilderBuffer;

import java.util.Arrays;

public class WorkWithStringBuilder {
	public static void main(String[] args) {
		String str1 = "Java is cool";
		StringBuilder strbld1 = new StringBuilder(str1);
		StringBuilder strbld2 = new StringBuilder("word");
		stringBuilderMethods(strbld1, strbld2);
	}

	public static void stringBuilderMethods(StringBuilder str1, StringBuilder str2) {
		System.out.println(str1);
		System.out.println("Кол-во символов: " + str1.length());
		System.out.println("Емкость: " + str1.capacity());
		str1.ensureCapacity(32);
		System.out.println("Емкость при минимальном значении 32: " + str1.capacity() + "\n");

		char a = str1.charAt(6);
		System.out.println("Символ на 6: " + a);
		str1.setCharAt(6, 'm');
		System.out.println("Замена символа: " + str1 + "\n");

		int startIndex = 8;
		int endIndex = 12;
		System.out.println("Индекс начала: " + startIndex + " Индекс конца: " + endIndex);
		char[] buffer = new char[endIndex - startIndex];
		str1.getChars(startIndex, endIndex, buffer, 0);
		System.out.println("Символы с 8 по 12: " + Arrays.toString(buffer) + "\n");

		str1.append(" and fast");
		System.out.println("Добавление (and fast) в конец: " + str1);

		System.out.println("Исходное слово: " + str2);
		str2.insert(3, 'l');
		System.out.println("Добавление 'l' после 3го символа: " + str2 + "\n");

		startIndex = 13;
		endIndex = 21;
		System.out.println(str1);
		str1.delete(startIndex, endIndex);
		System.out.println("Удаление с 13 по 21: " + str1);
		for (int i = 0; i < 3; i++) {
			str1.deleteCharAt(5);
		}
		System.out.println("Трижды удаление индекса 5: " + str1 + "\n");

		System.out.println(str1 );
		String substr = str1.substring(5, 9);
		System.out.println("Обрезка с 5 по 9: " + substr + "\n");

		str1.setLength(15);
		System.out.println("setLength (15): " + str1);
		str1.setLength(5);
		System.out.println("setLength (5): " + str1 + "\n");

		str1 = new StringBuilder("Python is cool");
		System.out.println(str1);
		str1.replace(10,14,"trash");
		System.out.println("replace: " + str1 + "\n");

		System.out.println(str1);
		str1.reverse();
		System.out.println("reverse: " + str1);
	}
}
