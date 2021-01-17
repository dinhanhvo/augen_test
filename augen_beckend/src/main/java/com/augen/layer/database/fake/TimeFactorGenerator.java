package com.augen.layer.database.fake;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.augen.model.TimeFactor;

public class TimeFactorGenerator {

	
	/*
	 * Fake data is storing in database
	 */
	public static List<TimeFactor> timeDeliveryFactors = new ArrayList<TimeFactor>();
	public static void  createTimeFactorData() {
		TimeFactor tdf1 = new TimeFactor("June to Aug", 1);
		TimeFactor tdf2 = new TimeFactor("Sep", 2);
		TimeFactor tdf3 = new TimeFactor("Other months", 3);
		TimeFactorGenerator.timeDeliveryFactors.add(tdf1);
		TimeFactorGenerator.timeDeliveryFactors.add(tdf2);
		TimeFactorGenerator.timeDeliveryFactors.add(tdf3);
    };
    
}
