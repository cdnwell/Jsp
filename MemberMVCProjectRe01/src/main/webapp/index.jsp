<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form{
		width: 100%;
		padding-top : 50px;
		display : flex;
		flex-direction : column;
		align-items : center;
	}
	
	input{
		width : 220px;
		height : 20px;
		border-radius : 5px;
		outline : none;
		padding : 10px;
		border : 1px solid #b7b7b7;
		margin : 7px;
	}
	
	button{
		width : 245px;
		height : 40px;
		border-radius : 5px;
		outline : none;
		font-size : 20px;
		color : white;
		font-weight : bold;
		border : 1px solid #b7b7b7;
		background-color : cornflowerblue;
		
	}
	
</style>
</head>
<body>

	<div id="container">
		<form action="login.do" method="post">
			<h2>로그인 시스템</h2>
			<input type="text" name="id" placeholder="아이디를 입력해주세요">
			<input type="password" name="pass" placeholder="비밀번호를 입력해주세요">
			<button>로그인</button>
		</form>
	</div>
</body>
</html>