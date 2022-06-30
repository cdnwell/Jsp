<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String param = request.getParameter("data");
	request.setAttribute("result","request_"+param);
	//굳이 저장하지 않고 forward 메서드를 맨 뒤에 그냥 붙여서 쓰는 것이 일반적이다.
	RequestDispatcher dispatcher = request.getRequestDispatcher("forward_result.jsp");
	//request, response 같이 보냄
	//데이터를 보내줘서 유지가 됨
	dispatcher.forward(request, response);
	//forward로 하면 url을 감추는 기능도 하긴 한다.
	
	// 1. data 변수 받아오기
	// 2. attribute에 result 키로 request_(+param : 변수) 값 저장하기
	// 3. getRequestDispatcher 메서드
	// 3-1. RequestDispatcher 클래스
	// 4. forward 메서드
%>