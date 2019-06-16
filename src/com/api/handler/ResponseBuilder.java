//$Id$
package com.api.handler;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
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
	
	public static void writeResponse(Response ae, HttpServletResponse response, String contentType) throws Exception{
		response.setHeader("X-Download-Options", "noopen"); //No I18N
		response.setHeader("X-Content-Type-Options","nosniff"); //No I18N
		if(contentType == null) {
			contentType = ContentType.JSON;
		}
		response.setContentType(contentType);
		response.setStatus(APIConstants.StatusCodes.OK);
		PrintWriter out = null;
		try{
			out = response.getWriter();
			out.write(ae.getResponse().toString());
			out.flush();
		}catch(Exception ex){
			
		}finally {
			if(out!=null) {
				out.close();
			}
		}
	}
	
	
}
