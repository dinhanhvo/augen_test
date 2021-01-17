package com.augen.model.fontend;

public class DeliveryFactor {
    private int type;
    private double ratio;
    private String desciption;
    
    public DeliveryFactor(int type, double ratio, String desString) {
        super();
        this.type = type;
        this.ratio = ratio;
        this.desciption = desString;
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

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
    
}
