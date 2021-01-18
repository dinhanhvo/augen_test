package com.augen.model.entity;

import java.util.Date;

import com.augen.augenservices.IDeliveryServiceMotoInfo;
import com.augen.constant.CommonConstant;

public class MotoBikeServiceEntity extends DeliveryServiceEntity implements IDeliveryServiceMotoInfo {

    private String driverName;
    private String mobile;
    private Date deliveryDate;
    
    public MotoBikeServiceEntity() {
        this.setBaseCost(CommonConstant.MOTOBIKE_COST);
        this.setDeliveryType(CommonConstant.MOTOBIKE_TYPE);
        this.setDeliveryName(CommonConstant.MOTOBIKE_NAME);
    }

    public String generateDriverNameInfo() {
		return "Driver Name: " + this.getDriverName();
	}

	public String generateDriverMobileInfo() {
		return "Mobile: " + this.getMobile();
	}

	public String generateDeliveryDateInfo() {
		return "Delivery date: " + timeFactor.getLabel();
	}
	
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
	
	/**getters and setters**/
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

}
