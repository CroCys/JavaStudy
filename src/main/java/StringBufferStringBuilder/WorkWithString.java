package StringBufferStringBuilder;

public class WorkWithString {
	public static void main(String[] args) {
		String str1 = "Java";
		String str2 = new String();
		String str3 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});

		stringMethods(str1, str2, str3);
	}

	public static void stringMethods(String str1, String str2, String str3) {
		str2 = "hello";

		boolean a = str2.equalsIgnoreCase(str3);
		System.out.println("equalsIgnoreCase: " + a);

		String b = str1.concat(str2);
		System.out.println("concat: " + b);

		int c = str1.compareTo(str2);
		System.out.println("compareTo: " + c);

		String d = String.valueOf(str1.compareTo(str2));
		System.out.println("compareTo + valueOf: " + d);

		char e = str1.charAt(0);
		System.out.println("charAt 0 from str1 (Java): " + e);

		char[] array = new char[5];
		str1.getChars(0,3, array,0);
		System.out.println(array);


	}
}
