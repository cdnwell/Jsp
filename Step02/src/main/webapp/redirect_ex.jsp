<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String param = request.getParameter("data");
	//맵처럼 씀, result에 request_ + (param변수) String을 넣겠다.
	request.setAttribute("result","request_"+param);
	//경로잡는 것은 상대 경로, 절대 경로 둘 다 쓸 수 있는데
	//redirect_result.jsp로 이동
	//sendRedirect로 페이지 이동시 request 영역이 전부 초기화가 된다.
	//03_send_redirect에서 데이터를 보내도 데이터 null값이 나온다.
	response.sendRedirect("redirect_result.jsp");
	
	
	
%>