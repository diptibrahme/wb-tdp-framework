package com.wb.tdp.ms.common.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.LocaleUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wb.tdp.ms.common.constants.AppConstants;
import com.wb.tdp.ms.common.dto.ErrorMessage;
import com.wb.tdp.ms.common.dto.ResponseDto;
import com.wb.tdp.ms.common.utils.CurrentCorrelationId;
import com.wb.tdp.ms.common.validation.Message;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is used to handle all the exception which are thrown to
 * application layers.
 * 
 * @author anangupt
 *
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	BusinessMessageHelper businessMessageHelper;

	/**
	 * This method returns the response when there is ValidationException occurred in any layer.
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseDto handleResourceNotFound(final ValidationException exception,
			final HttpServletRequest request) {
		return new ResponseDto();

	}

	/**
	 * This method returns the response when there is BusinessException occurred in any layer.
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseDto handleResourceNotFound(final BusinessException exception,
			final HttpServletRequest request) {
		ResponseDto exceptionResponse = new ResponseDto();
		List<ErrorMessage> errorMessages = null;
		ErrorMessage errorMessage = null;
		ErrorMessage.Builder error = new ErrorMessage.Builder();
		errorMessages = new ArrayList<>(1);
		errorMessage = error.errorCode(exception.getErrorCode()).errorId(CurrentCorrelationId.get())
				.errorMessage(
						messageSource.getMessage(exception.getMessage(), exception.getArgs(), exception.getMessage(),
								LocaleUtils.toLocale(request.getHeader(AppConstants.HEADER_KEY_LOCALE))))
				.build();
		errorMessages.add(errorMessage);
		exceptionResponse.setErrorMessages(errorMessages);
		log.error("Business Exception raised with code:: " + exception.getErrorCode() + "and Exception Message :"
				+ exception.getMessage());
		return exceptionResponse;
	}

	/**
	 * This method returns the response when ResourceNotFoundException occurred in
	 * any layer.
	 * 
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseDto handleResourceNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {
		ResponseDto exceptionResponse = new ResponseDto();
		List<ErrorMessage> errorMessages = null;
		ErrorMessage errorMessage = null;
		ErrorMessage.Builder error = new ErrorMessage.Builder();
		errorMessages = new ArrayList<>(1);
		errorMessage = error.errorCode(exception.getErrorCode()).errorId(CurrentCorrelationId.get())
				.errorMessage(
						messageSource.getMessage(exception.getMessage(), exception.getArgs(), exception.getMessage(),
								LocaleUtils.toLocale(request.getHeader(AppConstants.HEADER_KEY_LOCALE))))
				.build();
		errorMessages.add(errorMessage);
		exceptionResponse.setErrorMessages(errorMessages);
		log.error("Business Exception raised with code:: " + exception.getErrorCode() + "and Exception Message :"
				+ exception.getMessage());
		return exceptionResponse;
	}

	/**
	 * This method returns the response when there is TypeMismatchException occurred
	 * in the any layer.
	 * 
	 * @param exception - object of TypeMismatchException
	 * @param request   - object of HttpServletRequest
	 * @return ResponseDto - returning the responseDto with errorCode and
	 *         errormessage
	 */
	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseDto handleTypeMismatchException(final TypeMismatchException exception,
			final HttpServletRequest request) {
		ResponseDto exceptionResponse = new ResponseDto();
		List<ErrorMessage> errorMessages = null;
		ErrorMessage errorMessage = null;
		ErrorMessage.Builder error = new ErrorMessage.Builder();
		errorMessages = new ArrayList<>(1);
		errorMessage = error.errorCode(exception.getErrorCode())
				.errorMessage(" Invalid input '" + exception.getValue() + "'. Please pass correct input").build();
		errorMessages.add(errorMessage);

		exceptionResponse.setErrorMessages(errorMessages);
		log.error("System Exception raised with error Message:: " + exception.getMessage() + " :: StackTrace >> "
				+ exception.getStackTrace());
		return exceptionResponse;

	}

	/**
	 * This method returns the response when there is TypeMismatchException occurred
	 * in the any layer.
	 * 
	 * @param exception - object of Exception
	 * @param request   - object of HttpServletRequest
	 * @return exceptionResponse - returning the exceptionResponse with error
	 *         message
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseDto handleHttpMessageNotReadableException(
			final HttpMessageNotReadableException exception, final HttpServletRequest request) {
		ResponseDto exceptionResponse = new ResponseDto();
		List<ErrorMessage> errorMessages = null;
		ErrorMessage errorMessage = null;
		ErrorMessage.Builder error = new ErrorMessage.Builder();
		errorMessages = new ArrayList<>(1);
		errorMessage = error.errorCode(ExceptionConstant.JSON_PARSING_ERROR_CODE.getVal())
				.errorMessage(ExceptionConstant.JSON_PARSING_ERROR_MESSAGE.getVal()).build();
		errorMessages.add(errorMessage);

		exceptionResponse.setErrorMessages(errorMessages);
		log.error("System Exception raised with error Message:: " + exception.getMessage() + " :: StackTrace >> "
				+ exception.getStackTrace());
		return exceptionResponse;

	}

	/**
	 * This method returns the response when mandatory query parameters are not
	 * presented in the Http request.
	 * 
	 * @param exception - object of Exception
	 * @param request   - object of HttpServletRequest
	 * @return exceptionResponse - returning the exceptionResponse with error
	 *         message
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseDto handleMissingParams(final MissingServletRequestParameterException exception,
			final HttpServletRequest request) {

		ResponseDto exceptionResponse = new ResponseDto();
		List<ErrorMessage> errorMessages = null;
		ErrorMessage errorMessage = null;
		ErrorMessage.Builder error = new ErrorMessage.Builder();
		errorMessages = new ArrayList<>(1);
		errorMessage = error.errorCode(ExceptionConstant.QUERY_PARAM_MISSING_ERROR_CODE.getVal())
				.errorMessage(ExceptionConstant.QUERY_PARAM_MISSING_ERROR_CODE_SUMMERY.getVal()).build();
		errorMessages.add(errorMessage);

		exceptionResponse.setErrorMessages(errorMessages);
		log.error("System Exception raised with error Message:: " + exception.getMessage() + " :: StackTrace >> "
				+ exception.getStackTrace());
		return exceptionResponse;
	}

	/**
	 * This method returns the response when there is exception has occurred in the
	 * any layer.
	 * 
	 * @param exception - object of Exception
	 * @param request   - object of HttpServletRequest
	 * @return exceptionResponse - returing the exceptionResponse with error message
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ResponseDto handleException(final Exception exception, final HttpServletRequest request) {
		ResponseDto exceptionResponse = new ResponseDto();
		List<ErrorMessage> errorMessages = null;
		ErrorMessage errorMessage = null;
		ErrorMessage.Builder error = new ErrorMessage.Builder();
		errorMessages = new ArrayList<>(1);
		errorMessage = error.errorCode(ErrorCodeConstant.E00001.val()).errorId(ErrorCodeConstant.E00001.val())
				.errorMessage(ExceptionConstant.GENERAL_EXCEPTION_CODE_SUMMARY.getVal()).build();
		errorMessages.add(errorMessage);

		exceptionResponse.setErrorMessages(errorMessages);
		log.error("System Exception raised with error Message:: " + exception.getMessage() + " :: StackTrace >> "
				+ exception.getStackTrace());
		return exceptionResponse;

	}

	/**
	 * This method returns the response when there is
	 * HttpRequestMethodNotSupportedException occurred
	 * 
	 * @param exception - object of HttpRequestMethodNotSupportedException
	 * @param request   - object of HttpServletRequest
	 * @return exceptionResponse - returning the exceptionResponse with error
	 *         message
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseDto handleHttpMessageNotReadableException(
			final HttpRequestMethodNotSupportedException exception, final HttpServletRequest request) {

		ResponseDto exceptionResponse = new ResponseDto();
		List<ErrorMessage> errorMessages = null;
		ErrorMessage errorMessage = null;
		ErrorMessage.Builder error = new ErrorMessage.Builder();
		errorMessages = new ArrayList<>(1);
		errorMessage = error.errorCode(ExceptionConstant.REST_METHOD_NOT_SUPPORTED_CODE.getVal())
				.errorMessage(ExceptionConstant.REST_METHOD_NOT_SUPPORTED_SUMMARY.getVal()).build();
		errorMessages.add(errorMessage);

		exceptionResponse.setErrorMessages(errorMessages);
		log.error("System Exception raised with error Message:: " + exception.getMessage() + " :: StackTrace >> "
				+ exception.getStackTrace());
		return exceptionResponse;

	}

	/**
	 * This method returns the response when there is BusinessValidationException
	 * has occurred in the any layer.
	 * 
	 * @param exception - object of BusinessValidationException
	 * @param request   - object of HttpServletRequest
	 * @return exceptionResponse - returning the exceptionResponse with error message
	 */
	@ExceptionHandler(BusinessValidationException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	public @ResponseBody ResponseDto handleResourceNotFound(final BusinessValidationException exception,
			final HttpServletRequest request) {
		return processException(exception.getMessages(), exception.getLanguage());

	}
	
	

	/**
	 * This method returns the response when there is RestResourceNotFoundException
	 * has occurred in the any layer.
	 * 
	 * @param exception - object of RestResourceNotFoundException
	 * @param request   - object of HttpServletRequest
	 * @return exceptionResponse - returning the exceptionResponse with error message
	 */
	@ExceptionHandler(RestResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseDto handleResourceNotFound(final RestResourceNotFoundException exception,
			final HttpServletRequest request) {
		return processException(exception.getMessages(), exception.getLanguage());

	}
	

	/**
	 * @param exception - object of BusinessValidationException
	 * @return ResponseDto
	 */
	private ResponseDto processException(Message message, String language) {
		Locale locale = null;
		if (language == null) {
			locale = new Locale("en");
		} else {
			locale = new Locale(language);
		}
		ErrorMessageResponse actionErrorMessage = businessMessageHelper.processMessage(locale, message);
		return convertExceptionFormat(actionErrorMessage);
	}
	
	/**
	 * This method converts the ErrorMessageResponse class format to 
	 * ResponseDto format
	 * @param actionErrorMessage
	 * @return ResponseDto
	 */
	private ResponseDto convertExceptionFormat(ErrorMessageResponse actionErrorMessage) {
		ResponseDto exceptionResponse = new ResponseDto();
		List<ErrorMessage> errorMessages = new ArrayList<>();
		ErrorMessage errorMessage = null;
		for(com.wb.tdp.ms.common.validation.ErrorMessage errMsg: actionErrorMessage.getErrorMessage()) {
			ErrorMessage.Builder error = new ErrorMessage.Builder();
			errorMessage = error.errorCode(errMsg.getErrorCode())
					.errorId(errMsg.getErrorId())
					.errorMessage(errMsg.getSummary())
					.errorType(errMsg.getErrorType())
					.errorLink(errMsg.getErrorLink())
					.build();
			errorMessages.add(errorMessage);
		}
		exceptionResponse.setErrorMessages(errorMessages);
		
		
		return exceptionResponse;
	}

	/**
	 * This method returns the response when there is exception has occurred in the
	 * any layer.
	 * 
	 * @param exception - object of Exception
	 * @param request   - object of HttpServletRequest
	 * @return exceptionResponse - returing the exceptionResponse with error message
	 */
	@ExceptionHandler(SystemException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ResponseDto handleResourceNotFound(final SystemException exception,
			final HttpServletRequest request) {
		ResponseDto exceptionResponse = new ResponseDto();
		List<ErrorMessage> errorMessages = null;
		ErrorMessage errorMessage = null;
		ErrorMessage.Builder error = new ErrorMessage.Builder();
		errorMessages = new ArrayList<>(1);
		errorMessage = error.errorCode(exception.getErrorCode()).errorId(CurrentCorrelationId.get())
				.errorMessage(
						messageSource.getMessage(exception.getMessage(), exception.getArgs(), exception.getMessage(),
								LocaleUtils.toLocale(request.getHeader(AppConstants.HEADER_KEY_LOCALE))))
				.build();
		errorMessages.add(errorMessage);
		exceptionResponse.setErrorMessages(errorMessages);
		log.error("Business Exception raised with code:: " + exception.getErrorCode() + "and Exception Message :"
				+ exception.getMessage());
		return exceptionResponse;
	}
	 
    @ExceptionHandler(PaneraNotAcceptableException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public @ResponseBody ResponseDto handlePaneraNotAcceptableException(final PaneraNotAcceptableException exception,
                 final HttpServletRequest request) {            
          ResponseDto exceptionResponse = new ResponseDto();
          List<ErrorMessage> errorMessages = null;
          ErrorMessage errorMessage = null;
          ErrorMessage.Builder error = new ErrorMessage.Builder();
          errorMessages = new ArrayList<>(1);
          errorMessage = error.errorCode(exception.getMessage())
                        .errorMessage(
                                     messageSource.getMessage(exception.getMessage(), exception.getArgs(), exception.getMessage(),
                                                   LocaleUtils.toLocale(request.getHeader(AppConstants.HEADER_KEY_LOCALE))))
                        .build();
          errorMessages.add(errorMessage);
          exceptionResponse.setErrorMessages(errorMessages);
          log.error("PaneraNotAcceptableException Exception raised with code:: " + exception.getMessage() + "and Exception Message :"
                        + exception.getMessage());
          return exceptionResponse;

    }



}
