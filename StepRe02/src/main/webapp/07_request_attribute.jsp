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
	request.setAttribute("배송품","가전기기");
%>
<a href="request_attribute_result.jsp">페이지 이동</a>
   <form action="request_attribute_result.jsp">
      <button>전송</button>
   </form>
</body>
</html>