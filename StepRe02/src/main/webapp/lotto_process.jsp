<%@page import="java.util.Random"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<HashSet<Integer>> list = new ArrayList<>();
	Random r = new Random();	

	int num = Integer.parseInt(request.getParameter("num"));

	for(int i = 0;i<num;i++){
		HashSet<Integer> set = new HashSet<>();
		while(set.size()<6){
			set.add(r.nextInt(45)+1);
		}
		list.add(set);
	}
	
	request.setAttribute("list",list);
	
	request.getRequestDispatcher("lotto_result.jsp").forward(request, response);

%>