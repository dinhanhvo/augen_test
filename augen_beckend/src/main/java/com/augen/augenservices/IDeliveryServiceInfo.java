package com.augen.augenservices;

public interface IDeliveryServiceInfo {

	public String generateCostInfo();
	public String generateConfirmedInfo();
	
	/*
	 * get delivery entity from database
	 */
	public void getDeliveryEntity();
	
}
