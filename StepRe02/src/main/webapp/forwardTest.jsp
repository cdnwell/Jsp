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
	out.write("<script>alert('안녕하세요');</script>");
	//out.write("<script>location.href='forwardResult.jsp'</script>");
%>
<%= request.getParameter("name") %>
<%= request.getParameter("hobby") %>

<jsp:forward page="forwardResult.jsp"></jsp:forward>
</body>
</html>