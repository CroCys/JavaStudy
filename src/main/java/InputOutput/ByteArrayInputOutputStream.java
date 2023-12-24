package InputOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayInputOutputStream {
	public static void main(String[] args) {
//		byteInput();
		byteOutput();
	}

	public static void byteInput() {
		byte[] array1 = new byte[]{1, 3, 5, 7};
		ByteArrayInputStream byteStream1 = new ByteArrayInputStream(array1);
		int b;
		while ((b = byteStream1.read()) != -1) {
			System.out.println(b);
		}
		String text = "Hello world";
		byte[] array2 = text.getBytes();
		ByteArrayInputStream byteStream2 = new ByteArrayInputStream(array2, 0, 5);
		int c;
		while ((c = byteStream2.read()) != -1) {
			System.out.println((char) c);
		}
	}

	public static void byteOutput() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String text = "Hello world";
		byte[] buffer = text.getBytes();
		try {
			baos.write(buffer);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(baos.toString());
		byte[] array = baos.toByteArray();
		for (byte b : array) {
			System.out.println((char) b);
		}
	}
}
