<%@page import="com.api.handler.ResponseBuilder"%>
<%@page import="com.api.constant.APIConstants"%>
<%@page import="com.api.exception.APIException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<%

APIException ae = new APIException(APIConstants.StatusCodes.NOT_FOUND, APIConstants.ERRORCodes.URL_NOT_FOUND,APIConstants.ERRORMessages.URL_NOT_FOUND);
APIException.handleException(ae, request, response);

%>
</body>
</html>