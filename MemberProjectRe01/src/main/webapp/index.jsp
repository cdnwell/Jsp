<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		margin : 0px;
		padding : 0px;
	}
	
	h2{
		padding : 15px;
	}
	
	#container{
		width : 600px;
		margin : 100px auto;
		display : flex;
		flex-direction : column;
		text-align : center;
		align-items : center;
	}
	
	input{
		display : block;
		width : 200px;
		height : 25px;
		padding : 5px;
		margin : 5px;
		outline : none;
		border : 1px solid #b7b7b7;
		border-radius : 5px;
	}
	
	button{
		margin : 3px;
		display : inline-block;
		width : 217px;
		height :34px;
		font-size : 20px;
		font-weight : bold;
		color : white;
		border : none;
		border-radius : 5px;
		background-color : cornflowerblue;		
	}	
</style>
</head>
<body>
	<c:if test="${sessionScope.dto != null }">
		<c:redirect url="main.jsp"/>
	</c:if>
	<div id="container">
		<form action="login.do" method="post">
			<h2>회원관리 시스템</h2>
			<input type="text" name="id" placeholder="아이디를 입력하세요">
			<input type="password" name="pass" placeholder="암호를 입력하세요">
			<button>로그인</button>
		</form>
	</div>
</body>
</html>