package com.augen.augen.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.augen.augen.response.ApiResp;
import com.augen.constant.CommonConstant;
import com.augen.layer.services.DeliveryServiceService;
import com.augen.layer.services.TimeFactorService;
import com.augen.model.fontend.BuyBookModel;
import com.augen.model.fontend.BuyingConfirmKeys;
import com.augen.model.fontend.DeliveryServiceOptionModel;
import com.augen.model.fontend.TimeFactor;

//@CrossOrigin(origins = CommonConstant.ORIGIN)
@RestController
public class BuyController {

//	@Autowired
//	private TimeFactorService  timeFactorService;
	
	@GetMapping("/deliveryinfo")
    public ResponseEntity<ApiResp> getDeliveryInfo(@RequestParam String id) {
        ApiResp apiResp = new ApiResp();
        
        Long idInfo = Long.valueOf(id);
        
        BuyBookModel confirmedInfo = DeliveryServiceService.getDeliveryInfoStringById(idInfo);
		apiResp.setData(confirmedInfo);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
	
	/*
	 * response delivery info
	 * Ex: 'Train no: traiNo6 | Station of arrival: Train | Date of arrival: Sep | Cost: $18.0'
	 * 
	 */
    @PostMapping("/confirm")
    public ResponseEntity<ApiResp> confirmBuying(@RequestBody BuyingConfirmKeys confirmKeysCost) {
        ApiResp apiResp = new ApiResp();
        
        // fake save to database
        long id = DeliveryServiceService.saveConfirmBuying(confirmKeysCost);
        
        // response id of saved delivery info
        apiResp.setData(id);
        
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
	
    @GetMapping("/timefactors")
    public ResponseEntity<ApiResp> getTimeFactors() {
        ApiResp apiResp = new ApiResp();
        
        // get TimeFactor data
        List<TimeFactor> listTimeFactor = TimeFactorService.getTimeFactorData();
		
		apiResp.setData(listTimeFactor);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @GetMapping("/deliveryservices")
    public ResponseEntity<ApiResp> getDeliveryServices() {
        ApiResp apiResp = new ApiResp();

        // get delivery service data
        List<DeliveryServiceOptionModel> listDSOM = DeliveryServiceService.getDeliveryServices();
        
        apiResp.setData(listDSOM);
        
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PostMapping("/adjustcost")
    public ResponseEntity<ApiResp> getAdjustCost(@RequestBody BuyingConfirmKeys context) {
        ApiResp apiResp = new ApiResp();
        
		double ratio = DeliveryServiceService.getRatio(context);
		System.out.println("BuyController.getAdjustCost()=======ratio =" + ratio);
		
		context.setCost(context.getCost() * ratio);
        
		apiResp.setData(context);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    /*
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
    */
    
    @GetMapping("/initUT")
    public String testUT2() {
    	ApiResp apiResp = new ApiResp();
    	System.out.println("BuyController.testUT()==================");
    	apiResp.setData(CommonConstant.SPLIT);
    	return CommonConstant.SPLIT;
    }
}
