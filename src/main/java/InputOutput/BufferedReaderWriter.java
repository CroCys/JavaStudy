package InputOutput;

import java.io.*;
import java.util.Arrays;

public class BufferedReaderWriter {

	public void writeToFile(String... text) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true))) {
			writer.write(Arrays.toString(text));
			writer.newLine();
			System.out.println("Успешно!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void readFromFile() {
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