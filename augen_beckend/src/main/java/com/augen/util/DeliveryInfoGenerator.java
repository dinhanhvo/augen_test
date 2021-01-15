package com.augen.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.augen.constant.CommonConstant;
import com.augen.entity.Aircraft;
import com.augen.entity.DeliveryServiceEntity;
import com.augen.entity.MotoBike;
import com.augen.entity.Train;

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
    
	/*
	 * Fake data
	 */
//    public static void generateInfo(DeliveryServiceEntity deliveryServiceImpl) {
//        Random generator = new Random(DeliveryInfoGenerator.size);
//        int i = generator.nextInt();
//        if (deliveryServiceImpl instanceof MotoBike) {
//            String[] ms = DeliveryInfoGenerator.motoDeliveryInfo.get(i);
//            ((MotoBike) deliveryServiceImpl).setDriverName(ms[0]);
//            ((MotoBike) deliveryServiceImpl).setMobile(ms[1]);
//        } else if (deliveryServiceImpl instanceof Train) {
//            String[] ms = DeliveryInfoGenerator.trainDeliveryInfo.get(i);
//            ((Train) deliveryServiceImpl).setTrainNo(ms[0]);
//            ((Train) deliveryServiceImpl).setStationName(ms[1]);
//        } else if (deliveryServiceImpl instanceof Aircraft) {
//            String[] ms = DeliveryInfoGenerator.airDeliveryInfo.get(i);
//            ((Aircraft) deliveryServiceImpl).setFlightNo(ms[0]);
//            ((Aircraft) deliveryServiceImpl).setGateNumber(ms[1]);
//        }
//    }
    
//    public static DeliveryServiceEntity getDeliveryInfo(int deliveryType) {
//    	// create data if not existed yet
//    	if (DeliveryInfoGenerator.motoDeliveryInfo.size() == 0) {
//    		DeliveryInfoGenerator.createInfoData();
//    	}
//    	// get random delivery info
//    	int i = (int) Math.round(Math.random() * 9);
//    	DeliveryServiceEntity deliveryService = null;
//        if (deliveryType == CommonConstant.MOTOBIKE_TYPE) {
//        	deliveryService = new MotoBike();
//        	String[] ms = DeliveryInfoGenerator.motoDeliveryInfo.get(i);
//            ((MotoBike) deliveryService).setDriverName(ms[0]);
//            ((MotoBike) deliveryService).setMobile(ms[1]);
//        } else if (deliveryType == CommonConstant.TRAIN_TYPE) {
//        	deliveryService = new Train();
//        	String[] ms = DeliveryInfoGenerator.trainDeliveryInfo.get(i);
//            ((Train) deliveryService).setTrainNo(ms[0]);
//            ((Train) deliveryService).setStationName(ms[1]);
//        } else if (deliveryType == CommonConstant.AIRCRAFT_TYPE) {
//			deliveryService = new AirCraft();
//			String[] ms = DeliveryInfoGenerator.airDeliveryInfo.get(i);
//			((AirCraft) deliveryService).setFlightNo(ms[0]);
//			((AirCraft) deliveryService).setGateNumber(ms[1]);
//        }
//        
//        return deliveryService;
//    }
    
    public static String[] getDeliveryInfo(int serviceType, int randomIndex) {
    	// create data if not existed yet
    	if (DeliveryInfoGenerator.deliveryInfoData.size() == 0) {
    		DeliveryInfoGenerator.createInfoData();
    	}
    	
    	return DeliveryInfoGenerator.deliveryInfoData.get(serviceType).get(randomIndex);
    }
    
//    public static String getDeliveryInfoString(int deliveryType, String stime, double cost) {
//    	// create data if not existed yet
//    	if (DeliveryInfoGenerator.motoDeliveryInfo.size() == 0) {
//    		DeliveryInfoGenerator.createInfoData();
//    	}
//    	// get random delivery info
//    	int i = (int) Math.round(Math.random() * 9);
//    	
//    	StringBuffer info = new StringBuffer();
//        if (deliveryType == CommonConstant.MOTOBIKE_TYPE) {
//        	String[] ms = DeliveryInfoGenerator.motoDeliveryInfo.get(i);
//        	info.append("Driver Name: ").append(ms[0])
//        		.append(" | Mobile: ").append(ms[1])
//        		.append(" | Delivery date:").append(stime)
//        		.append(" | Cost: $").append(cost);
//        } else if (deliveryType == CommonConstant.TRAIN_TYPE) {
//        	String[] ms = DeliveryInfoGenerator.trainDeliveryInfo.get(i);
//        	info.append("Train no: ").append(ms[0])
//	    		.append(" | Station of arriva: ").append(ms[1])
//	    		.append(" | Date of arrival:").append(stime)
//        		.append(" | Cost: $").append(cost);;
//        } else if (deliveryType == CommonConstant.AIRCRAFT_TYPE) {
//			String[] ms = DeliveryInfoGenerator.airDeliveryInfo.get(i);
//			info.append("Flight no: ").append(ms[0])
//	    		.append(" | Gate of arrival: ").append(ms[1])
//	    		.append(" | Date of arrival:").append(stime)
//        		.append(" | Cost: $").append(cost);;
//        }
//        return info.toString();
//    }
    
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
