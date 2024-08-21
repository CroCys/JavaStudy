package StrategyPattern;

public class Order {
	private double weight;
	private double distance;
	private ShippingStrategy strategy;

	public Order(double weight, double distance) {
		this.weight = weight;
		this.distance = distance;
	}

	public void setStrategy(ShippingStrategy strategy) {
		this.strategy = strategy;
	}

	public double calculateTotalShippingCost() {
		return strategy.calculateShippingCost(weight, distance);
	}
}