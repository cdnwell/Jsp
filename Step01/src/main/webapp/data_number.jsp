<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>

<%
	// 자바 코드가 화면에 나타나지는 않는다.
	// jsp에서는 사용자한테 내용을 전달해주기 전에, 자바 코드는 서버에서 다 실행
	// 실행 결과를 클라이언트에게 주기 때문에 jsp 정보는 모른다.
	// <%= 안의 데이터도 다 실행된 뒤에 나옴 
	
	// web으로 전송해주는 것은 다 문자열이다.
	String n =request.getParameter("num");
	int end = Integer.parseInt(n);
	for(int i=1;i<=end;i++){
%>
		<p><%=i %></p>
<%
	}
%>

</body>
</html>