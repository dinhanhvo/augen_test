package com.augen.augen.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.augen.augen.response.ApiResp;
import com.augen.augenservices.IDeliveryService;
import com.augen.augenservicesImpl.DeliveryServiceImpl;
import com.augen.dto.DeliveryServiceOptionModel;
import com.augen.dto.SelectItemModel;
import com.augen.model.AdjustCostContext;
import com.augen.model.BuyingConfirmContext;
import com.augen.model.TimeFactor;
import com.augen.util.CostGenerator;
import com.augen.util.CostKey;
import com.augen.util.DeliveryGenerator;
import com.augen.util.DeliveryInfoGenerator;
import com.augen.util.TimeFactorGenerator;

@RestController
@CrossOrigin(origins = "http://localhost:4300")
public class BuyController {

    @GetMapping("/timefactors")
    public ResponseEntity<ApiResp> getTimeFactors() {
        ApiResp apiResp = new ApiResp();
        
        // get Delivery Service data
        List<TimeFactor> listTimeFactor = new ArrayList<TimeFactor>();
		TimeFactorGenerator.getTimeFactorData(listTimeFactor);
		
		// convert list factor to time delivery option
//		List<SelectItemModel> sms = listDelivery.stream().map(factor -> {
//			SelectItemModel sm = new SelectItemModel(factor.getLabel());
//			return sm;
//		}).collect(Collectors.toList());
		
		apiResp.setData(listTimeFactor);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @GetMapping("/deliveryservices")
    public ResponseEntity<ApiResp> getDeliveryServices() {
        ApiResp apiResp = new ApiResp();

        // get Delivery Service data
        List<DeliveryServiceImpl> listDelivery = new ArrayList<DeliveryServiceImpl>();
        DeliveryGenerator.getDeliveryServiceData(listDelivery);
        
        // convert BE delivery service model to FE delivery service model
        List<DeliveryServiceOptionModel> listDSOM = listDelivery.stream().map(item -> {
        	DeliveryServiceOptionModel md = new DeliveryServiceOptionModel( 
        			item.getDeliveryName() + "| $" + item.getBaseCost(), 
        			item.getBaseCost(),
        			item.getDeliveryType()
			); 
        	return md;
        }).collect(Collectors.toList());;
        apiResp.setData(listDSOM);
        
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PostMapping("/adjustcost")
    public ResponseEntity<ApiResp> getAdjustCost(@RequestBody CostKey context) {
        ApiResp apiResp = new ApiResp();
        
		Map<CostKey, Double> costmap = new HashMap<CostKey, Double>();
		CostGenerator.getCostData(costmap);
		
		double cost = -1;
		for(CostKey ck:costmap.keySet()) {
			if(ck.getDeliveryServiceType() == context.getDeliveryServiceType() &&
					ck.getTimeFactorType() == context.getTimeFactorType()) {
				cost = costmap.get(ck).doubleValue();
				break;
			}
		}
         
        System.out.println("BuyController.getAdjustCost()=======ratio =" + cost);
		apiResp.setData(cost * context.getCost());
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PostMapping("/confirm")
    public ResponseEntity<ApiResp> confirmBuying(@RequestBody BuyingConfirmContext buyingConfirmContext) {
        ApiResp apiResp = new ApiResp();
        DeliveryServiceImpl deliveryServiceImpl = buyingConfirmContext.getDelyDeliveryService();
        DeliveryInfoGenerator.generateInfo(deliveryServiceImpl);
        
        if (apiResp.getErrors() != null) {
            return new ResponseEntity<ApiResp>(apiResp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
}
