package com.augen.augenservicesImpl;

import com.augen.constant.CommonConstant;

public class AirCraft extends DeliveryServiceImpl {

    private String flightNo;
    private String gateNumber;
    
    public AirCraft() {
        this.setBaseCost(CommonConstant.AIRCRAFT_COST);
        this.setDeliveryType(CommonConstant.AIRCRAFT_TYPE);
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

}
