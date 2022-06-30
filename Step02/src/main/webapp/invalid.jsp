<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();		//세션을 무력화 하는 부분
	
	response.sendRedirect("session_result.jsp");
%>