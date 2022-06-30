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
	request.setAttribute("일련번호",1324667);
	request.setAttribute("배송품","가전기기");
	request.setAttribute("주소", "한국 서경동 14-2 1250호");
%>
<a href="request_attribute_result.jsp">페이지 이동</a>
   <form action="request_attribute_result.jsp">
      <button>전송</button>
   </form>
</body>
</html>