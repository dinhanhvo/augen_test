package com.augen.model;

import com.augen.augenservicesImpl.DeliveryServiceImpl;

public class BuyingConfirmContext {
    DeliveryServiceImpl delyDeliveryService;
    Object book;
    
    public DeliveryServiceImpl getDelyDeliveryService() {
        return delyDeliveryService;
    }
    public void setDelyDeliveryService(DeliveryServiceImpl delyDeliveryService) {
        this.delyDeliveryService = delyDeliveryService;
    }
    public Object getBook() {
        return book;
    }
    public void setBook(Object book) {
        this.book = book;
    }
    
}
