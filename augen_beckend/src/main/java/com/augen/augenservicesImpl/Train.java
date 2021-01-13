package com.augen.augenservicesImpl;

import com.augen.constant.CommonConstant;

public class Train extends DeliveryServiceImpl {

    private String trainNo;
    private String stationName;
    
    public Train() {
        this.setBaseCost(CommonConstant.TRAIN_COST);
        this.setDeliveryType(CommonConstant.TRAIN_TYPE);
        this.setDeliveryName(CommonConstant.TRAIN_NAME);
    }

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
