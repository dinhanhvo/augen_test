package com.augen.augenservicesImpl;

import com.augen.entity.DeliveryServiceEntity;
import com.augen.model.TimeFactor;

public class DeliveryServiceInfoService {
	private DeliveryServiceEntity deliveryServiceEntity = null;
	protected TimeFactor timeFactor = null;
	protected double cost = -1;

	public DeliveryServiceInfoService(TimeFactor timeFactor, double cost) {
		super();
		this.timeFactor = timeFactor;
		this.cost = cost;
	}
	
	public DeliveryServiceEntity getDeliveryServiceEntity() {
		return deliveryServiceEntity;
	}

	public void setDeliveryServiceEntity(DeliveryServiceEntity deliveryService) {
		this.deliveryServiceEntity = deliveryService;
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
	
	public String generateCostInfo() {
		return "Cost: $" + this.getCost();
	}

}
