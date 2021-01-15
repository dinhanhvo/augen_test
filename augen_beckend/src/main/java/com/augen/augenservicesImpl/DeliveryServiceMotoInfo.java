package com.augen.augenservicesImpl;

import com.augen.augenservices.IDeliveryServiceMotoInfo;
import com.augen.constant.CommonConstant;
import com.augen.entity.DeliveryServiceEntity;
import com.augen.entity.MotoBike;
import com.augen.model.TimeFactor;
import com.augen.util.DeliveryInfoGenerator;

public class DeliveryServiceMotoInfo extends DeliveryServiceInfoService implements IDeliveryServiceMotoInfo {

	public DeliveryServiceMotoInfo(TimeFactor timeFactor, double cost) {
		super(timeFactor, cost);
	}

	/*
	 * generate delivery info to response to client
	 */
	@Override
	public String generateConfirmedInfo() {
		StringBuffer info = new StringBuffer();
    	info.append(this.generateDriverNameInfo())
    		.append(CommonConstant.SPLIT)
    		.append(this.generateDriverMobileInfo())
    		.append(CommonConstant.SPLIT)
    		.append(this.generateDeliveryDateInfo())
    		.append(CommonConstant.SPLIT)
    		.append(this.generateCostInfo());
		return info.toString();
	}

	/*
	 * fake get from database by random
	 */
	@Override
	public void getDeliveryEntity() {
		// get random delivery info
    	int i = (int) Math.round(Math.random() * 9);
    	String[] ms = DeliveryInfoGenerator.getDeliveryInfo(CommonConstant.MOTOBIKE_TYPE, i);
    	
		DeliveryServiceEntity deliveryService = new MotoBike();
        ((MotoBike) deliveryService).setDriverName(ms[0]);
        ((MotoBike) deliveryService).setMobile(ms[1]);
        this.setDeliveryServiceEntity(deliveryService);
	}

	@Override
	public String generateDriverNameInfo() {
		MotoBike mb = (MotoBike) this.getDeliveryServiceEntity();
		return "Driver Name: " + mb.getDriverName();
	}

	@Override
	public String generateDriverMobileInfo() {
		MotoBike mb = (MotoBike) this.getDeliveryServiceEntity();
		return "Mobile: " + mb.getMobile();
	}

	@Override
	public String generateDeliveryDateInfo() {
		return "Delivery date: " + timeFactor.getLabel();
	}

}
