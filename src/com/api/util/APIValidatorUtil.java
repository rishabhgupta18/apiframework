//$Id$
package com.api.util;

import java.util.regex.Pattern;

public class APIValidatorUtil {

	public static final Pattern URL_VERSION_PATTERN = Pattern.compile("/v(.*?)/");
	public static final int LEAST_SUPPORTED_VERSION = 2;
	
	
	public static void validateAPIVersion(String url){
		
	}
}
