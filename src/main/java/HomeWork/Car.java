package HomeWork;

import java.io.*;

public class Car {

	private String manufacturer = null;
	private String model = null;

	public Car() {
	}

	public Car(String manufacturer, String model) {
		this.model = model;
		this.manufacturer = manufacturer;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void writeToFile(String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			writer.write("Manufacturer: " + this.manufacturer);
			writer.newLine();
			writer.write("Model: " + this.model);
			System.out.println("Запись прошла успешно");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void readFromFile(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("Чтение прошло успешно");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		Car firstCar = new Car("Porsche ", "911 Turbo");
		try {
			firstCar.writeToFile("CarList.txt");
			firstCar.readFromFile("CarList.txt");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}