<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	ArrayList<Integer> list = new ArrayList<>();
	for(int i =1;i<=num;i++){
		if(num%i ==0){
			list.add(i);
		}
	}
	
	JSONArray array = new JSONArray(list);
	
	out.write(array.toString());
%>