package com.augen.util;

import java.util.ArrayList;
import java.util.List;

import com.augen.augenservices.IDeliveryService;
import com.augen.augenservicesImpl.AirCraft;
import com.augen.augenservicesImpl.DeliveryServiceImpl;
import com.augen.augenservicesImpl.MotoBike;
import com.augen.augenservicesImpl.Train;

public class DeliveryFactory {

    public static List<IDeliveryService> deliveryList = new ArrayList<IDeliveryService>();
    
    public static List<DeliveryServiceImpl> generateDeliveryList() {
        List<DeliveryServiceImpl> deliveryList = new ArrayList<DeliveryServiceImpl>();
        DeliveryServiceImpl moto = new MotoBike();
        DeliveryServiceImpl train = new Train();
        DeliveryServiceImpl air = new AirCraft();
        
        deliveryList.add(moto);
        deliveryList.add(train);
        deliveryList.add(air);
        
        return deliveryList;
    }
}
