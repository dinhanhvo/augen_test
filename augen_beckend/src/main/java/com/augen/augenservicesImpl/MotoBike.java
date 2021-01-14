package com.augen.augenservicesImpl;

import java.util.Date;

import com.augen.constant.CommonConstant;

public class MotoBike extends DeliveryService {

    private String driverName;
    private String mobile;
    private Date deliveryDate;
    
    public MotoBike() {
        this.setBaseCost(CommonConstant.MOTOBIKE_COST);
        this.setDeliveryType(CommonConstant.MOTOBIKE_TYPE);
        this.setDeliveryName(CommonConstant.MOTOBIKE_NAME);
    }

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
