package com.augen.model;

import com.augen.dto.DeliveryServiceOptionModel;
import com.augen.dto.SelectItemModel;

public class AdjustCostContext {
	SelectItemModel timeFactor;
	DeliveryServiceOptionModel deliveryService;
	
	public AdjustCostContext(SelectItemModel timeFactor, DeliveryServiceOptionModel deliveryService) {
		super();
		this.timeFactor = timeFactor;
		this.deliveryService = deliveryService;
	}
	
	public SelectItemModel getTimeFactor() {
		return timeFactor;
	}
	public void setTimeFactor(SelectItemModel timeFactor) {
		this.timeFactor = timeFactor;
	}
	public DeliveryServiceOptionModel getDeliveryService() {
		return deliveryService;
	}
	public void setDeliveryService(DeliveryServiceOptionModel deliveryService) {
		this.deliveryService = deliveryService;
	}

	
}
