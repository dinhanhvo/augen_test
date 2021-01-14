package com.augen.augen.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.augen.augen.response.ApiResp;
import com.augen.augenservicesImpl.DeliveryService;
import com.augen.dto.DeliveryServiceOptionModel;
import com.augen.model.TimeFactor;
import com.augen.util.CostGenerator;
import com.augen.util.CostKey;
import com.augen.util.DeliveryGenerator;
import com.augen.util.DeliveryInfoGenerator;
import com.augen.util.TimeFactorGenerator;

@RestController
@CrossOrigin(origins = "http://localhost:4300")
public class BuyController {

	@GetMapping("/deliveryinfo")
    public ResponseEntity<ApiResp> getDeliveryInfo(@RequestParam String id) {
        ApiResp apiResp = new ApiResp();
        
        Long idInfo = new Long(id);
        
        String info = DeliveryInfoGenerator.getDeliveryInfoStringById(idInfo);
		apiResp.setData(info);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
	
    @GetMapping("/timefactors")
    public ResponseEntity<ApiResp> getTimeFactors() {
        ApiResp apiResp = new ApiResp();
        
        // get Delivery Service data
        List<TimeFactor> listTimeFactor = TimeFactorGenerator.getTimeFactorData();
		
		apiResp.setData(listTimeFactor);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @GetMapping("/deliveryservices")
    public ResponseEntity<ApiResp> getDeliveryServices() {
        ApiResp apiResp = new ApiResp();

        // get Delivery Service data
        List<DeliveryService> listDelivery = new ArrayList<DeliveryService>();
        DeliveryGenerator.getDeliveryServiceData(listDelivery);
        
        // convert BE delivery service model to FE delivery service model
        List<DeliveryServiceOptionModel> listDSOM = listDelivery.stream().map(item -> {
        	DeliveryServiceOptionModel md = new DeliveryServiceOptionModel( 
        			item.getDeliveryName() + " | $" + item.getBaseCost(), 
        			item.getBaseCost(),
        			item.getDeliveryType()
			); 
        	return md;
        }).collect(Collectors.toList());
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
				context.setCost(cost * context.getCost());
				break;
			}
		}
         
        System.out.println("BuyController.getAdjustCost()=======ratio =" + cost);
		apiResp.setData(context);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PostMapping("/confirm")
    public ResponseEntity<ApiResp> confirmBuying(@RequestBody CostKey confirmKeysCost) {
        ApiResp apiResp = new ApiResp();
        // use this section code if need more detail context
//        DeliveryServiceImpl deliveryService = DeliveryInfoGenerator.getDeliveryInfo(confirmKeysCost.getDeliveryServiceType());
        TimeFactor timeFactor = TimeFactorGenerator.getTimeFactor(confirmKeysCost.getTimeFactorType());
//        // create buying confirmation
//        BuyingConfirmContext buyingConfirmContext = new BuyingConfirmContext(deliveryService, timeFactor, confirmKeysCost.getCost());
//        apiResp.setData(buyingConfirmContext);
        
        // just generate String info
        String deliInfo = DeliveryInfoGenerator.getDeliveryInfoString(confirmKeysCost.getDeliveryServiceType(), 
				timeFactor.getLabel(),
				confirmKeysCost.getCost()
			);
        // fake save to database
        long id = DeliveryInfoGenerator.saveDeliveryConfirmedInfo(deliInfo);
        // just return id of save delivery info
        apiResp.setData(id);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
}
