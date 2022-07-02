<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 1. data 변수 받아오기
	// 2. attribute에 result 키로 request_(+param : 변수) 값 저장하기
	// 3. getRequestDispatcher 메서드
	// 3-1. RequestDispatcher 클래스
	// 4. forward 메서드
	
	String data = request.getParameter("data");
	request.setAttribute("result", "request_"+data);
	RequestDispatcher dispatcher = request.getRequestDispatcher("forward_result.jsp");
	dispatcher.forward(request, response);
%>