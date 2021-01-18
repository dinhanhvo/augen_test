package com.augen.layer.database.fake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.augen.constant.CommonConstant;
import com.augen.model.entity.AircraftServiceEntity;
import com.augen.model.entity.DeliveryServiceEntity;
import com.augen.model.entity.MotoBikeServiceEntity;
import com.augen.model.entity.TrainServiceEntity;
import com.augen.model.fontend.BuyBookModel;

public class DeliveryInfoGenerator {
	private static int size = 10;
	private static List<String[]> motoDeliveryInfo = new ArrayList<>();
    private static List<String[]> trainDeliveryInfo = new ArrayList<>();
    private static List<String[]> airDeliveryInfo = new ArrayList<>();
    
    private static Map<Integer, List<String[]>> deliveryInfoData = new HashMap<Integer, List<String[]>>();
    
    // fake database, store confirmation info into this map
    private static Map<Long, BuyBookModel> listConfirmedString = new HashMap<Long, BuyBookModel>();
    
    // id of stored buying info
    private static long idDeliveryInfo = 0;
    
	/*
	 * Fake data to random Delivery Info
	 */
    public static void  createInfoData() {
        for(int i = 0; i< DeliveryInfoGenerator.size; i++) {
            String[] ms = new String[] {"driverName" + i, "mobileNo"+i};
            DeliveryInfoGenerator.motoDeliveryInfo.add(ms);
            
            String[] trs = new String[] {"traiNo" + i, "stationName"+i};
            DeliveryInfoGenerator.trainDeliveryInfo.add(trs);
            
            String[] as = new String[] {"flightNo" + i, "gateNumber"+i};
            DeliveryInfoGenerator.airDeliveryInfo.add(as);
        }
        
        DeliveryInfoGenerator.deliveryInfoData.put(Integer.valueOf(CommonConstant.MOTOBIKE_TYPE), motoDeliveryInfo);
        DeliveryInfoGenerator.deliveryInfoData.put(Integer.valueOf(CommonConstant.TRAIN_TYPE), trainDeliveryInfo);
        DeliveryInfoGenerator.deliveryInfoData.put(Integer.valueOf(CommonConstant.AIRCRAFT_TYPE), airDeliveryInfo);
    };
    
    public static String[] getDeliveryInfo(int serviceType, int randomIndex) {
    	// create data if not existed yet
    	if (DeliveryInfoGenerator.deliveryInfoData.size() == 0) {
    		DeliveryInfoGenerator.createInfoData();
    	}
    	
    	return DeliveryInfoGenerator.deliveryInfoData.get(serviceType).get(randomIndex);
    }
    
    // get by Id
    public static BuyBookModel getDeliveryInfoStringById(Long id) {
    	return DeliveryInfoGenerator.listConfirmedString.get(id);
    }
    
    public static long saveDeliveryConfirmedInfo(BuyBookModel deliveryInfo) {
    	long id = idDeliveryInfo;
    	DeliveryInfoGenerator.listConfirmedString.put(idDeliveryInfo, deliveryInfo);
    	idDeliveryInfo++;
    	System.out.println("DeliveryInfoGenerator.saveDeliveryConfirmedInfo()======= saved info: " + deliveryInfo);
    	return id;
    }
    
    /**
     * 
     * @param deliveryType
     * @return random delivery info by type
     */
	public static DeliveryServiceEntity getDeliveryEntityByType(int deliveryType) {
		int i = (int) Math.round(Math.random() * 9);

    	DeliveryServiceEntity deliveryService = null;
        if (deliveryType == CommonConstant.MOTOBIKE_TYPE) {
        	String[] ms = DeliveryInfoGenerator.getDeliveryInfo(CommonConstant.MOTOBIKE_TYPE, i);
        	deliveryService = new MotoBikeServiceEntity();
    		((MotoBikeServiceEntity) deliveryService).setDriverName(ms[0]);
    		((MotoBikeServiceEntity) deliveryService).setMobile(ms[1]);
//    		this.setDeliveryServiceEntity(deliveryService);
        } else if (deliveryType == CommonConstant.TRAIN_TYPE) {
        	String[] trs = DeliveryInfoGenerator.getDeliveryInfo(CommonConstant.TRAIN_TYPE, i);
        	
    		deliveryService = new TrainServiceEntity();
    		((TrainServiceEntity) deliveryService).setTrainNo(trs[0]);
    		((TrainServiceEntity) deliveryService).setStationName(trs[1]);
        } else if (deliveryType == CommonConstant.AIRCRAFT_TYPE) {
        	String[] air = DeliveryInfoGenerator.getDeliveryInfo(CommonConstant.AIRCRAFT_TYPE, i);
        	
    		deliveryService = new AircraftServiceEntity();
    		((AircraftServiceEntity) deliveryService).setFlightNo(air[0]);
    		((AircraftServiceEntity) deliveryService).setGateNumber(air[1]);
        }

		return deliveryService;
	}
}
