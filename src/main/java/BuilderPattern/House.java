package BuilderPattern;

public class House {
	private String address;
	private int floors;
	private boolean hasGarage;
	private boolean hasGarden;
	private boolean hasSwimmingPool;

	public House(HouseBuilder builder) {
		this.address = builder.address;
		this.floors = builder.floors;
		this.hasGarage = builder.hasGarage;
		this.hasGarden = builder.hasGarden;
		this.hasSwimmingPool = builder.hasSwimmingPool;
	}

	@Override
	public String toString() {
		return "House{" +
				"address='" + address + '\'' +
				", floors=" + floors +
				", hasGarage=" + hasGarage +
				", hasGarden=" + hasGarden +
				", hasSwimmingPool=" + hasSwimmingPool +
				'}';
	}
}