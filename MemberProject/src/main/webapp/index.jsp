<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	#login_box{
		margin : 100px auto;
		width:1200px;
		text-align : center;
	}
	
	input{
		margin:5px 0;
		height:27px;
		width : 210px;
		border : 1px solid #b7b7b7;
		border-radius : 5px;
		padding : 5px;
		outline : none;
	}
	
	button{
		outline : none;
		margin : 5px 0;
		width : 222px;
		font-size : 20px;
		padding : 5px;
		background-color : cornflowerblue;
		color : white;
		border : none;
		border-radius : 5px;
		font-weight: bold;
	}
	
</style>
<script>
	
</script>
</head>
<body>
<c:if test="${sessionScope.dto != null}">
	<!-- 
		sendRedirect와 같다.
		location.href = 'main.jsp';
	 -->		
	<c:redirect url="main.jsp"/>
</c:if>
	<!-- 로그인이 되어있으면 main.jsp로 이동 -->
	<div id="login_box">
	<h2>회원관리 시스템</h2>
	<form action="login.do" method="post">
		<input type="text" name="id" placeholder="아이디를 입력하세요"> <br>
		<input type="password" name="pass" placeholder="암호를 입력하세요"> <br>
		<button>로그인</button>
	</form>
	</div>
</body>
</html>