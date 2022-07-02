<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	JSONArray array = new JSONArray();	
	
	int j=0;
	for(int i=1;i<=num;i++){
		if(num%i==0){
			array.put(j, i);
			j++;		
		}
	}

	out.write(array.toString());
%>