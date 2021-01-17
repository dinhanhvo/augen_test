package com.augen.model.fontend;

import com.augen.json.objects.BaseObject;

public class BuyBookModel extends BaseObject {

    private String deliveryString;
    private double deliveryCost;
    private String bookId;
    
    public BuyBookModel(String deliveryString, double deliveryCost, String bookId) {
		super();
		this.deliveryString = deliveryString;
		this.deliveryCost = deliveryCost;
		this.bookId = bookId;
	}
    
	public String getDeliveryString() {
        return deliveryString;
    }
    public void setDeliveryString(String deliveryString) {
        this.deliveryString = deliveryString;
    }
    public double getDeliveryCost() {
        return deliveryCost;
    }
    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
    
}
