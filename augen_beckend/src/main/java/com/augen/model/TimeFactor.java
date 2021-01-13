package com.augen.model;

public class TimeFactor {
    private int type;
    private String desciption;
    
    public TimeFactor(int type, String desString) {
        super();
        this.type = type;
        this.desciption = desString;
    }
    
    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
    
}
