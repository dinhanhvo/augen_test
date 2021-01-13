package com.augen.util;

import java.util.ArrayList;
import java.util.List;

import com.augen.model.TimeFactor;

public class TimeFactorGenerator {

	private static List<TimeFactor> timeDeliveryFactors = new ArrayList<>();
	public static void  createTimeFactorData() {
		TimeFactor tdf1 = new TimeFactor(1, "June to Aug");
		TimeFactor tdf2 = new TimeFactor(2, "Sep");
		TimeFactor tdf3 = new TimeFactor(3, "Other months");
		timeDeliveryFactors.add(tdf1);
		timeDeliveryFactors.add(tdf2);
		timeDeliveryFactors.add(tdf3);
    };
    
    public static List<TimeFactor> getTimeFactorData() {
    	return TimeFactorGenerator.timeDeliveryFactors;
    }
}
