package com.wb.tdp.ms.common.constants;

/**
 * Expected Origin Source for consumerApps. 
 * Initial identified enum list which can be updated or added going ahead as per Use-Case. 
 * @author anangupt
 *
 */
public enum OriginSource {
	WWW("WWW"),
    CATERING2("Catering 2"),
    CATERING3("Catering 3"),
    MOBILE_IOS("Mobile iOS"),
    MOBILE_ANDROID("Mobile Android"),
    MOBILE_WEB("Mobile Web"),
    RETAIL_WEB("Retail Web"),
    IPOS("iPOS"),
    CPG("CPG"),
    PAW("PAW"),
    KIOSK("KIOSK"),
    GOOGLE_VOICE("Google Voice"),
    CATERING3_SPOOF("Catering3 Spoof"),
    RETAIL_SPOOF("Retail Spoof"),
    SALESFORCE("SalesForce"),
    UNK("Unknown"),
    CATERING_WEB("Catering Web"),
    CATERING_CCD("Catering In-house"),
    CATERING_ONOSYS("Catering Onosys"),
    CMT("CMT"),
    I_WEB("iWeb");

	/**
	 * Hold the constant property.
	 */
	private String val;

	OriginSource(String val){
		this.val = val;
	}
	
	public String getVal() {
		return this.val;
	}
	
	public static OriginSource getByDisplayName(String displayName){
        for(OriginSource value : values()) {
            if(value.val.equalsIgnoreCase(displayName)) {
                return value;
            }
        }
        return UNK;
    }

    public static ChannelType getChannelType(OriginSource sourceType) {
        if(sourceType != null) {
            switch (sourceType) {
                case WWW: return ChannelType.WEB;
                case MOBILE_IOS: return ChannelType.MOBILE;
                case MOBILE_ANDROID: return ChannelType.MOBILE;
                case MOBILE_WEB: return ChannelType.WEB;
                case RETAIL_WEB: return ChannelType.WEB;
                case I_WEB: return ChannelType.WEB;

                default: return ChannelType.WEB;
            }
        } else {
            return ChannelType.WEB;
        }
    }
    
    public static boolean isValid(String originSource) {
    	try {
    		OriginSource.valueOf(originSource);
    	} catch (Exception exception) {
    		return false;
    	}
    	return true;
    }
}
