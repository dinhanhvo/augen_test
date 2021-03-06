package com.augen.layer.services;

import java.util.List;
import java.util.stream.Collectors;

import com.augen.constant.CommonConstant;
import com.augen.layer.database.fake.CostGenerator;
import com.augen.layer.database.fake.DeliveryGenerator;
import com.augen.layer.database.fake.DeliveryInfoGenerator;
import com.augen.model.entity.DeliveryServiceEntity;
import com.augen.model.fontend.BuyBookModel;
import com.augen.model.fontend.BuyingConfirmKeys;
import com.augen.model.fontend.DeliveryServiceOptionModel;
import com.augen.model.fontend.TimeFactor;

public class DeliveryServiceService {
	
    /**
     * 
     * @return 'Delivery service name | Cost' for user choose
     */
	public static List<DeliveryServiceOptionModel> getDeliveryServices() {
		// get Delivery Service data entity
	    List<DeliveryServiceEntity> listDelivery = DeliveryGenerator.getDeliveryServiceData();
	    
	    // convert BE delivery service model to FE delivery service options model - for using in drop-down service option
	    List<DeliveryServiceOptionModel> listDSOM = listDelivery.stream().map(item -> {
	    	DeliveryServiceOptionModel md = new DeliveryServiceOptionModel( 
	    			item.getCaption(), // Train | $10 
	    			item.getBaseCost(),
	    			item.getDeliveryType()
			); 
	    	return md;
	    }).collect(Collectors.toList());
	    
	    return listDSOM;
	}

	/**
	 * 
	 * @param context buying confirmed keys
	 * @return ratio base on delivery service and time factor
	 */
	public static double getRatio(BuyingConfirmKeys context) {
		double ratio = CostGenerator.getRatioByFactors(context);
		System.out.println("DeliveryServiceService.getRatio()========== ratio: " + ratio);
		return ratio;
	}
	
	/**
	 * @param: BuyingConfirmKeys to be saved
	 * @return: id of stored delivery info
	 */
	public static long saveConfirmBuying(BuyingConfirmKeys confirmKeysCost) {
		TimeFactor timeFactor = TimeFactorService.getTimeFactor(confirmKeysCost.getTimeFactorType());
        
		// get random DeliveryServiceEntity stored delivery info
        int serviceType = confirmKeysCost.getDeliveryServiceType();
        DeliveryServiceEntity deliveryService = DeliveryInfoGenerator.getDeliveryEntityByType(serviceType);
        deliveryService.setTimeFactor(timeFactor);
        deliveryService.setCost(confirmKeysCost.getCost());
         
        // generate delivery info to response
        String deliveryInfo = deliveryService.generateConfirmedInfo();
        
        // wrapper info to BuyBookModel
        BuyBookModel bbModel = new BuyBookModel(deliveryInfo, confirmKeysCost.getCost(), confirmKeysCost.getBookId());
        
        // fake save to database
        long id = DeliveryInfoGenerator.saveDeliveryConfirmedInfo(bbModel);
        
        System.out.println("DeliveryServiceService.saveConfirmBuying()==id: "+id+"== bbModel: " + bbModel);
        return id;
	}
	
	/**
	 * 
	 * @param id
	 * @return saved BuyBookModel by Id
	 */
    public static BuyBookModel getDeliveryInfoStringById(Long id) {
    	return DeliveryInfoGenerator.getDeliveryInfoStringById(id);
    }
}
