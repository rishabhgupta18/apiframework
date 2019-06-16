//$Id$
package com.api.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.api.constant.APIConstants;
import com.api.handler.ResponseBuilder;
import com.opensymphony.xwork2.ActionContext;

import net.bytebuddy.asm.Advice.This;

import static com.api.constant.APIConstants.Response.*;

public class APIException extends Exception{
	
	private int statusCode;
	private String errorCode;
	private String errorMessage;
	private JSONObject extraDetails;
	private String apiName;

	public APIException(){}
	
	public APIException(int statusCode, String errorCode, String errorMessage) throws Exception{
		this(statusCode, errorCode,errorMessage, new JSONObject());
	}
	
	public APIException(int statusCode, String errorCode, String errorMessage, Map<String, String> extraDetails) throws Exception{
		this(statusCode, errorCode, errorMessage, new JSONObject(extraDetails));
	}
	
	
	public APIException(int statusCode, String errorCode, String errorMessage, JSONObject extraDetails) throws Exception{
		
		if(statusCode == 0){
			throw new RuntimeException("ERROR_CODE CAN'T BE ZERO");	
		}
		
		this.setStatusCode(statusCode);
		this.setErrorCode(errorCode);
		this.setErrorMessage(errorMessage);
		
		if(extraDetails == null){
			extraDetails = new JSONObject();
			if(this.getApiName()!=null){
				extraDetails.put(APIConstants.API_NAME, this.getApiName());
			}
		}
		
		this.setExtraDetails(extraDetails);
	}
	
	public static void handleException(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Object e = ActionContext.getContext().getValueStack().findValue("exception");
		APIException ex = null;
		if(e != null && e instanceof APIException){
			ex = (APIException) e;
		}else {
			ex = new APIException(APIConstants.StatusCodes.INTERNAL_SERVER_ERROR, APIConstants.ERRORCodes.INTERNAL_SERVER_ERROR, APIConstants.ERRORMessages.INTERNAL_SERVER_ERROR);
		}
		handleException(ex, request, response);
	}
	
	public static void handleException(APIException e, HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setHeader("Content-Disposition", "attachment; filename=response.json");
		ResponseBuilder.writeExceptionResponse(e, response);
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public JSONObject getExtraDetails() {
		return extraDetails;
	}

	public void setExtraDetails(JSONObject extraDetails) {
		this.extraDetails = extraDetails;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	
	public JSONObject getErrorJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put(CODE, this.errorCode);
		json.put(DETAILS, this.extraDetails);
		json.put(MESSAGE, this.errorMessage);
		json.put(STATUS, ERROR);
		return json;
	}
	
}
