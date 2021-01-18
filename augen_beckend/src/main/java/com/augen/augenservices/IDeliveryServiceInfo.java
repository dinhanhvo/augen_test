package com.augen.augenservices;

import com.augen.model.entity.DeliveryServiceEntity;

public interface IDeliveryServiceInfo {

	public String generateCostInfo();
	
	/*
	 * generate confirmed delivery info
	 * @return: Train no: traiNo6 | Station of arrival: Train | Date of arrival: June to Aug | Cost: $8.0
	 */
	public String generateConfirmedInfo();
	
	/*
	 * get random delivery entity from database
	 */
//	public DeliveryServiceEntity getDeliveryEntity();
	
}
