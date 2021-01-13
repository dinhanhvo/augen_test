package com.augen.model;

public class TimeFactor {
    private int value;
    private String label;
    
    public TimeFactor(int type, String desString) {
        super();
        this.value = type;
        this.label = desString;
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
    
}
