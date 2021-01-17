package com.augen.factory;

import com.augen.augenservices.IDeliveryServiceInfo;
import com.augen.augenservicesImpl.DeliveryServiceAircraftInfo;
import com.augen.augenservicesImpl.DeliveryServiceMotoInfo;
import com.augen.augenservicesImpl.DeliveryServiceTrainInfo;
import com.augen.constant.CommonConstant;
import com.augen.model.fontend.TimeFactor;

public class DeliveryServiceInfoFactory {

	/*
	 * get DeliveryServiceInfoService base on type of service
	 * input: timeFactor and cost to generate 'response delivery info'
	 */
	public static IDeliveryServiceInfo getDeliveryServiceInfo(int deliveryType, TimeFactor timeFactor, double cost) {
    	IDeliveryServiceInfo deliveryService = null;
        if (deliveryType == CommonConstant.MOTOBIKE_TYPE) {
        	deliveryService = new DeliveryServiceMotoInfo(timeFactor, cost);
        } else if (deliveryType == CommonConstant.TRAIN_TYPE) {
        	deliveryService = new DeliveryServiceTrainInfo(timeFactor, cost);
        } else if (deliveryType == CommonConstant.AIRCRAFT_TYPE) {
        	deliveryService = new DeliveryServiceAircraftInfo(timeFactor, cost);
        }
        
        return deliveryService;
    }
}
