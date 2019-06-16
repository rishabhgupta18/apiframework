package com.api.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;

public class Response {
	
	private JSONObject response;
	
	
	public Response(JSONObject response) {
		this.response = response;
	}
	
	public static void handleResponse(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setHeader("Content-Disposition", "attachment; filename=response.json");
		Response re = (Response)ActionContext.getContext().getValueStack().findValue("response");
		ResponseBuilder.writeResponse(re, response, null);
	}
	
	public JSONObject getResponse() {
		return response;
	}
	
}
