package com.wb.tdp.ms.common.exception;


/**
 * Spring constant is used to declare all the constant which are used for Spring related configuration parameters.
 * 
 * @author anangupt
 *
 */
public enum ExceptionConstant {

	REST_CLIENT_CONNECTION_CODE("RC0001"),
	REST_CLIENT_CONNECTION_SUMMARY("Host System is Down. Please Contact Your Administrator"),
	GENERAL_EXCEPTION_CODE("GE0001"),
	GENERAL_EXCEPTION_CODE_SUMMARY("System is Down. Please Contact Your Administrator"),
	TECHNICAL_EXCEPTION_CODE("GE0002"),
	TECHNICAL_CODE_SUMMARY("Unable to process the request. Please Contact Your Administrator"),
	INSUFFICIENT_PERMSSION("FW0003"),
	JSON_PARSING_ERROR_CODE("JSON-PARSING-ERROR"),
	QUERY_PARAM_MISSING_ERROR_CODE("QUERY-PARAM-MISSING"),
	REST_METHOD_NOT_SUPPORTED_CODE("RC0002"),
	REST_METHOD_NOT_SUPPORTED_SUMMARY("REST method is not supported for this request."),
	JSON_PARSING_ERROR_MESSAGE("Invalid JSON passed. Please try again with correct JSON"),
	QUERY_PARAM_MISSING_ERROR_CODE_SUMMERY("One or more required query parameters are missing.");


		
	/**Hold the constant property.
	 * 
	 */
	private String val;

	ExceptionConstant(String val){
		this.val = val;
	}
	
	public String getVal() {
		return this.val;
	}
	
}
