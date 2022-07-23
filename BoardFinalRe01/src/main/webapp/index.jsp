<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	form{
		margin : 150px auto;
		display : flex;
		flex-direction : column;
		width : 220px;
	}
	input{
		padding : 7px;
		margin-top : 10px;
	}
	button{
		width : 80px;
		height : 30px;
		background-color : cornflowerblue;
		border : 1px solid gray;
		margin-top : 10px;
		border-radius : 3px;
		color : white;
		font-weight : bold;
	}
	a{
		font-size : 14px;
		text-decoration : none;
		color : black;
	}
</style>
<title>로그인 페이지</title>
</head>
<body>
	<form action="login.do" method="post">
		<input type="text" name="id" placeholder="아이디를 입력해주세요">
		<input type="password" name="passwd" placeholder="비밀번호를 입력해주세요">
		<div>
			<button>로그인</button>
			<a href="register.html">회원가입</a>
		</div>
	</form>
</body>
</html>