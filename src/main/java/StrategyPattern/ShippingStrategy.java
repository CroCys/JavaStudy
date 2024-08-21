package StrategyPattern;

public interface ShippingStrategy {
	double calculateShippingCost(double weight, double distance);
}