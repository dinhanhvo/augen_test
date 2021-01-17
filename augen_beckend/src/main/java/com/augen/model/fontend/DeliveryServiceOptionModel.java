package com.augen.model.fontend;

public class DeliveryServiceOptionModel extends TimeFactor {
	double cost;
	
	public DeliveryServiceOptionModel(String label, double cost, int type) {
		super(label, type);
		this.cost = cost;
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

}
