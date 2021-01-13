package com.augen.augen.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.augen.model.BuyingConfirmContext;
import com.augen.model.TimeFactor;
import com.augen.util.DeliveryFactory;
import com.augen.util.DeliveryInfoGenerator;
import com.augen.util.TimeFactorGenerator;

@RestController
@CrossOrigin(origins = "http://localhost:4300")
public class BuyController {

    @GetMapping("/timefactors")
    public ResponseEntity<ApiResp> getTimeFactors() {
        ApiResp apiResp = new ApiResp();
        List<TimeFactor> listDelivery = new ArrayList<TimeFactor>();
		TimeFactorGenerator.createTimeFactorData(listDelivery);;
		apiResp.setData(listDelivery);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @GetMapping("/deliveryservices")
    public ResponseEntity<ApiResp> getDeliveryServices() {
        ApiResp apiResp = new ApiResp();
        List<DeliveryServiceImpl> listDelivery = DeliveryFactory.generateDeliveryList();
        // convert BE delivery service model to FE delivery service model
        List<DeliveryServiceOptionModel> listDSOM = listDelivery.stream().map(item -> {
        	DeliveryServiceOptionModel md = new DeliveryServiceOptionModel(item.getDeliveryType(), 
        			item.getDeliveryName() + "| $" + item.getBaseCost(), 
        			item.getBaseCost()); 
        	return md;
        }).collect(Collectors.toList());;
        apiResp.setData(listDSOM);
        
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
//    @PostMapping("/adjustcost")
//    public ResponseEntity<ApiResp> getAdjustCost(@RequestBody ) {
//        ApiResp apiResp = new ApiResp();
//        List<TimeFactor> listDelivery = new ArrayList<TimeFactor>();
//		TimeFactorGenerator.createTimeFactorData(listDelivery);;
//		apiResp.setData(listDelivery);
//        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
//    }
    
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
