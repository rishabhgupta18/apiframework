//$Id$
package com.api.util;

import javax.servlet.http.HttpServletRequest;

import com.api.constant.APIConstants.HTTPMethod;

public class APIUtils {

	public static boolean isAPIUrl(String uri) {
		return uri.matches("/api/v[0-9]/.*");
	}

	public static String getHttpMethod(HttpServletRequest request) {
		return getHttpMethod(request.getMethod());
	}

	public static String getHttpMethod(String method) {
		if(HTTPMethod.PATCH.equalsIgnoreCase(method)){
			method = HTTPMethod.PUT;
		}
		return method;
	}

}
