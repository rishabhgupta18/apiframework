//$Id$
package com.api.pojo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestInfo {
	private String method;
	private HttpServletRequest request;
	private String parts[];
	private Map<String, String> params = new HashMap<String, String>();
	
	public RequestInfo() {
	}
	
	
	
}
