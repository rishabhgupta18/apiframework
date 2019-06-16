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
	
	public static class StatusCodes{
		public static final Integer OK = 200;
		public static final Integer CREATED = 201;
		public static final Integer ACCEPTED = 202;
		public static final Integer NO_CONTENT = 204;
		public static final Integer BAD_REQUEST = 400;
		public static final Integer UNAUTHORIZED = 401;
		public static final Integer FORBIDDEN = 403;
		public static final Integer NOT_FOUND = 404;
		public static final Integer METHOD_NOT_ALLOWED = 405;
		public static final Integer NOT_ACCEPTABLE = 406;
		public static final Integer TOO_MANY_REQUEST = 429;
		public static final Integer INTERNAL_SERVER_ERROR = 500;
		public static final Integer SERVICE_UNAVAILABLE = 503;
	}
	
	public static class ERRORCodes{
		public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
		public static final String URL_NOT_FOUND = "URL_NOT_FOUND";
	}
	
	public static class ERRORMessages{
		public static final String INTERNAL_SERVER_ERROR = "internal server error";
		public static final String URL_NOT_FOUND = "the url you are trying to access does not exists";
	}
	
	public static class Response{
		public static final String CODE = "code";
		public static final String STATUS = "status";
		public static final String MESSAGE = "message";
		public static final String DETAILS = "details";
		public static final String INFO = "info";
		public static final String SUCCESS = "success";
		public static final String ERROR = "error";
		public static final String API_NAME = APIConstants.API_NAME;
		public static final String PARAM = "param";
	}
	
	
}
