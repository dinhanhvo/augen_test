package com.augen.model;

public class DeliveryFactor {
    private int type;
    private double ratio;
    
    public DeliveryFactor(int type, double ratio) {
        super();
        this.type = type;
        this.ratio = ratio;
    }
    
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public double getRatio() {
        return ratio;
    }
    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
    
}
