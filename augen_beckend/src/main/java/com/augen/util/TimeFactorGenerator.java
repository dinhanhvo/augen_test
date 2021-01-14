package com.augen.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.augen.model.TimeFactor;

public class TimeFactorGenerator {

	private static List<TimeFactor> timeDeliveryFactors = new ArrayList<TimeFactor>();
	/*
	 * Fake data
	 */
	public static void  createTimeFactorData() {
		TimeFactor tdf1 = new TimeFactor("June to Aug", 1);
		TimeFactor tdf2 = new TimeFactor("Sep", 2);
		TimeFactor tdf3 = new TimeFactor("Other months", 3);
		TimeFactorGenerator.timeDeliveryFactors.add(tdf1);
		TimeFactorGenerator.timeDeliveryFactors.add(tdf2);
		TimeFactorGenerator.timeDeliveryFactors.add(tdf3);
    };
    
    public static List<TimeFactor>  getTimeFactorData() {
    	if (TimeFactorGenerator.timeDeliveryFactors.size() == 0) {
    		TimeFactorGenerator.createTimeFactorData();
    	}
    	return TimeFactorGenerator.timeDeliveryFactors;
    }
    
    public static TimeFactor getTimeFactor(int factorType) {
    	return TimeFactorGenerator.timeDeliveryFactors.stream()
    		.filter(factor -> factor.getType() == factorType)
    		.collect(Collectors.toList()).get(0);
    }
}
