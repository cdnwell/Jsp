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
	// 1. Cookie 클래스의 배열을 만들고, request에서 getCookies()로 cookie 배열을 가져온다.
	// 2. getName() 메서드로 각 배열의 name 값을 가져오고 / 로 구분하여 getValue()로 value 값도 가져온다.
	// 3. 세션에서 id를 가져온다. 마지막으로
	Cookie [] cookies = request.getCookies();
	for(int i=0;i<cookies.length;i++){
		%>
		<%=cookies[i].getName() %> / <%=cookies[i].getValue() %><br>
		<%
	}
%>
<%=session.getId() %>
</body>
</html>