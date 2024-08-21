package StrategyPattern;

public class Main {
	public static void main(String[] args) {
		Order order = new Order(10, 150);

		// Наземная доставка
		order.setStrategy(new GroundShipping());
		System.out.println("Ground Shipping Cost: " + order.calculateTotalShippingCost());
		// Авиадоставка
		order.setStrategy(new AirShipping());
		System.out.println("Air Shipping Cost: " + order.calculateTotalShippingCost());
		// Экспресс доставка
		order.setStrategy(new ExpressShipping());
		System.out.println("Express Shipping Cost: " + order.calculateTotalShippingCost());
	}
}