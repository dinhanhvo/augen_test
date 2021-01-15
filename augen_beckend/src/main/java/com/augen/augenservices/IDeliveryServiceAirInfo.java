package com.augen.augenservices;

public interface IDeliveryServiceAirInfo extends IDeliveryServiceArrivalInfo {

	public String generateFlightNo();
	public String generateGateNumber();

}
