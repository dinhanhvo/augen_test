package com.augen.model.fontend;

/**
 * map to TimeFactor option at client side
 *
 */
public class TimeFactor {
	String label;
	int type;
	
    public TimeFactor(String label, int type) {
		super();
		this.label = label;
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
