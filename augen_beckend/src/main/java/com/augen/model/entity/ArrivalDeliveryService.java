package com.augen.model.entity;

import java.util.Date;

public abstract class ArrivalDeliveryService extends DeliveryServiceEntity {

	protected Date dateArrival;

	public Date getDateArrival() {
		return dateArrival;
	}

	public void setDateArrival(Date dateArrival) {
		this.dateArrival = dateArrival;
	}

}
