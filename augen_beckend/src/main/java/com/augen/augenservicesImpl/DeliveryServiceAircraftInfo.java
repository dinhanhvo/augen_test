package com.augen.augenservicesImpl;

import com.augen.augenservices.IDeliveryServiceAirInfo;
import com.augen.augenservices.IDeliveryServiceInfo;
import com.augen.constant.CommonConstant;
import com.augen.entity.Aircraft;
import com.augen.entity.DeliveryServiceEntity;
import com.augen.model.TimeFactor;
import com.augen.util.DeliveryInfoGenerator;

public class DeliveryServiceAircraftInfo extends DeliveryServiceInfoService
		implements IDeliveryServiceInfo, IDeliveryServiceAirInfo {

	public DeliveryServiceAircraftInfo(TimeFactor timeFactor, double cost) {
		super(timeFactor, cost);
	}

	@Override
	public String generateArrivalInfo() {
		return "Date of arrival: " + timeFactor.getLabel();
	}

	@Override
	public String generateFlightNo() {
		Aircraft acr = (Aircraft) this.getDeliveryServiceEntity();
		return "Flight no: " + acr.getFlightNo();
	}

	@Override
	public String generateGateNumber() {
		Aircraft acr = (Aircraft) this.getDeliveryServiceEntity();
		return "Gate of arrival: " + acr.getGateNumber();
	}

	@Override
	public String generateConfirmedInfo() {
		StringBuffer info = new StringBuffer();
    	info.append(this.generateFlightNo())
    		.append(CommonConstant.SPLIT)
    		.append(this.generateGateNumber())
    		.append(CommonConstant.SPLIT)
    		.append(this.generateArrivalInfo())
    		.append(CommonConstant.SPLIT)
    		.append(this.generateCostInfo());
		return info.toString();
	}

	@Override
	public void getDeliveryEntity() {
		// get random delivery info
    	int i = (int) Math.round(Math.random() * 9);
    	String[] ms = DeliveryInfoGenerator.getDeliveryInfo(CommonConstant.AIRCRAFT_TYPE, i);
    	
		DeliveryServiceEntity deliveryService = new Aircraft();
		((Aircraft) deliveryService).setFlightNo(ms[0]);
		((Aircraft) deliveryService).setGateNumber(ms[1]);
		
        this.setDeliveryServiceEntity(deliveryService);
	}

}