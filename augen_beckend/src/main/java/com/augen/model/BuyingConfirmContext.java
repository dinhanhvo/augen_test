package com.augen.model;

import com.augen.augenservicesImpl.DeliveryServiceImpl;

public class BuyingConfirmContext {
    DeliveryServiceImpl delyDeliveryService;
    TimeFactor timeFactor;
    double cost;
//    Object book;
    

    public BuyingConfirmContext(DeliveryServiceImpl delyDeliveryService, TimeFactor timeFactor, double cost) {
		super();
		this.delyDeliveryService = delyDeliveryService;
		this.timeFactor = timeFactor;
		this.cost = cost;
	}
    
    public DeliveryServiceImpl getDelyDeliveryService() {
        return delyDeliveryService;
    }
	public void setDelyDeliveryService(DeliveryServiceImpl delyDeliveryService) {
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
