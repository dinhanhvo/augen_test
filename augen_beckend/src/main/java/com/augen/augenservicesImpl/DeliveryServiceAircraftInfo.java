package com.augen.augenservicesImpl;

import com.augen.augenservices.IDeliveryServiceAirInfo;
import com.augen.augenservices.IDeliveryServiceInfo;
import com.augen.constant.CommonConstant;
import com.augen.layer.database.fake.DeliveryInfoGenerator;
import com.augen.model.entity.AircraftServiceEntity;
import com.augen.model.entity.DeliveryServiceEntity;
import com.augen.model.fontend.TimeFactor;

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
		AircraftServiceEntity acr = (AircraftServiceEntity) this.getDeliveryServiceEntity();
		return "Flight no: " + acr.getFlightNo();
	}

	@Override
	public String generateGateNumber() {
		AircraftServiceEntity acr = (AircraftServiceEntity) this.getDeliveryServiceEntity();
		return "Gate of arrival: " + acr.getGateNumber();
	}

	/*
	 * generate confirmed delivery info
	 * @return: Train no: traiNo6 | Station of arrival: Train | Date of arrival: June to Aug | Cost: $8.0
	 */
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

//	@Override
//	public void getDeliveryEntity() {
//		// get random delivery info
//    	int i = (int) Math.round(Math.random() * 9);
//    	String[] ms = DeliveryInfoGenerator.getDeliveryInfo(CommonConstant.AIRCRAFT_TYPE, i);
//    	
//		DeliveryServiceEntity deliveryService = new AircraftServiceEntity();
//		((AircraftServiceEntity) deliveryService).setFlightNo(ms[0]);
//		((AircraftServiceEntity) deliveryService).setGateNumber(ms[1]);
//		
//        this.setDeliveryServiceEntity(deliveryService);
//	}

}
