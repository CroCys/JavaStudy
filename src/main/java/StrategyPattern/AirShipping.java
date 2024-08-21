package StrategyPattern;

public class AirShipping implements ShippingStrategy {
	@Override
	public double calculateShippingCost(double weight, double distance) {
		return 0.1 * weight * distance;
	}
}