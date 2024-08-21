package StrategyPattern;

public class GroundShipping implements ShippingStrategy {
	@Override
	public double calculateShippingCost(double weight, double distance) {
		return 0.05 * weight * distance;
	}
}