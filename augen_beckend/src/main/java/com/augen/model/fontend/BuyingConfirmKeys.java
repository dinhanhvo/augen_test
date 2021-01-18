package com.augen.model.fontend;

/**
 * Receive confirmed info of user by this model
 *
 */
public class BuyingConfirmKeys {
	private int deliveryServiceType;
	private int timeFactorType;
	private double cost;
	private String bookId;
	
	public BuyingConfirmKeys(int deliveryServiceType, int timeFactorType, double cost, String bookId) {
		super();
		this.deliveryServiceType = deliveryServiceType;
		this.timeFactorType = timeFactorType;
		this.cost = cost;
		this.bookId = bookId;
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

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
}
