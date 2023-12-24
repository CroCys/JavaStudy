package InputOutput;

import java.io.*;

public class BufferedReaderWriter {
	public static void main(String[] args) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"))) {
			for (int i = 0; i < 10; i++) {
				writer.write("Hello");
				writer.newLine();
				writer.write("World");
				writer.newLine();
			}
			System.out.println("Success");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
