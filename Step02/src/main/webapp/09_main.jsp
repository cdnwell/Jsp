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
	// 1. id에 id 값을 대입한다.
	// 2. 로그인에 실패해 id 변수에 값이 없으면 login 태그를 다시 표현한다.
	// 3. 로그인이 성공하면 logout.jsp 파일로 가는 a태그를 만들어준다.
	String id = (String)session.getAttribute("id");

	if(id == null){
%>
	<form action="login_session_process.jsp" method="post">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pass"><br>
		<button>로그인</button>
	</form>
<%
	}else{
%>
	<%=id %>님이 로그인 하셨습니다.<br>
	<a href="logout.jsp">로그아웃</a>
<%
	}
%>
</body>
</html>