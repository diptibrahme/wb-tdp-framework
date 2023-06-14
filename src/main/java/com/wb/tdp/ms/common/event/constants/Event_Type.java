package com.wb.tdp.ms.common.event.constants;

public enum Event_Type {

	CONSUMERPROFILE_EVENT("CONSUMERPROFILE_EVENT"), 
	CONSUMERPREFERENCE_EVENT("CONSUMERPREFERENCE_EVENT"),
	CONSUMERLOYALTY_EVENT("CONSUMERLOYALTY_EVENT"),
	KAFKA_EVENT("KAFKA_EVENT"),
	PAYTRONIX_EVENT("PAYTRONIX_EVENT");

	private final String type;

	Event_Type(String type) {
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
