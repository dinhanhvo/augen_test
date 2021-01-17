package com.augen.layer.database.fake;

import java.util.ArrayList;
import java.util.List;

import com.augen.entity.Aircraft;
import com.augen.entity.DeliveryServiceEntity;
import com.augen.entity.MotoBike;
import com.augen.entity.Train;

public class DeliveryGenerator {

	private static List<DeliveryServiceEntity> deliveryList;
	
	public static void createDeliveryServiceData() {
		deliveryList = new ArrayList<DeliveryServiceEntity>();
		DeliveryServiceEntity moto = new MotoBike();
		DeliveryServiceEntity train = new Train();
		DeliveryServiceEntity air = new Aircraft();

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
