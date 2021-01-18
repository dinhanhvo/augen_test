package com.augen.test.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.augen.test.controller.BaseTest;
import com.augen.constant.CommonConstant;
import com.augen.layer.services.DeliveryServiceService;
import com.augen.model.fontend.BuyingConfirmKeys;

public class DeliveryServiceServiceTest extends BaseTest {

	@Test
	public void shouldReturnCorrectRatio() throws Exception {
		final double motoSepRation = 1.5; 
		BuyingConfirmKeys context = new BuyingConfirmKeys(CommonConstant.MOTOBIKE_TYPE, CommonConstant.SEP_FACTOR_TYPE, -1, null);
		double ratio = DeliveryServiceService.getRatio(context);
		System.out.println("DeliveryServiceServiceTest.shouldReturnCorrectRatio()-----ratio---" + ratio);
		Assertions.assertEquals(motoSepRation, ratio);
		
		BuyingConfirmKeys context2 = new BuyingConfirmKeys(CommonConstant.AIRCRAFT_TYPE, CommonConstant.OTHER_TYPE, -1, null);
		ratio = DeliveryServiceService.getRatio(context2);
		System.out.println("DeliveryServiceServiceTest.shouldReturnCorrectRatio()-----ratio---" + ratio);
		Assertions.assertNotEquals(motoSepRation, ratio);
	}
	
	@Test
	public void shouldReturnInCorrectRatio() throws Exception {
		final double motoSepRation = 1.5; 
		
		BuyingConfirmKeys context2 = new BuyingConfirmKeys(CommonConstant.AIRCRAFT_TYPE, CommonConstant.OTHER_TYPE, -1, null);
		double ratio = DeliveryServiceService.getRatio(context2);
		System.out.println("DeliveryServiceServiceTest.shouldReturnInCorrectRatio()-----ratio---" + ratio);
		Assertions.assertNotEquals(motoSepRation, ratio);
	}
}
