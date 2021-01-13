package com.augen.augen.controller;

import java.util.List;

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
import com.augen.model.BuyingConfirmContext;
import com.augen.util.DeliveryFactory;
import com.augen.util.DeliveryInfoGenerator;

@RestController
@CrossOrigin(origins = "http://localhost:4300")
public class DeliveryController {

    @GetMapping("/getDeliveryServices")
    public ResponseEntity<ApiResp> getDeliveryServices() {
        ApiResp apiResp = new ApiResp();
        List<IDeliveryService> listDelivery = DeliveryFactory.generateDeliveryList();
        apiResp.setData(listDelivery);
        
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
