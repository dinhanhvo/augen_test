package com.augen.layer.database.fake;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.augen.layer.services.TimeFactorService;
import com.augen.model.entity.DeliveryServiceEntity;
import com.augen.model.fontend.BuyingConfirmKeys;
import com.augen.model.fontend.TimeFactor;

public class CostGenerator {

	private static final double[][] ratios = {{0.5, 1.5, 1}, {0.8, 1.8, 1}, {0.8, 2, 1}}; 
	private static Map<BuyingConfirmKeys, Double> costMap;
	
	/*
	 * create a map with key is <DeliveryService, TimeFactor> and value is ratio
	 * Ex: <['Motorbike', 'June to Aug'], 05> ==> ratio = 0.5
	 * 	   <['Train', 'Sep'], 1.8> ==> ratio = 1.8 	
	 */
	public static void createCostData() {
		costMap = new HashMap<BuyingConfirmKeys, Double>();
		List<DeliveryServiceEntity> listDelivery = DeliveryGenerator.getDeliveryServiceData();
		
		List<TimeFactor> listTimeFactor = TimeFactorService.getTimeFactorData();
		
		int size = ratios.length;
		for(int i = 0; i < size; i++) {
			int dtype = listDelivery.get(i).getDeliveryType();
			for(int j = 0; j< size; j++) {
				int ttype = listTimeFactor.get(j).getType();
				BuyingConfirmKeys ck = new BuyingConfirmKeys(dtype, ttype, listDelivery.get(i).getBaseCost(), "");
				costMap.put(ck, ratios[i][j]);
			}
		}
	}
	
	public static Map<BuyingConfirmKeys, Double> getCostData() {
		if (costMap == null || costMap.size() == 0) {
			createCostData();
		}
		
		return costMap;
	}
	
	public static double getRatioByFactors(BuyingConfirmKeys context) {
		if (costMap == null || costMap.size() == 0) {
			createCostData();
		}
		double ratio = -1;
		for(BuyingConfirmKeys ck:costMap.keySet()) {
			if(ck.getDeliveryServiceType() == context.getDeliveryServiceType() &&
					ck.getTimeFactorType() == context.getTimeFactorType()) {
				ratio = costMap.get(ck).doubleValue();
				break;
			}
		}
		return ratio;
	}
}
