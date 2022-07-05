<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. param에 data값을 받아온다.
	// 2. attribute에 맵처럼 키와 값을 넣어준다. 키의 이름은 result, 값의 이름은 request_+"param"
	// 3. sendRedirect()함수로 redirect_result.jsp페이지로 간다.
	
	String param = request.getParameter("data");
	request.setAttribute("result","request_"+param);
	response.sendRedirect("redirect_result.jsp");
%>