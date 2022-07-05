<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 결과 페이지</title>
</head>
<body>
	<%
		// body에 넣거나 그 위쪽에 자바 넣어도 상관없음
		int dan = Integer.parseInt(request.getParameter("dan"));
	%>
		<h2><%=dan%>단</h2>
	<%	
		// 퍼센트 들여쓰기 상관없음
		for(int i=1;i<=9;i++){
	%>
		<p><%=dan%> * <%=i%> = <%=dan*i%></p>
	<%
		}
	%>
</body>
</html>