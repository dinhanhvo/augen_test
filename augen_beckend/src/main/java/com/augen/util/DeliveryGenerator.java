package com.augen.util;

import java.util.List;

import com.augen.augenservicesImpl.AirCraft;
import com.augen.augenservicesImpl.DeliveryService;
import com.augen.augenservicesImpl.MotoBike;
import com.augen.augenservicesImpl.Train;

public class DeliveryGenerator {

    public static void getDeliveryServiceData(List<DeliveryService> deliveryList) {
        DeliveryService moto = new MotoBike();
        DeliveryService train = new Train();
        DeliveryService air = new AirCraft();
        
        deliveryList.add(moto);
        deliveryList.add(train);
        deliveryList.add(air);
    }
}
