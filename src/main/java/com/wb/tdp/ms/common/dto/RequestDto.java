package com.wb.tdp.ms.common.dto;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wb.tdp.ms.common.constants.ChannelType;
import com.wb.tdp.ms.common.constants.OriginSource;

import lombok.Data;

/**
 * Base RequestDTO with default expected headers or common attributes expected to come in each Request.
 * 
 * @author anangupt
 *
 */
@Data
public class RequestDto implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3994955324765679874L;
	
	// To hold channelID for business logic processing - it can be: web, pos, ios, android, kiosk
	@JsonIgnore
	protected String channelName; 
	
	// To hold correlationId if coming from Gateway
	@JsonIgnore
	protected String correlationId; 
	
	// To hold the request locale. 
	@JsonIgnore
	protected String locale; 
	
	@JsonIgnore
	protected OriginSource originSource;
	
	@JsonIgnore
	protected String originIP;
	
	@JsonIgnore
	protected ChannelType channelType;
	
	@JsonIgnore
	protected String proxyUser;
	
	@JsonIgnore
	protected String[] clientRoles;

	@JsonIgnore
	protected String principal;
}
