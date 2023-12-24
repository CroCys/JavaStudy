package InputOutput;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CatalogFile {
	public static void main(String[] args) {
		File dir = new File("/home/vadim/Рабочий стол/Test");
		File dir2 = new File("/home/vadim/Рабочий стол/NewDir");
		File newDir = new File("/home/vadim/Рабочий стол/NewDirRenamed");

		File myFile = new File("/home/vadim/Рабочий стол//Notes.txt");
		File myFile2 = new File("/home/vadim/Рабочий стол//NewNotes");
		File myNewFile = new File("/home/vadim/Рабочий стол//NewNotesRenamed");

		try {
			fileActions(myFile);
			Thread.sleep(3000);

			createFile(myFile2);
			Thread.sleep(3000);

			renameFile(myFile2, myNewFile);
			Thread.sleep(3000);

			deleteFile(myNewFile);
			Thread.sleep(3000);

			folderActions(dir);
			Thread.sleep(3000);

			createFolder(dir2);
			Thread.sleep(3000);

			renameFolder(dir2, newDir);
			Thread.sleep(3000);

			deleteFolder(newDir);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static void fileActions(File myFile) {
		if (myFile.exists()) {
			System.out.println("File exists");
			if (myFile.isFile()) {
				System.out.println("File name: " + myFile.getName());
				System.out.println("Parent folder: " + myFile.getParent());
			} else {
				System.out.println("File not found");
			}
			System.out.println("File size in bytes: " + myFile.length());
			if (myFile.canRead()) {
				System.out.println("File can be read");
			} else {
				System.out.println("File can not be read");
			}
			if (myFile.canWrite()) {
				System.out.println("File can be written");
			} else {
				System.out.println("File can not be written");
			}
		}
	}

	public static void createFile(File myNewFile) {
		try {
			boolean created = myNewFile.createNewFile();
			if (created) {
				System.out.println("File has been created");
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void renameFile(File myFile2, File myNewFile) {
		System.out.print("File " + myFile2.getName());
		myFile2.renameTo(myNewFile);
		System.out.println(" renamed to: " + myNewFile.getName());
	}

	public static void deleteFile(File myNewFile) {
		boolean deleted = myNewFile.delete();
		if (deleted) {
			System.out.println("File has been deleted");
		}
	}

	public static void folderActions(File dir) {
		if (dir.exists()) {
			System.out.println("Folder exists");
			if (dir.isDirectory()) {
				System.out.println("Folder name: " + dir.getName());
				System.out.println("Parent folder: " + dir.getParent());
			} else {
				System.out.println("Folder not found");
			}
			System.out.println("Folder size in bytes: " + dir.length());
			if (dir.canRead()) {
				System.out.println("Folder can be read");
			} else {
				System.out.println("Folder can not be read");
			}
			if (dir.canWrite()) {
				System.out.println("Folder can be written");
			} else {
				System.out.println("Folder can not be written");
			}
			for (File item : Objects.requireNonNull(dir.listFiles())) {
				if (item.isDirectory()) {
					System.out.println(item.getName() + "\t folder");
				} else {
					System.out.println(item.getName() + "\t file");
				}
			}
		}
	}

	public static void createFolder(File dir2) {
		boolean created = dir2.mkdir();
		if (created) {
			System.out.println("New folder created");
		} else {
			System.out.println("New folder not created");
		}
	}

	public static void renameFolder(File dir2, File newDir) {
		System.out.print("Folder " + dir2.getName());
		dir2.renameTo(newDir);
		System.out.println(" renamed to: " + newDir.getName());
	}

	public static void deleteFolder(File newDir) {
		boolean deleted = newDir.delete();
		if (deleted) {
			System.out.println("Folder has been deleted");
		}
	}
}