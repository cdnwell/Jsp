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
	String id = request.getParameter("일련번호");
	String item = request.getParameter("배송품");
	String address = request.getParameter("주소");
%>
<%=id %> <br>
<%=item %> <br>
<%=address %>
</body>
</html>