//$Id$
package com.api.constant;

public class APIConstants {

	public static final String API_NAME = "api_name";
	public static final String URL_INFO = "url_info";
	
	
	public static class  ContentType{
		public static final String JSON = "application/json;charset=utf-8";
		public static final String TEXT = "text/plain";
		public static final String MULTIPART = "multipart/form-data";
		
	}
	
	public static class HTTPMethod{
		public static final String GET = "GET";
		public static final String POST = "POST";
		public static final String PUT = "PUT";
		public static final String DELETE = "DELETE";
		public static final String PATCH = "PATCH";
	}
	
}
