package StringBuilderBuffer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RussianNumbersRegEx {
	public static void main(String[] args) {
		String number = "+79261234567";
		String number1 = "89261234567";
		String number2 = "79261234567";
		String number3 = "+7 926 123 45 67";
		String number4 = "8(926)123-45-67";
		Pattern pattern = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
		Matcher matcher = pattern.matcher(number);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}

		Matcher matcher1 = pattern.matcher(number1);
		while (matcher1.find()) {
			System.out.println(matcher1.group());
		}

		Matcher matcher2 = pattern.matcher(number2);
		while (matcher2.find()) {
			System.out.println(matcher2.group());
		}

		Matcher matcher3 = pattern.matcher(number3);
		while (matcher3.find()) {
			System.out.println(matcher3.group());
		}

		Matcher matcher4 = pattern.matcher(number4);
		while (matcher4.find()) {
			System.out.println(matcher4.group());
		}
	}
}
