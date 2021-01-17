package com.augen.model.fontend;

import com.augen.model.entity.DeliveryServiceEntity;

/**
 * Buying Confirmation bundle context
 *
 */
public class BuyingConfirmContext {
	int id;
    DeliveryServiceEntity delyDeliveryService;
    TimeFactor timeFactor;
    double cost;
//    Object book;
    

    public BuyingConfirmContext(DeliveryServiceEntity delyDeliveryService, TimeFactor timeFactor, double cost) {
		super();
		this.delyDeliveryService = delyDeliveryService;
		this.timeFactor = timeFactor;
		this.cost = cost;
	}
    
    public DeliveryServiceEntity getDelyDeliveryService() {
        return delyDeliveryService;
    }
	public void setDelyDeliveryService(DeliveryServiceEntity delyDeliveryService) {
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
