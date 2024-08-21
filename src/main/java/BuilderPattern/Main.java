package BuilderPattern;

public class Main {
	public static void main(String[] args) {

		House house = new HouseBuilder("Vyatskay").setFloors(2).setGarage(true).setSwimmingPool(true).build();
		System.out.println(house);

		House smallHouse = new HouseBuilder("Dneprovsky").setFloors(1).setGarden(true).build();
		System.out.println(smallHouse);
	}
}