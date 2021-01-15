package com.augen.util;

import java.util.List;

import com.augen.entity.Aircraft;
import com.augen.entity.DeliveryServiceEntity;
import com.augen.entity.MotoBike;
import com.augen.entity.Train;

public class DeliveryGenerator {

    public static void getDeliveryServiceData(List<DeliveryServiceEntity> deliveryList) {
        DeliveryServiceEntity moto = new MotoBike();
        DeliveryServiceEntity train = new Train();
        DeliveryServiceEntity air = new Aircraft();
        
        deliveryList.add(moto);
        deliveryList.add(train);
        deliveryList.add(air);
    }
}
