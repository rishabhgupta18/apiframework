//$Id$
package com.api.v1;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.config.entities.Parameterizable;

public class Router extends ActionSupport implements ModelDriven, Parameterizable {

	private Map<String, String> params;
	
	public String get_ping(){
		return "success";
	}

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
		this.params = params;
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
}
