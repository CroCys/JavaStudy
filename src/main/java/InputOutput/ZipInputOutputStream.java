package InputOutput;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipInputOutputStream {
	public static void main(String[] args) {
		zipOutput();
		zipInput();
	}

	public static void zipOutput() {
		String filename = "Notes.txt";
		try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("Output.zip"));
		     FileInputStream fis = new FileInputStream(filename)) {
			ZipEntry entry1 = new ZipEntry("notes.txt");
			zout.putNextEntry(entry1);
			// считываем содержимое файла в массив byte
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			// добавляем содержимое к архиву
			zout.write(buffer);
			// закрываем текущую запись для новой записи
			zout.closeEntry();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void zipInput() {
		try (ZipInputStream zin = new ZipInputStream(new FileInputStream("Output.zip"))) {
			ZipEntry entry;
			String name;
			while ((entry = zin.getNextEntry()) != null) {
				// получим название файла
				name = entry.getName();
				System.out.println("File name: " + name);
				// распаковка
				FileOutputStream fout = new FileOutputStream("new" + name);
				for (int i = zin.read(); i != -1; i = zin.read()) {
					fout.write(i);
				}
				fout.flush();
				zin.close();
				fout.close();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
