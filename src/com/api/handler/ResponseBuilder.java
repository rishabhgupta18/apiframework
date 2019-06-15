//$Id$
package com.api.handler;

import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import com.api.exception.APIException;
import com.api.constant.APIConstants.ContentType;

public class ResponseBuilder {
	
	public static void writeResponse(){
		
	}
	
	public static void writeExceptionResponse(APIException ae, HttpServletResponse response){
		writeExceptionResponse(ae, response, null);
	}
	
	public static void writeExceptionResponse(APIException ae, HttpServletResponse response, String contentType){
		response.setHeader("X-Download-Options", "noopen"); //No I18N
		response.setHeader("X-Content-Type-Options","nosniff"); //No I18N
		response.setContentType(ContentType.JSON);
		response.setStatus(ae.getStatusCode());
		try{
			HashMap<String, String> responseHeaders = null;
			
			
		}catch(Exception ex){
			
		}
		
		
		
	}
	
	
}
