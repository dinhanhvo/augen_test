package com.augen.layer.database.fake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.augen.constant.CommonConstant;

public class DeliveryInfoGenerator {
	public static int size = 10;
    public static List<String[]> motoDeliveryInfo = new ArrayList<>();
    public static List<String[]> trainDeliveryInfo = new ArrayList<>();
    public static List<String[]> airDeliveryInfo = new ArrayList<>();
    
    public static Map<Integer, List<String[]>> deliveryInfoData = new HashMap<Integer, List<String[]>>();
    
    // fake database, store confirmation info into
    public static Map<Long, String> listConfirmedString = new HashMap<Long, String>();
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
        
        DeliveryInfoGenerator.deliveryInfoData.put(new Integer(CommonConstant.MOTOBIKE_TYPE), motoDeliveryInfo);
        DeliveryInfoGenerator.deliveryInfoData.put(new Integer(CommonConstant.TRAIN_TYPE), trainDeliveryInfo);
        DeliveryInfoGenerator.deliveryInfoData.put(new Integer(CommonConstant.AIRCRAFT_TYPE), airDeliveryInfo);
    };
    
    public static String[] getDeliveryInfo(int serviceType, int randomIndex) {
    	// create data if not existed yet
    	if (DeliveryInfoGenerator.deliveryInfoData.size() == 0) {
    		DeliveryInfoGenerator.createInfoData();
    	}
    	
    	return DeliveryInfoGenerator.deliveryInfoData.get(serviceType).get(randomIndex);
    }
    
    public static String getDeliveryInfoStringById(Long id) {
    	return DeliveryInfoGenerator.listConfirmedString.get(id);
    }
    
    public static long saveDeliveryConfirmedInfo(String deliveryInfo) {
    	long id = idDeliveryInfo;
    	DeliveryInfoGenerator.listConfirmedString.put(idDeliveryInfo, deliveryInfo);
    	idDeliveryInfo++;
    	System.out.println("DeliveryInfoGenerator.saveDeliveryConfirmedInfo()======= saved info: " + deliveryInfo);
    	return id;
    }
}
