package com.augen.layer.database.fake;

import java.util.ArrayList;
import java.util.List;

import com.augen.constant.CommonConstant;
import com.augen.model.entity.AircraftServiceEntity;
import com.augen.model.entity.DeliveryServiceEntity;
import com.augen.model.entity.MotoBikeServiceEntity;
import com.augen.model.entity.TrainServiceEntity;

public class DeliveryGenerator {

	private static List<DeliveryServiceEntity> deliveryList;
	
	public static void createDeliveryServiceData() {
		deliveryList = new ArrayList<DeliveryServiceEntity>();
		DeliveryServiceEntity moto = new MotoBikeServiceEntity();
		DeliveryServiceEntity train = new TrainServiceEntity();
		DeliveryServiceEntity air = new AircraftServiceEntity();

		deliveryList.add(moto);
		deliveryList.add(train);
		deliveryList.add(air);
		
	}
	
    public static List<DeliveryServiceEntity> getDeliveryServiceData() {
    	if (deliveryList == null || deliveryList.size() == 0) {
    		createDeliveryServiceData();
    	}
        
		return deliveryList;
    }
    
//	public DeliveryServiceEntity getDeliveryEntityByType(int deliveryType) {
//		// get random delivery info
//		int i = (int) Math.round(Math.random() * 9);
//		String[] ms = DeliveryInfoGenerator.getDeliveryInfo(CommonConstant.MOTOBIKE_TYPE, i);
//
//    	DeliveryServiceEntity deliveryService = null;
//        if (deliveryType == CommonConstant.MOTOBIKE_TYPE) {
//        	deliveryService = new MotoBikeServiceEngity();
//    		((MotoBikeServiceEngity) deliveryService).setDriverName(ms[0]);
//    		((MotoBikeServiceEngity) deliveryService).setMobile(ms[1]);
////    		this.setDeliveryServiceEntity(deliveryService);
//        } else if (deliveryType == CommonConstant.TRAIN_TYPE) {
//        } else if (deliveryType == CommonConstant.AIRCRAFT_TYPE) {
//        }
//
//		return deliveryService;
//	}
}
