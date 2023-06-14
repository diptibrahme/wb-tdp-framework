package com.wb.tdp.ms.common.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *   This class contains the ResponseDto properties
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto implements Serializable  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -552659829947691465L;
	/**
	 * This field is to hold the status
	 */
     private boolean success;
     /**
 	 * This field is to hold the message success or failure.
 	 */
	private String message;
	private List<ErrorMessage> errorMessages;
	
    public ResponseDto(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    
}
