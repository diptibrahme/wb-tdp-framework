package com.wb.tdp.ms.common.security;

import java.util.List;

import com.wb.tdp.ms.common.constants.AppConstants;
import com.wb.tdp.ms.common.dto.RequestDto;
import com.wb.tdp.ms.common.utils.CurrentCommonHeaders;

/**
 * Utility class for Spring Security.
 */
public final class SecurityUtils {

    private SecurityUtils() {
    }

    /**
     * Get the login of the current user.
     *
     * @return the login of the current user
     */
    public static String getCurrentUserLogin() {
    	RequestDto requestDto = CurrentCommonHeaders.get();
    	return requestDto.getProxyUser() != null ? requestDto.getProxyUser() : requestDto.getOriginSource().name();
    }
    
    public static boolean isAdmin(List<String> roles) {
		boolean flag = false;
		if (roles.contains(AppConstants.ROLE_ADMIN)||roles.contains(AppConstants.ROLE_SUPER_USER)){
			flag = true;
		}
		return flag;
	}
}