package InputOutput;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class WebPageReader {
	public static void main(String[] args) {
		String urlAddress = "https://www.youtube.com/"; // URL адрес веб-страницы
		String filename = "webpage_content.txt"; // Имя файла для записи содержимого веб-страницы

		try {
			URL url = new URL(urlAddress);
			URLConnection connection = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			String line;

			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}

			reader.close();
			writer.close();

			System.out.println("Содержимое веб-страницы успешно записано в файл " + filename);
		} catch (IOException e) {
			System.out.println("Ошибка: " + e.getMessage());
		}
	}
}
