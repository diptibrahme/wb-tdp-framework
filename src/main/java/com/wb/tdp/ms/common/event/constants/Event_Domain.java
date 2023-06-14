package com.wb.tdp.ms.common.event.constants;

public enum Event_Domain {

	ED_CONHUB("ED_CONHUB");

	private final String type;

	Event_Domain(String type) {
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
