package com.wb.tdp.ms.common.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wb.tdp.ms.common.dto.RequestDto;

import lombok.Getter;
import lombok.Setter;

/**
 * email details
 * 
 * @author anangupt
 *
 */
@Getter
@Setter
public class WBMail extends RequestDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2184398815919576013L;
	private String sender;
	private List<String> toMails;
	private List<String> ccMails;
	private List<String> bccMails;
	private String subject;
	private String contentType;
	private String contentValue;
	private String eventType;
	private String priority;
	private String sendAt;
	private String languageCode;
	private Map<String,String> dynamicData;
	
	public void setToMail(String toMail) {
		if(toMails==null) {
			toMails = new ArrayList<String>();
		}
		toMails.add(toMail);
	}
	
	public void setCcMail(String ccMail) {
		if(ccMails==null) {
			ccMails = new ArrayList<String>();
		}
		ccMails.add(ccMail);
	}
	
	public void setBccMail(String bccMail) {
		if(bccMails==null) {
			bccMails = new ArrayList<String>();
		}
		bccMails.add(bccMail);
	}
}
