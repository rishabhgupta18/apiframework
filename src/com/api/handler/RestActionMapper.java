//$Id$
package com.api.handler;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.RequestUtils;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.dispatcher.mapper.DefaultActionMapper;

import com.api.constant.APIConstants;
import com.api.exception.APIException;
import com.api.pojo.URLInfo;
import com.api.util.APIUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.config.entities.ActionConfig;

public class RestActionMapper extends DefaultActionMapper {
	
	private static final Logger LOGGER = Logger.getLogger(RestActionMapper.class.getName());

	public RestActionMapper(){
		setSlashesInActionNames("true");
	}
	
	
	@Override
	public ActionMapping getMapping(HttpServletRequest request, ConfigurationManager configMan) {
		
		try{
			
			URLInfo urlInfo = new URLInfo();
			ActionMapping mapping = new ActionMapping();
			String uri = RequestUtils.getUri(request);
			if(!APIUtils.isAPIUrl(uri)){
				return null;
			}else{
				parseNameAndNamespace(uri, mapping, configMan);
				handleSpecialParameters(request, mapping);
				mapping = parseActionName(mapping);
			}
			//namespace =  /api
			String namespace = mapping.getNamespace();
			// actionName = /v1/*
			String actionName = mapping.getName();
			ActionConfig ac = configMan.getConfiguration().getRuntimeConfiguration().getActionConfig(namespace, actionName);
			if(ac == null){
				return null;
			}
			String methodName = ac.getMethodName();
			Map<String, String> params = ac.getParams();
			if (methodName == null)
			{
				methodName = "execute"; //No I18N
			}
			String requestMethod = APIUtils.getHttpMethod(request).toLowerCase();
			methodName = requestMethod+"_"+methodName;
			mapping.setMethod(methodName);
			String pattern = params.get("pattern");
			if(pattern!=null){
				String[] parts = pattern.split("/");
				String[] urlParts = actionName.split("/");
				int pLen = parts.length;
				for(int i=0;i<pLen;i++){
					String part = parts[i];
					String partValue = urlParts[i];
					String setterMethod = "set"+StringUtils.capitalize(part);
					try{
						Method method = urlInfo.getClass().getMethod(setterMethod, String.class);
						method.invoke(urlInfo, partValue);
					}catch(Exception ex){
						LOGGER.log(Level.FINE, "no setter method found for ::: ", partValue);
					}
					
				}
			}
			ActionContext.getContext().getValueStack().set(APIConstants.URL_INFO, urlInfo);
			return mapping;
		}catch(Exception e){
			LOGGER.log(Level.WARNING, "::: ERROR ::: REST :::", e);
			return null;
		}
	}
}
