<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//session.setAttribute("id",null);
	session.invalidate();
	out.write("<script>alert('로그아웃 되었습니다.');</script>");
	response.sendRedirect("index.jsp");
%>