//$Id$
package com.api.v1;

import com.api.exception.APIException;

public class Router extends APIRouter {

	private static final long serialVersionUID = 3421796703451056132L;

	public String get_ping() throws Exception{
		addResponse("function", "Ok");
		return response();
	}
	
	public String get_error() throws Exception{
		throw new APIException(204, "Something is worh", "I don't know");
	}
}
