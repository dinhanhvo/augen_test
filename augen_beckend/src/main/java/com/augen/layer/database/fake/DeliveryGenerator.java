package com.augen.layer.database.fake;

import java.util.ArrayList;
import java.util.List;

import com.augen.model.entity.AircraftServiceEntity;
import com.augen.model.entity.DeliveryServiceEntity;
import com.augen.model.entity.MotoBikeEngity;
import com.augen.model.entity.TrainEntity;

public class DeliveryGenerator {

	private static List<DeliveryServiceEntity> deliveryList;
	
	public static void createDeliveryServiceData() {
		deliveryList = new ArrayList<DeliveryServiceEntity>();
		DeliveryServiceEntity moto = new MotoBikeEngity();
		DeliveryServiceEntity train = new TrainEntity();
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
}
