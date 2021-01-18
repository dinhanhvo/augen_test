package com.augen.model.entity;

import com.augen.constant.CommonConstant;

public class TrainServiceEntity extends ArrivalDeliveryService {

    private String trainNo;
    private String stationName;
    
    public TrainServiceEntity() {
        this.setBaseCost(CommonConstant.TRAIN_COST);
        this.setDeliveryType(CommonConstant.TRAIN_TYPE);
        this.setDeliveryName(CommonConstant.TRAIN_NAME);
    }

    public String getTrainNoInfo() {
		return "Train no: " + this.getTrainNo();
	}

	public String getStationNameInfo() {
		return "Station of arrival: " + this.getDeliveryName();
	}
	
	public String generateArrivalInfo() {
		return "Date of arrival: " + timeFactor.getLabel();
	}
	
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
	
	/* getter and setter*/
    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

}
