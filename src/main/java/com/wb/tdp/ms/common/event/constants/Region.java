package com.wb.tdp.ms.common.event.constants;

public enum Region {

	US("US"), CA("CA");

	private final String type;

	Region(String type) {
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
