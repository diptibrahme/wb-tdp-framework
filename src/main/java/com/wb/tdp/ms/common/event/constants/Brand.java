package com.wb.tdp.ms.common.event.constants;

public enum Brand {
	PANERA("WB");

	private final String type;

	Brand(String type) {
        this.type = type;
    }

    String getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return type;
    }

}
