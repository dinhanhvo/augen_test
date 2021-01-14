package com.augen.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.augen.augenservicesImpl.DeliveryServiceImpl;
import com.augen.model.TimeFactor;

public class CostGenerator {

	private static final double[][] ratios = {{0.5, 1.5, 1}, {0.8, 1.8, 1}, {0.8, 2, 1}}; 
	
	public static void getCostData(Map<CostKey, Double> costMap) {
		List<DeliveryServiceImpl> listDelivery = new ArrayList<DeliveryServiceImpl>();
		DeliveryGenerator.getDeliveryServiceData(listDelivery);
		
		List<TimeFactor> listTimeFactor = TimeFactorGenerator.getTimeFactorData();
		
		for(int i = 0; i < 3; i++) {
			int dtype = listDelivery.get(i).getDeliveryType();
			for(int j = 0; j< 3; j++) {
				int ttype = listTimeFactor.get(j).getType();
				CostKey ck = new CostKey(dtype, ttype, listDelivery.get(i).getBaseCost());
				costMap.put(ck, ratios[i][j]);
			}
		}
	}
}
