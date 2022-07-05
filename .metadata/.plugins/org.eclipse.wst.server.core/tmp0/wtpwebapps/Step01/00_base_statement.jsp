<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 기본 문법</title>
</head>
<body>
<!-- 선언문(jsp에서 미리 만들어 놓을 전역 변수나 메서드) -->
<%!
	//jsp도 클래스다. 클래스에 필요한 필드랑 메서드를 만드는 부분 <%!
	
	//필드
	String message = "Hello Wolrd";

	//메서드
	public String getMessage(){
		return message;
	}
%>

<!-- 표현식, 화면(html)에 값을 출력하는 부분 -->
선언문 필드 테스트 : <%=message %><br>
선언문 메서드 테스트 : <%=getMessage() %>
<!-- 선언문은 잘 쓰지 않는다. 할 일이 별로 없음 -->
<!-- 주로 많이 쓰는 건 표현식, 실제로 클라이언트가 받아서 처리하는 부분... -->

<!-- 스크립트릿, 사용자가 서버에 데이터를 전달, 실제 jsp에서 일을 하는 부분 -->
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String str = request.getParameter("msg");
%>
스크립트릿 테스트 : <%=num %><br>
스크립트릿 테스트 : <%=str %>
<!-- 스크립트릿 테스트와 표현식 정도만 기억하기 -->
</body>
</html>