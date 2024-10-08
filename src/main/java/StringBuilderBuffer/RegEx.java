package StringBuilderBuffer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
	public static void main(String[] args) {
		RegExMethods();
	}

	public static void RegExMethods() {
		String text = "FIFA! will never, regret it.";
		String[] words = text.split("\\s*(\\s|,|!|\\.)\\s*");
		for (String word : words) {
			System.out.println(word);
		}

		String input = "+92972558261";
		boolean result = input.matches("(\\+*)\\d{11}");
		if (result) {
			System.out.println("Это телефонный номер" + "\n");
		} else {
			System.out.println("Это не телефонный номер" + "\n");
		}

		String input2 = "Hello";
		boolean found = Pattern.matches("Hello", input2);
		if (found) {
			System.out.println("Найдено" + "\n");
		} else {
			System.out.println("Не найдено" + "\n");
		}

		String input3 = "Hello";
		Pattern pattern = Pattern.compile("Hello");
		Matcher matcher = pattern.matcher(input3);
		boolean found2 = matcher.matches();
		if (found2) {
			System.out.println("Найдено" + "\n");
		} else {
			System.out.println("Не найдено" + "\n");
		}

		String input4 = "Hello Java! Hello Javascript! Hello JavaSE 8.";
		Pattern pattern1 = Pattern.compile("Java(\\w*)");
		Matcher matcher1 = pattern1.matcher(input4);
		while (matcher1.find()) {
			System.out.println(matcher1.group() + "\n");
		}

		input4 = "Hello Java! Hello Javascript! Hello JavaSE 8.";
		Pattern pattern2 = Pattern.compile("Java(\\w*)");
		Matcher matcher2 = pattern2.matcher(input4);
		String newStr = matcher2.replaceAll("HTML");
		System.out.println(newStr + "\n");

		input4 = "Hello Java! Hello JavaScript! JavaSE 8.";
		String myStr = input4.replaceAll("Java(\\w*)", "HTML");
		System.out.println(myStr + "\n");

		input4 = "Hello Java! Hello JavaScript! JavaSE 8.";
		Pattern pattern3 = Pattern.compile("[ ,.!?]");
		String[] words2 = pattern3.split(input4);
		for (String word : words2) {
			System.out.println(word);
		}
	}
}
