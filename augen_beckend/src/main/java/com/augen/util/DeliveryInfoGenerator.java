package com.augen.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.augen.augenservicesImpl.AirCraft;
import com.augen.augenservicesImpl.DeliveryServiceImpl;
import com.augen.augenservicesImpl.MotoBike;
import com.augen.augenservicesImpl.Train;

public class DeliveryInfoGenerator {
    private static int size = 10;
    private static List<String[]> motoDeliveryInfo = new ArrayList<>();
    private static List<String[]> trainDeliveryInfo = new ArrayList<>();
    private static List<String[]> airDeliveryInfo = new ArrayList<>();
    
    public static void  createInfoData() {
        for(int i = 0; i< DeliveryInfoGenerator.size; i++) {
            String[] ms = new String[] {"driverName" + i, "00"+i};
            DeliveryInfoGenerator.motoDeliveryInfo.add(ms);
            
            String[] trs = new String[] {"traiNo" + i, "stationName"+i};
            DeliveryInfoGenerator.trainDeliveryInfo.add(trs);
            
            String[] as = new String[] {"flightNo" + i, "gateNumber"+i};
            DeliveryInfoGenerator.airDeliveryInfo.add(as);
        }
    };
    
    public static void generateInfo(DeliveryServiceImpl deliveryServiceImpl) {
        Random generator = new Random(DeliveryInfoGenerator.size);
        int i = generator.nextInt();
        if (deliveryServiceImpl instanceof MotoBike) {
            String[] ms = DeliveryInfoGenerator.motoDeliveryInfo.get(i);
            ((MotoBike) deliveryServiceImpl).setDriverName(ms[0]);
            ((MotoBike) deliveryServiceImpl).setMobile(ms[1]);
        } else if (deliveryServiceImpl instanceof Train) {
            String[] ms = DeliveryInfoGenerator.trainDeliveryInfo.get(i);
            ((Train) deliveryServiceImpl).setTrainNo(ms[0]);
            ((Train) deliveryServiceImpl).setStationName(ms[1]);
        } else if (deliveryServiceImpl instanceof AirCraft) {
            String[] ms = DeliveryInfoGenerator.airDeliveryInfo.get(i);
            ((AirCraft) deliveryServiceImpl).setFlightNo(ms[0]);
            ((AirCraft) deliveryServiceImpl).setGateNumber(ms[1]);
        }
    }
}
