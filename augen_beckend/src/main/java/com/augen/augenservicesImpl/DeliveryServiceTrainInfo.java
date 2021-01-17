package com.augen.augenservicesImpl;

import com.augen.augenservices.IDeliveryServiceArrivalInfo;
import com.augen.augenservices.IDeliveryServiceTrainInfo;
import com.augen.constant.CommonConstant;
import com.augen.layer.database.fake.DeliveryInfoGenerator;
import com.augen.model.entity.DeliveryServiceEntity;
import com.augen.model.entity.TrainEntity;
import com.augen.model.fontend.TimeFactor;

public class DeliveryServiceTrainInfo extends DeliveryServiceInfoService 
							implements IDeliveryServiceTrainInfo, IDeliveryServiceArrivalInfo {


	public DeliveryServiceTrainInfo(TimeFactor timeFactor, double cost) {
		super(timeFactor, cost);
	}

	@Override
	public String getTrainNoInfo() {
		TrainEntity tr = (TrainEntity) this.getDeliveryServiceEntity();
		return "Train no: " + tr.getTrainNo();
	}

	@Override
	public String getStationNameInfo() {
		TrainEntity tr = (TrainEntity) this.getDeliveryServiceEntity();
		return "Station of arrival: " + tr.getDeliveryName();
	}
	
	@Override
	public String generateArrivalInfo() {
		return "Date of arrival: " + timeFactor.getLabel();
	}
	
	/*
	 * generate confirmed delivery info
	 * @return: Train no: traiNo6 | Station of arrival: Train | Date of arrival: June to Aug | Cost: $8.0
	 */
	@Override
	public String generateConfirmedInfo() {
		StringBuffer info = new StringBuffer();
    	info.append(this.getTrainNoInfo())
    		.append(CommonConstant.SPLIT)
    		.append(this.getStationNameInfo())
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
    	String[] trs = DeliveryInfoGenerator.getDeliveryInfo(CommonConstant.TRAIN_TYPE, i);
    	
		DeliveryServiceEntity deliveryService = new TrainEntity();
		((TrainEntity) deliveryService).setTrainNo(trs[0]);
		((TrainEntity) deliveryService).setStationName(trs[1]);
		
        this.setDeliveryServiceEntity(deliveryService);
		
	}

}
