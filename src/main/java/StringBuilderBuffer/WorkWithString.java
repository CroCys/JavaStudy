package StringBuilderBuffer;

import java.util.Arrays;

public class WorkWithString {
	public static void main(String[] args) {
		String str1 = "Hello Java";
		String str2 = new String();
		String str3 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});

		stringMethods(str1, str2, str3);
	}

	public static void stringMethods(String str1, String str2, String str3) {
		str2 = "hello";

		boolean q = str2.equals(str3);
		System.out.println("equals: " + q);

		boolean w = str2.equalsIgnoreCase(str3);
		System.out.println("equalsIgnoreCase: " + w);

		String e = str1.concat(str2);
		System.out.println("concat: " + e);

		int r = str1.compareTo(str2);
		System.out.println("compareTo: " + r);

		String t = String.valueOf(str1.compareTo(str2));
		System.out.println("compareTo + valueOf: " + t);

		char y = str1.charAt(0);
		System.out.println("charAt 0 from str1 (Java): " + y);

		char[] array = new char[3];
		str1.getChars(0,3, array,0);
		System.out.println("getChars: " + Arrays.toString(array));

		str1 = "Hello world";
		str2 = "I work";
		boolean result = str1.regionMatches(6, str2, 2, 3);
		System.out.println("regionMatches: " + result);

		String str = "Hello world";
		int index1 = str.indexOf('l');
		int index2 = str.indexOf("wo");
		int index3 = str.lastIndexOf('l');
		System.out.println("indexOf + lastIndexOf: " + index1 + " " + index2 + " " + index3);

		str = "myfile.exe";
		boolean start = str.startsWith("my");
		boolean end = str.endsWith("exe");
		System.out.println(str + " startsWith \"my\": " + start);
		System.out.println(str + " endsWith \"exe\": " + end);

		str = "Hello world";
		String replStr1 = str.replace('l', 'd');
		String replStr2 = str.replace("Hello", "Bye");
		System.out.println(str + " replace: " + replStr1 + " " + replStr2);

		str = "  hello world  ";
		String strTrim = str.trim();
		System.out.println(str + " trim: " + strTrim);

		str = "Hello world";
		String substr1 = str.substring(6);
		String substr2 = str.substring(3,5);
		System.out.println(str + " substring: " + substr1 + " " + substr2);

		str = "Hello World";
		System.out.println(str + " toLowerCase: " + str.toLowerCase());
		System.out.println(str + " toUpperCase: " + str.toUpperCase());

		String text = "FIFA will never regret it";
		String[] words = text.split(" ");
		System.out.println(text + " split:");
		for(String word : words){
			System.out.println(word);
		}
	}
}
