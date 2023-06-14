package com.wb.tdp.ms.common.session;

import java.io.Serializable;

public class SessionContext implements Serializable{

	private static final long serialVersionUID = 3493336588278100732L;


	/**This fields indicates whether the authentication is success is not.
	 * 
	 */
	private boolean authenticate;
	
	
    /**Logged in time.
     * 
     */
    private String loginTime;
    

	public boolean isAuthenticate() {
		return authenticate;
	}

	public void setAuthenticate(boolean authenticate) {
		this.authenticate = authenticate;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	
	
}
