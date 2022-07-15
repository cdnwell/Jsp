<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
	.container{
		width: 300px;
		margin: 100px auto;
		display : flex;
		flex-direction : column;
	}
	h2{
		text-align: center;
	}
	input {
		height: 40px;
		outline: none;
		border-radius: 5px;
		box-sizing: border-box;
		margin-bottom: 7px;
		border : 1px solid gray;
		padding : 7px;
	}
	button{
		height: 40px;
		font-size: 18px;
		background-color: rgb(52, 152, 219);
		outline: none;
		box-sizing: border-box;
		border-radius: 5px;
		border : 1px solid rgb(52, 120, 255);
		color:white;
		font-weight: bold;
	}
	form {
		width: 300px;
		display: flex;
		margin:0 auto;
		flex-direction: column;
	}
	form > a {
		text-decoration : none;
		padding : 5px;
	}
</style>
</head>
<body>
<!-- 로그인이 되어 있으면 main.jsp로 이동 -->
<c:if test="${sessionScope.dto != null}">
	<c:redirect url="main.do"/>
</c:if>
	<div class="container">
		<h2>로그인 페이지</h2>
		<form action="login.do" method="post">
			<input type="text" name="id" placeholder="아이디를 입력하세요">
			<input type="password" name="passwd" placeholder="암호를 입력하세요">
			<button>로그인</button>
			<a href="member_register.jsp">회원가입</a>
		</form>
	</div>
</body>
</html>
