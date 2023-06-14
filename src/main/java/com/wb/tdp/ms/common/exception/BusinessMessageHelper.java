package com.wb.tdp.ms.common.exception;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.wb.tdp.ms.common.validation.ErrorMessage;
import com.wb.tdp.ms.common.validation.Message;
import com.wb.tdp.ms.common.validation.MessageData;
import com.wb.tdp.ms.common.validation.ParamInfo;

/**
 * This class is used to process message object passed as input and provide the
 * description message , type as output encapsulated in ErrorMessage.
 * 
 * @author anangupt
 *
 */

@Component
public class BusinessMessageHelper implements Serializable {
	/**
	 * Logger
	 */
	private static final Logger LOG = LogManager.getLogger(BusinessMessageHelper.class);
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -179659033007927872L;
	/**
	 * Property file name that holds message text for error code
	 */
	private String messageBundleResource = "messageresource.messages";

	/**
	 * This method processes error messages based on locale to provide actual message text for error code
	 * @param locale
	 * @param message
	 * @return ErrorMessageResponse
	 */
	public ErrorMessageResponse processMessage(Locale locale, Message message) {
		ErrorMessageResponse errorMessageResponse = processMessage(locale, message, messageBundleResource);
		return errorMessageResponse;

	}

	/**
	 * This method processes error messages based on locale to provide actual message text for error code
	 * @param messageBundleResource
	 * @param locale
	 * @param message
	 * @return ErrorMessageResponse
	 */
	public ErrorMessageResponse processMessage(String messageBundleResource, Locale locale, Message message) {
		this.messageBundleResource = messageBundleResource;
		return processMessage(locale, message, messageBundleResource);

	}

	/**
	 * This method is used to process message object passed as input and provide the
	 * description message , type as output encapsulated in ErrorMessage.
	 * 
	 * @param territoryLocale
	 * @param message
	 * @param bundleName
	 * @return ErrorMessageResponse
	 */
	public ErrorMessageResponse processMessage(Locale territoryLocale, Message message, String bundleName) {

		ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse();
		List<ErrorMessage> errorMessages = new LinkedList<>();
		if (message != null && message.getMessageDataList() != null && !message.getMessageDataList().isEmpty()) {
			List<ErrorMessage> errors = new ArrayList<>(1);
			ResourceBundle bundle = loadResourceBundle(territoryLocale);
			for (MessageData messageData : message.getMessageDataList()) {
				String strMessage = messageData.getMessageKey();
				try {
					strMessage = bundle.getString(messageData.getMessageKey());
				} catch (Exception e) {
					LOG.error("Error message not defined for code: " + messageData.getMessageKey());
				}
				List<String> newParamList = getMessageParams(territoryLocale, messageData, bundleName);
				if (newParamList != null && !newParamList.isEmpty()) {
					strMessage = MessageFormat.format(strMessage, newParamList.toArray());
				}
				populateMessage(errors, messageData, strMessage);
			}
			errorMessages.addAll(errors);
		}
		if (!errorMessages.isEmpty()) {
			errorMessageResponse.setErrorMessage(errorMessages);
		}
		return errorMessageResponse;
	}

	/**
	 * Populate the error message to their respective error type list.
	 * 
	 * @param errors
	 * @param messageData
	 * @param strMessage
	 */
	private void populateMessage(List<ErrorMessage> errorMessages, MessageData messageData, String strMessage) {

		ErrorMessage.Builder error = new ErrorMessage.Builder();
		ErrorMessage errorMesage = error.errorType(messageData.getMessageType().getVal()).errorMessage(strMessage)
				.errorCode(messageData.getMessageKey()).errorId(messageData.getPropertyName()).build();
		errorMessages.add(errorMesage);
	}

	/**
	 * This method load the resource bundle and return the object for the same.
	 * 
	 * @param territoryLocale
	 * @return ResourceBundle
	 */
	private ResourceBundle loadResourceBundle(Locale territoryLocale) {
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle(messageBundleResource, territoryLocale);
		} catch (Exception e) {
			LOG.error("ERROR IN LOADING ResourceBundle {}", e);
			throw new PropertyFileLoadingException("ERROR IN LOADING ResourceBundle {}", e);
		}
		return bundle;
	}

	/**
	 * Returns the list of message paramaters from resource bundle based on param
	 * keys. Takes care if the parameter value is provided then parameter value is
	 * not retrieved from resource bundle.
	 *
	 * @param msgData    contains the list of param keys
	 * @param bundleName bundle name from which to extract the the value
	 * @return List<String> of message parameters
	 */
	private List<String> getMessageParams(Locale territoryLocale, MessageData msgData, String bundleName) {
		List<String> nwparamList = null;
		if (territoryLocale != null && bundleName != null) {
			ResourceBundle paramBundle = ResourceBundle.getBundle(bundleName, territoryLocale);
			nwparamList = new ArrayList<>(1);
			for (ParamInfo paramInfo : msgData.getParams()) {
				populateMessageParam(nwparamList, paramBundle, paramInfo);
			}
		}

		return nwparamList;
	}

	/**
	 * This method is used to populate the message parameter.
	 * 
	 * @param nwparamList
	 * @param paramBundle
	 * @param paramInfo
	 */
	private void populateMessageParam(List<String> nwparamList, ResourceBundle paramBundle, ParamInfo paramInfo) {

		if (paramInfo.getValues() != null && !paramInfo.getValues().isEmpty()) {
			nwparamList.add(getParamValues(paramInfo.getValues()));
		} else if (paramInfo.getValue() != null) {
			nwparamList.add(paramInfo.getValue());
		} else if (paramInfo.getKey() != null) {
			try {
				if (isStringNotNull(paramInfo.getKey())) {
					nwparamList.add(paramBundle.getString(paramInfo.getKey()));
				}
			} catch (Exception e) {
				nwparamList.add(paramInfo.getKey());
			}
		} else {
			if (paramInfo.getKeys() != null && !paramInfo.getKeys().isEmpty()) {
				nwparamList.add(getValuesForKeys(paramInfo.getKeys(), paramBundle));
			}
		}
	}

	/**
	 * @param List           <String>
	 * @param ResourceBundle
	 * @return String
	 */
	private String getValuesForKeys(final List<String> list, ResourceBundle bundle) {
		final StringBuilder buffer = new StringBuilder();

		for (String str : list) {
			try {
				if (isStringNotNull(str)) {
					buffer.append(bundle.getString(str));
				}
			} catch (Exception e) {
				buffer.append(str);
			}

			buffer.append(", ");
		}

		if (buffer.length() > 1) {
			buffer.delete(buffer.length() - 2, buffer.length() - 1);
		}

		return buffer.toString();
	}

	/**
	 * isStringNotNull : Return true if String not null otherwise false
	 * 
	 * @param String
	 * @return boolean
	 */
	private boolean isStringNotNull(String str) {
		boolean isNotNull = false;

		if (str != null && !"".equalsIgnoreCase(str.trim())) {
			isNotNull = true;
		}

		return isNotNull;
	}

	/**
	 * Converts list param string to comma separated values
	 * @param list
	 * @return
	 */
	private String getParamValues(final List<String> list) {
		final StringBuilder buffer = new StringBuilder();

		for (String str : list) {
			if (isStringNotNull(str)) {
				buffer.append(str);
			}
			buffer.append(", ");
		}

		if (buffer.length() > 1) {
			buffer.delete(buffer.length() - 2, buffer.length() - 1);
		}

		return buffer.toString();
	}

}
