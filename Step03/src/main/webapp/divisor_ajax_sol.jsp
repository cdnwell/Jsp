<%@page import="org.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//서버쪽에서 클라이언트가 보낸 데이터는 무조건 request.getParameter
	//서버쪽에서 쓸 것만 session에 attribute로 저장하는 것
	int num = Integer.parseInt(request.getParameter("num"));

	ArrayList<Integer> list = new ArrayList<>();
	
	for(int i =1;i<=num;i++){
		if(num%i==0){
			list.add(i);
		}
	}
	
	JSONArray array = new JSONArray(list);
	out.write(array.toString());
	
%>