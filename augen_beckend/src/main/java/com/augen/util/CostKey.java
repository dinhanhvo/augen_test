package com.augen.util;

public class CostKey {
	private int deliveryServiceType;
	private int timeFactorType;
	private double cost;
	
//	public CostKey(int deliveryServiceType, int timeFactorType) {
//		super();
//		this.deliveryServiceType = deliveryServiceType;
//		this.timeFactorType = timeFactorType;
//	}
	
	public CostKey(int deliveryServiceType, int timeFactorType, double cost) {
		super();
		this.deliveryServiceType = deliveryServiceType;
		this.timeFactorType = timeFactorType;
		this.cost = cost;
	}
	
	public int getDeliveryServiceType() {
		return deliveryServiceType;
	}
	public void setDeliveryServiceType(int deliveryServiceType) {
		this.deliveryServiceType = deliveryServiceType;
	}
	public int getTimeFactorType() {
		return timeFactorType;
	}
	public void setTimeFactorType(int timeFactorType) {
		this.timeFactorType = timeFactorType;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
