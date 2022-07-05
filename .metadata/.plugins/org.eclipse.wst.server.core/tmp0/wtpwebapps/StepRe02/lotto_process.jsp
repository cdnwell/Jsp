<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int num = Integer.parseInt(request.getParameter("num"));
	ArrayList <HashSet<Integer>> list = new ArrayList<>();
	Random r = new Random();
	
	for(int i=0;i<num;i++){
		HashSet <Integer> numBox = new HashSet<>();
		while(numBox.size()<6){
			numBox.add(r.nextInt(45)+1);
		}
		list.add(numBox);
	}

	request.setAttribute("list", list);
	
	request.getRequestDispatcher("lotto_result.jsp").forward(request,response);
	
%>