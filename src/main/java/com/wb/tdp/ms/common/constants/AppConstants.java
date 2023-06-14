package com.wb.tdp.ms.common.constants;

/**
 * Common Constants used by microservices
 * 
 * @author anangupt
 *
 */
public class AppConstants {

	// Header Param to group request/event log based on correlationId
	public static final String HEADER_KEY_CORRELATION = "X-Correlation-Id";

	// Header Param to get Channel Type ... Expected value to be enum of type
	// ChannelType
	public static final String HEADER_KEY_CLIENT_ROLES = "X-Client-Roles";

	// Header Param to get the request locale
	public static final String HEADER_KEY_LOCALE = "Locale";

	public static final String SUCCESS_MSG = "SUCCESS";
	public static final String REGISTERED = "Registered";
	public static final String ASSOCIATED = "Associated";

	public static final String SYSTEM_ACCOUNT = "system";
	public static final String ANONYMOUS_USER = "anonymoususer";
	public static final String ALL_CHANNEL = "ALL";
	// Header constant for origin source.
	public static final String HEADER_KEY_ORIGIN_SOURCE = "X-Origin-Source";
	// Header constant for Origin IP address.
	public static final String HEADER_KEY_ORIGIN_IP = "X-Forwarded-For";
	// Header constant for proxy user.
	public static final String HEADER_KEY_PROXY_USER = "proxyUser";
	// Header constant for principal.
	public static final String HEADER_KEY_PRINCIPAL_NAME = "X-Principal";
	
	public static final String JMSX_GROUP_ID = "JMSXGroupID";
	public static final String WILD_CARD = "*";
	public static final String HEADER_KEY_CONTENT_TYPE = "Content-Type";
	
	public static final String ROLE_SUPER_USER = "ROLE_SUPER_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

}
