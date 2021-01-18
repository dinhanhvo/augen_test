package com.augen.model.entity;

import com.augen.constant.CommonConstant;

public class AircraftServiceEntity extends ArrivalDeliveryService {

    private String flightNo;
    private String gateNumber;
    
    public AircraftServiceEntity() {
        this.setBaseCost(CommonConstant.AIRCRAFT_COST);
        this.setDeliveryType(CommonConstant.AIRCRAFT_TYPE);
        this.setDeliveryName(CommonConstant.AIRCRAFT_NAME);
    }
    
	public String generateFlightNo() {
		return "Flight no: " + this.getFlightNo();
	}

	public String generateGateNumber() {
		return "Gate of arrival: " + this.getGateNumber();
	}
    
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

	
	/** getters and setters**/
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
