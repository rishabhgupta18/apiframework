package com.api.v1;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.api.handler.Response;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.config.entities.Parameterizable;

public class APIRouter extends ActionSupport implements ModelDriven, Parameterizable {

	
	private static final long serialVersionUID = -8512110524474850215L;
	
	private Map<String, String> params;
	private JSONObject response = new JSONObject();

	
	@Override
	public void addParam(String key, String value) {
		if (params == null)
		{
			params = new HashMap<String, String>();
		}

		params.put(key, value);
		
	}

	@Override
	public void setParams(Map<String, String> paramMap) {
		this.params = paramMap;
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addResponse(String key, String value) throws Exception {
		response.put(key, value);
	}
	
	public String response() {
		
		ActionContext.getContext().getValueStack().set("response", new Response(response));
		return "success";
	}
}
