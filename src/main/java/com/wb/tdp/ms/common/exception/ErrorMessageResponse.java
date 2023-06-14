package com.wb.tdp.ms.common.exception;

import java.io.Serializable;
import java.util.List;

import com.wb.tdp.ms.common.validation.ErrorMessage;

/**
 * Class used to encapsulate the Action error message. which hold the list of error messages after the input validation.
 *
 * @author anangupt
 */
public class ErrorMessageResponse implements Serializable {
	
	private static final long serialVersionUID = -6328631191443209751L;

	/**
	 * The List of error message after the validation.
	 */
	private List<ErrorMessage> errorMessage;
	
	public List<ErrorMessage> getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(List<ErrorMessage> errorMessage) {
		this.errorMessage = errorMessage;
	}
}
