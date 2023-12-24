package InputOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteRead {
	public static void main(String[] args) {

		String text = "Hello world! ";

		try (FileOutputStream fos = new FileOutputStream("notes.txt")) {
			byte[] buffer = text.getBytes();
			fos.write(buffer, 0, buffer.length);
			System.out.println("The file has been written");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try (FileInputStream fin = new FileInputStream("notes.txt")) {
			int i;
			while ((i = fin.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
