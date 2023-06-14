package com.wb.tdp.ms.common.authorization;

import java.io.Serializable;

/**This class contains the authorization informations which are passed along with the input.
 * 
 * @author anangupt
 *
 */
public class AuthorizationInfo implements Serializable {

	private static final long serialVersionUID = 407316486557834927L;

	/**Roles of login customer.
	 * 
	 */
	private String userId;
	
	/**User id of authorizationId.
	 * 
	 */
	private String authorizationId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAuthorizationId() {
		return authorizationId;
	}
	public void setAuthorizationId(String authorizationId) {
		this.authorizationId = authorizationId;
	}

	
	
}
