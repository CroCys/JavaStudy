package BuilderPattern;

public class HouseBuilder {
	String address;
	int floors;
	boolean hasGarage;
	boolean hasGarden;
	boolean hasSwimmingPool;

	// Обязательные поля в конструкторе билдера
	public HouseBuilder (String address) {
		if (address == null || address.isEmpty()) {
			throw new IllegalArgumentException("Address cannot be null or empty");
		}
		this.address = address;
	}

	public HouseBuilder setFloors(int floors) {
		this.floors = floors;
		return this;
	}

	public HouseBuilder setGarage(boolean hasGarage) {
		this.hasGarage = hasGarage;
		return this;
	}

	public HouseBuilder setGarden(boolean hasGarden) {
		this.hasGarden = hasGarden;
		return this;
	}

	public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
		this.hasSwimmingPool = hasSwimmingPool;
		return this;
	}

	public House build() {
		return new House(this);
	}
}