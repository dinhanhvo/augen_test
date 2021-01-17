package com.augen.layer.services;

import java.util.List;
import java.util.stream.Collectors;

import com.augen.augenservices.IDeliveryServiceInfo;
import com.augen.constant.CommonConstant;
import com.augen.factory.DeliveryServiceInfoFactory;
import com.augen.layer.database.fake.CostGenerator;
import com.augen.layer.database.fake.DeliveryGenerator;
import com.augen.layer.database.fake.DeliveryInfoGenerator;
import com.augen.model.entity.DeliveryServiceEntity;
import com.augen.model.fontend.BuyBookModel;
import com.augen.model.fontend.BuyingConfirmKeys;
import com.augen.model.fontend.DeliveryServiceOptionModel;
import com.augen.model.fontend.TimeFactor;

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
	
	public static long saveConfirmBuying(BuyingConfirmKeys confirmKeysCost) {
		TimeFactor timeFactor = TimeFactorService.getTimeFactor(confirmKeysCost.getTimeFactorType());
        
        // get DeliveryServiceInfoService base on type of service
        // input: timeFactor and cost to generate 'response delivery info'
        IDeliveryServiceInfo deliveryService = DeliveryServiceInfoFactory.getDeliveryServiceInfo(
        		confirmKeysCost.getDeliveryServiceType(), 
        		timeFactor,
        		confirmKeysCost.getCost()
		);
        
        // get random stored delivery info
        deliveryService.getDeliveryEntity();
        
        // generate delivery info to response
        String deliveryInfo = deliveryService.generateConfirmedInfo();
        
        BuyBookModel bbModel = new BuyBookModel(deliveryInfo, confirmKeysCost.getCost(), confirmKeysCost.getBookId());
        
        // fake save to database
        long id = DeliveryInfoGenerator.saveDeliveryConfirmedInfo(bbModel);
        System.out.println("DeliveryServiceService.saveConfirmBuying()==id: "+id+"=====Info: "+deliveryInfo+"==");
        return id;
	}
	
    public static BuyBookModel getDeliveryInfoStringById(Long id) {
    	return DeliveryInfoGenerator.getDeliveryInfoStringById(id);
    }
}
