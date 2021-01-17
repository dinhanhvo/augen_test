package com.augen.layer.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.augen.augen.model.BuyingConfirmKeys;
import com.augen.augen.model.DeliveryServiceOptionModel;
import com.augen.constant.CommonConstant;
import com.augen.entity.DeliveryServiceEntity;
import com.augen.layer.database.fake.CostGenerator;
import com.augen.layer.database.fake.DeliveryGenerator;

public class DeliveryServiceService {
	
	public static List<DeliveryServiceOptionModel> getDeliveryServices() {
		// get Delivery Service data entity
	    List<DeliveryServiceEntity> listDelivery = DeliveryGenerator.getDeliveryServiceData();
	    
	    // convert BE delivery service model to FE delivery service options model - for using in drop-down service option
	    List<DeliveryServiceOptionModel> listDSOM = listDelivery.stream().map(item -> {
	    	DeliveryServiceOptionModel md = new DeliveryServiceOptionModel( 
	    			item.getDeliveryName() + CommonConstant.SPLIT + "$" + item.getBaseCost(), // Train | $10 
	    			item.getBaseCost(),
	    			item.getDeliveryType()
			); 
	    	return md;
	    }).collect(Collectors.toList());
	    
	    return listDSOM;
	}

	public static double getRatio(BuyingConfirmKeys context) {
		double ratio = CostGenerator.getRatioByFactors(context);
		System.out.println("DeliveryServiceService.getRatio()========== ratio: " + ratio);
		return ratio;
	}
}
