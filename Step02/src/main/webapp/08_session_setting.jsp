<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=session.getId() %><br>
<%
	//redirction이 됬는데도 데이터가 유지되었다는 것을 보여주기 위한 값
	request.setAttribute("req","request value");

	//세션 설정
	//jsp에는 세션 객체가 미리 만들어져 있다.
	//세션 만료 시간 설정
	session.setMaxInactiveInterval(30);	//초단위
	session.getMaxInactiveInterval();	//세션만료 시간,사용자가 반응이 있으면 세션시간을 계속 설정해주어야
	//유지가 됨. 이동하는 동안 계속 차감이 됨, 30분 뒤에 자동으로 꺼지거나 페이지 이동할 때 마다 세션을 계속 설정해주기.
	session.setAttribute("session","session value");
	//attribute에서 꺼내기 위해서는 getAttribute를 사용
	
	//페이지 이동
	//request.getRequestDispatcher("session_result.jsp").forward(request,response);
	response.sendRedirect("session_result.jsp");
	
%>
</body>
</html>