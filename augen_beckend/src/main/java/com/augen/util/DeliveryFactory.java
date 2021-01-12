package com.augen.util;

import java.util.ArrayList;
import java.util.List;

import com.augen.augenservices.IDeliveryService;
import com.augen.augenservicesImpl.AirCraft;
import com.augen.augenservicesImpl.MotoBike;
import com.augen.augenservicesImpl.Train;

public class DeliveryFactory {

    public static List<IDeliveryService> deliveryList = new ArrayList<IDeliveryService>();
    
    public static List<IDeliveryService> generateDeliveryList() {
        List<IDeliveryService> deliveryList = new ArrayList<IDeliveryService>();
        IDeliveryService moto = new MotoBike();
        IDeliveryService train = new Train();
        IDeliveryService air = new AirCraft();
        
        deliveryList.add(moto);
        deliveryList.add(train);
        deliveryList.add(air);
        
        return deliveryList;
    }
}
