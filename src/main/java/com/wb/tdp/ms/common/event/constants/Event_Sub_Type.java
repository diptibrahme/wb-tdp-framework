package com.wb.tdp.ms.common.event.constants;

import java.util.ArrayList;
import java.util.List;

public enum Event_Sub_Type {

	CONSUMER_REGISTERED_EVENT(Event_Type.CONSUMERPROFILE_EVENT, "CONSUMER_REGISTERED_EVENT"),	
    CONSUMER_EMAIL_REGISTERED_EVENT(Event_Type.CONSUMERPROFILE_EVENT, "CONSUMER_EMAIL_REGISTERED_EVENT"), 
	CONSUMER_EMAIL_UPDATED_EVENT(Event_Type.CONSUMERPROFILE_EVENT, "CONSUMER_EMAIL_UPDATED_EVENT"),
	CONSUMER_LOYALTY_SIGN_UP_EVENT(Event_Type.CONSUMERLOYALTY_EVENT, "CONSUMER_LOYALTY_SIGN_UP_EVENT"),
	UPDATE_KAFKA_EVENT(Event_Type.KAFKA_EVENT, "UPDATE_KAFKA_EVENT"),
	UPDATE_PAYTRONIX_EVENT(Event_Type.PAYTRONIX_EVENT, "UPDATE_PAYTRONIX_EVENT"),
	INHOUSEPERSON_CREATE_EVENT(Event_Type.KAFKA_EVENT, "INHOUSEPERSON_CREATE_EVENT"),
	INHOUSEPERSON_UPDATE_EVENT(Event_Type.KAFKA_EVENT, "INHOUSEPERSON_UPDATE_EVENT"),
	INHOUSEPERSON_SECONDARY_EVENT(Event_Type.KAFKA_EVENT, "INHOUSEPERSON_SECONDARY_EVENT"),
	KAFKA_UPDATE_OPT(Event_Type.KAFKA_EVENT, "KAFKA_UPDATE_OPT"),
	CONSUMER_LOYALTY_EMAIL_VERIFIED_EVENT(Event_Type.CONSUMERLOYALTY_EVENT,"CONSUMER_LOYALTY_EMAIL_VERIFIED_EVENT"),
	CONSUMERPREFERENCE_UPDATE_OPT(Event_Type.CONSUMERPREFERENCE_EVENT, "CONSUMERPREFERENCE_UPDATE_OPT");
	
    private final Event_Type type;

    private final String subtype;
    
    Event_Sub_Type(Event_Type type, String subtype) {
        this.type = type;
        this.subtype = subtype;
    }
    
	
    public static List<Event_Sub_Type> getByType(Event_Type type) {
        List<Event_Sub_Type> subtypes = new ArrayList<>();
        for (Event_Sub_Type subtype : values()) {
            if (subtype.type == type) {
            	subtypes.add(subtype);
            }
        }
        return subtypes;
    }

    public String getSubType() {
        return subtype;
    }
    
    
    @Override
    public String toString() {
        return this.type.toString() + ":" +  this.subtype;
    }
    
}
