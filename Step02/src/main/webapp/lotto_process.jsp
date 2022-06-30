<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int ea = Integer.parseInt(request.getParameter("num"));
	ArrayList<HashSet<Integer>> list = new ArrayList<>();
	Random r = new Random();
	for(int i=0;i<ea;i++){
		HashSet<Integer> set = new HashSet<>();
		while(set.size()< 6){
			set.add(r.nextInt(45)+1);
		}
		list.add(set);
	}
	
	request.setAttribute("list", list);
	
	request.getRequestDispatcher("lotto_result.jsp").forward(request, response);
%>



</body>
</html>