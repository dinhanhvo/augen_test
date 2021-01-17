package com.augen.augenservicesImpl;

import com.augen.augenservices.IDeliveryServiceMotoInfo;
import com.augen.constant.CommonConstant;
import com.augen.layer.database.fake.DeliveryInfoGenerator;
import com.augen.model.entity.DeliveryServiceEntity;
import com.augen.model.entity.MotoBikeEngity;
import com.augen.model.fontend.TimeFactor;

public class DeliveryServiceMotoInfo extends DeliveryServiceInfoService implements IDeliveryServiceMotoInfo {

	public DeliveryServiceMotoInfo(TimeFactor timeFactor, double cost) {
		super(timeFactor, cost);
	}

	/*
	 * generate confirmed delivery info
	 * @return: Train no: traiNo6 | Station of arrival: Train | Date of arrival: June to Aug | Cost: $8.0
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
    	
		DeliveryServiceEntity deliveryService = new MotoBikeEngity();
        ((MotoBikeEngity) deliveryService).setDriverName(ms[0]);
        ((MotoBikeEngity) deliveryService).setMobile(ms[1]);
        this.setDeliveryServiceEntity(deliveryService);
	}

	@Override
	public String generateDriverNameInfo() {
		MotoBikeEngity mb = (MotoBikeEngity) this.getDeliveryServiceEntity();
		return "Driver Name: " + mb.getDriverName();
	}

	@Override
	public String generateDriverMobileInfo() {
		MotoBikeEngity mb = (MotoBikeEngity) this.getDeliveryServiceEntity();
		return "Mobile: " + mb.getMobile();
	}

	@Override
	public String generateDeliveryDateInfo() {
		return "Delivery date: " + timeFactor.getLabel();
	}

}
