package com.augen.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.augen.model.TimeFactor;

public class TimeFactorGenerator {

	
	/*
	 * Fake data is storing in database
	 */
	private static List<TimeFactor> timeDeliveryFactors = new ArrayList<TimeFactor>();
	public static void  createTimeFactorData() {
		TimeFactor tdf1 = new TimeFactor("June to Aug", 1);
		TimeFactor tdf2 = new TimeFactor("Sep", 2);
		TimeFactor tdf3 = new TimeFactor("Other months", 3);
		TimeFactorGenerator.timeDeliveryFactors.add(tdf1);
		TimeFactorGenerator.timeDeliveryFactors.add(tdf2);
		TimeFactorGenerator.timeDeliveryFactors.add(tdf3);
    };
    
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
