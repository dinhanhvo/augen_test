package com.augen.util;

import java.util.List;

import com.augen.augenservicesImpl.AirCraft;
import com.augen.augenservicesImpl.DeliveryServiceImpl;
import com.augen.augenservicesImpl.MotoBike;
import com.augen.augenservicesImpl.Train;

public class DeliveryGenerator {

    public static void getDeliveryServiceData(List<DeliveryServiceImpl> deliveryList) {
        DeliveryServiceImpl moto = new MotoBike();
        DeliveryServiceImpl train = new Train();
        DeliveryServiceImpl air = new AirCraft();
        
        deliveryList.add(moto);
        deliveryList.add(train);
        deliveryList.add(air);
    }
}
