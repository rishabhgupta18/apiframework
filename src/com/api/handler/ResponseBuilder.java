//$Id$
package com.api.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.api.exception.APIException;
import com.api.constant.APIConstants;
import com.api.constant.APIConstants.ContentType;

public class ResponseBuilder {
	
	public static void writeResponse(){
		
	}
	
	public static void writeExceptionResponse(APIException ae, HttpServletResponse response) throws Exception{
		writeExceptionResponse(ae, response, null);
	}
	
	public static void writeExceptionResponse(APIException ae, HttpServletResponse response, String contentType) throws Exception{
		response.setHeader("X-Download-Options", "noopen"); //No I18N
		response.setHeader("X-Content-Type-Options","nosniff"); //No I18N
		if(contentType == null) {
			contentType = ContentType.JSON;
		}
		response.setContentType(contentType);
		response.setStatus(ae.getStatusCode());
		PrintWriter out = null;
		try{
			if(ae.getStatusCode() != APIConstants.StatusCodes.NO_CONTENT) {
				out = response.getWriter();
				out.write(ae.getErrorJSON().toString());
				out.flush();
			}
		}catch(Exception ex){
			
		}finally {
			if(out!=null) {
				out.close();
			}
		}
	}
	
	
}
