package StringBufferStringBuilder;

public class WorkWithString {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = new String();
        String str3 = new String(new char[] { 'h', 'e', 'l', 'l', 'o' });

        StringMethods(str1, str2, str3);
    }

    public static void StringMethods(String str1, String str2, String str3) {
        str1.concat(str3);
        System.out.println(str1);
    }
}
