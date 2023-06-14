package com.wb.tdp.ms.common.constants;

/**
 * Expected ChannelType for consumerApps. 
 * Initial identified enum list which can be updated or added going ahead as per Use-Case. 
 * @author anangupt
 *
 */
public enum ChannelType {

	WEB("WEB"),
	MOBILE("MOBILE");
	
		
	/**
	 * Hold the constant property.
	 */
	private String val;

	ChannelType(String val){
		this.val = val;
	}
	
	public String getVal() {
		return this.val;
	}	

}
