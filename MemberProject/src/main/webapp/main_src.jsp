<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container{
		width : 100%;
		display : flex;
		flex-direction: column;
	}
	.login_box{
		width:250px;
		align-self:flex-end; 
	}
	.main_menu{
		width:100%;
		border-bottom : 1px solid #b7b7b7;
		text-align : center;	
	}
	h2{
		display : inline-block;
		padding : 0px 75px;
	}
</style>
</head>
<body>
	<div class="container">
	<div class="login_box">
		<p>OOO님 로그인 하셨습니다.</p>
		<p><a href="logout.do">로그아웃</a> | <a href="#">회원정보 수정</a></p>
	</div>
	<div class="main_menu">
		<h2>홈</h2>
		<h2>회원목록</h2>
		<h2>회원정보 추가</h2>
	</div>
	</div>
</body>
</html>
