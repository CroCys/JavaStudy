package StrategyPattern;

public class ExpressShipping implements ShippingStrategy {
	@Override
	public double calculateShippingCost(double weight, double distance) {
		return 0.2 * weight * distance;
	}
}