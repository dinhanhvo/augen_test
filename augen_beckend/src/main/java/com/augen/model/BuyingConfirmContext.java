package com.augen.model;

import com.augen.augenservicesImpl.DeliveryService;

public class BuyingConfirmContext {
	int id;
    DeliveryService delyDeliveryService;
    TimeFactor timeFactor;
    double cost;
//    Object book;
    

    public BuyingConfirmContext(DeliveryService delyDeliveryService, TimeFactor timeFactor, double cost) {
		super();
		this.delyDeliveryService = delyDeliveryService;
		this.timeFactor = timeFactor;
		this.cost = cost;
	}
    
    public DeliveryService getDelyDeliveryService() {
        return delyDeliveryService;
    }
	public void setDelyDeliveryService(DeliveryService delyDeliveryService) {
        this.delyDeliveryService = delyDeliveryService;
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
