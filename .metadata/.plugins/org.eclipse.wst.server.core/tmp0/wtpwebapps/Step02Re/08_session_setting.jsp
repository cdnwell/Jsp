<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=session.getId() %>
<%
	request.setAttribute("req","request value");

	session.setMaxInactiveInterval(30);
	//session.getMaxInactiveInterval();
	session.setAttribute("session","session value");
	
	response.sendRedirect("session_result.jsp");
	
%>
</body>
</html>