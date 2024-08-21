package InputOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {

	public void fileOutput(String text) {
		try (FileOutputStream fos = new FileOutputStream("Notes.txt", true)) {
			byte[] buffer = text.getBytes();
			fos.write(buffer, 0, buffer.length);
			System.out.println("Файл был успешно записан!");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void fileInput() {
		try (FileInputStream fis = new FileInputStream("Notes.txt")) {
			int i;
			while ((i = fis.read()) != -1) {
				System.out.println((char) i);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
