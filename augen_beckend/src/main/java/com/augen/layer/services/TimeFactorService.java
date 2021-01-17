package com.augen.layer.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.augen.layer.database.fake.TimeFactorGenerator;
import com.augen.model.fontend.TimeFactor;

//@Service
public class TimeFactorService {

    /*
     * Fake get all time factor data
     */
    public static List<TimeFactor>  getTimeFactorData() {
    	if (TimeFactorGenerator.timeDeliveryFactors.size() == 0) {
    		TimeFactorGenerator.createTimeFactorData();
    	}
    	return TimeFactorGenerator.timeDeliveryFactors;
    }
    
    /*
     * Fake get factor by type: 1. Jun-Aug, 2. Sep, 3. Other
     */
    public static TimeFactor getTimeFactor(int factorType) {
    	return TimeFactorGenerator.timeDeliveryFactors.stream()
    		.filter(factor -> factor.getType() == factorType)
    		.collect(Collectors.toList()).get(0);
    }
}
