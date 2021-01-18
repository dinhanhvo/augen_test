package com.augen.model.entity;

import com.augen.augenservices.IDeliveryServiceInfo;
import com.augen.model.fontend.TimeFactor;

public abstract class DeliveryServiceEntity implements IDeliveryServiceInfo {

    protected byte deliveryType; // 1, 2, 3
    protected String deliveryName; // Motobike, Train, Aircraft
    protected double baseCost; // 5, 10, 20
    protected double cost = -1; // cost after adjust with time factor
    protected TimeFactor timeFactor = null;
    
	public String generateCostInfo() {
		return "Cost: $" + this.getCost();
	}
	
//	public String generateConfirmedInfo() {
//		return null;
//	}
	
//	public void getDeliveryEntity() {
//	}
	
	/** getters and setters**/
    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public byte getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(byte deliveryType) {
        this.deliveryType = deliveryType;
    }

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public TimeFactor getTimeFactor() {
		return timeFactor;
	}

	public void setTimeFactor(TimeFactor timeFactor) {
		this.timeFactor = timeFactor;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
