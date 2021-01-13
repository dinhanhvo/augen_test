package com.augen.augenservicesImpl;

import java.util.Date;

import com.augen.augenservices.IDeliveryService;
import com.augen.model.DeliveryFactor;

public class DeliveryServiceImpl implements IDeliveryService {

    protected byte deliveryType;
    protected String deliveryName;
    protected double baseCost;
    protected DeliveryFactor deliveryFactor;
    protected Date dateArrival;
    
    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public DeliveryFactor getDeliveryFactor() {
        return deliveryFactor;
    }

    public void setDeliveryFactor(DeliveryFactor deliveryFactor) {
        this.deliveryFactor = deliveryFactor;
    }

    public double getCost() {
        double cost = this.getBaseCost() * this.getDeliveryFactor().getRatio();
        return cost;
    }

    public Date getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
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
    
}
