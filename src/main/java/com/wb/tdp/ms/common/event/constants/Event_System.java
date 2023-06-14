package com.wb.tdp.ms.common.event.constants;

public enum Event_System {
	
	CONSUMERPROF("CONSUMERPROF"),
	AUTHSERVER("AUTHSERVER"),
	CONSUMERPREF("CONSUMERPREF"),
	CONSUMERLOYALTY("CONSUMERLOYALTY");
	
	private final String type;

	Event_System(String type) {
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
