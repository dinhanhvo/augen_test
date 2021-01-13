package com.augen.dto;

public class DeliveryServiceOptionModel extends SelectItemModel {
	double cost;
	
	public DeliveryServiceOptionModel(int value, String label, double cost) {
		super(value, label);
		this.cost = cost;
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
