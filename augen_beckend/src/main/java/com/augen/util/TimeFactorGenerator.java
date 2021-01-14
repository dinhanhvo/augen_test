package com.augen.util;

import java.util.List;

import com.augen.model.TimeFactor;

public class TimeFactorGenerator {

	/*
	 * Fake data
	 */
	public static void  getTimeFactorData(List<TimeFactor> timeDeliveryFactors) {
		TimeFactor tdf1 = new TimeFactor("June to Aug", 1);
		TimeFactor tdf2 = new TimeFactor("Sep", 2);
		TimeFactor tdf3 = new TimeFactor("Other months", 3);
		timeDeliveryFactors.add(tdf1);
		timeDeliveryFactors.add(tdf2);
		timeDeliveryFactors.add(tdf3);
    };
    
}
