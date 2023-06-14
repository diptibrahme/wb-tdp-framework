package com.wb.tdp.ms.common.validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Message class that encapsulates all kinds of messages - errors, warnings,
 * informations. Each message information is put in the MessageData class
 * 
 * @author Anand Gupta
 * @version 1.0
 * @see MessageData
 */
public class Message implements Serializable {

	
	/**
	 * Default serialVersionUID
	 */
	
	private static final long serialVersionUID = 2430575972783824296L;
	
	
	/**
	 * All kinds of message data list populated by service layer
	 */
	private final List<MessageData> messageDataList = new ArrayList<MessageData>();

	/**
	 * adds a message to the list
	 * 
	 * @param msgData
	 *            MessageData object
	 */
	public void addMessage(MessageData msgData) {
		messageDataList.add(msgData);
	}

	/**
	 * Method to add collection of MessageData object to messageDataList.
	 * 
	 * @param messageDataList - list of MessageData object
	 */
	public void addMessageDataList(List<MessageData> messageDataList) {
		this.messageDataList.addAll(messageDataList);
	}

	public List<MessageData> getMessageDataList() {
		return messageDataList;
	}

	boolean numbered;

	/**
	 * Checks if the list of messages data returned by the service has any
	 * confirmation message.
	 * 
	 * @return boolean true if confirmation message is there.
	 */

	public boolean hasConfirmation() {
		boolean confirm = false;
		for (MessageData messageData : messageDataList) {
			if (MessageData.CONFIRMATION.equals(messageData.getMessageType())) {
				confirm = true;
				break;
			}
		}
		return confirm;
	}

	/**
	 * returns a list of confirmation messages from message list
	 * 
	 * @return List list of confirmation messages
	 */

	public List<MessageData> getConfMessages() {
		List<MessageData> confmessageDataList = new ArrayList<MessageData>();
		for (MessageData messageData : messageDataList) {
			if (MessageData.CONFIRMATION.equals(messageData.getMessageType())) {
				confmessageDataList.add(messageData);
			}
		}
		return confmessageDataList;
	}

	/**
	 * returns a list of information messages from message list
	 * 
	 * @return List list of information messages
	 */
	public List<MessageData> getInfoMessages() {
		List<MessageData> infomessageDataList = new ArrayList<MessageData>();
		for (MessageData messageData : messageDataList) {
			if (MessageData.INFORMATION.equals(messageData.getMessageType())) {
				infomessageDataList.add(messageData);
			}
		}
		return infomessageDataList;
	}
	
	public List<MessageData> getErrorMessages() {
		List<MessageData> errorMessageDataList = new ArrayList<MessageData>();
		for (MessageData messageData : messageDataList) {
			if (MessageData.ERROR.equals(messageData.getMessageType())) {
				errorMessageDataList.add(messageData);
			}
		}
		return errorMessageDataList;
	}

	/**
	 * returns a list of information messages from message list
	 * 
	 * @return List list of information messages
	 */
	public List<MessageData> getWarningMessages() {
		List<MessageData> warnmessageDataList = new ArrayList<MessageData>();
		for (MessageData messageData : messageDataList) {
			if (MessageData.WARNING.equals(messageData.getMessageType())) {
				warnmessageDataList.add(messageData);
			}
		}
		return warnmessageDataList;
	}

	public boolean isNumbered() {
		return numbered;
	}

	public void setNumbered(boolean numbered) {
		this.numbered = numbered;
	}

}
