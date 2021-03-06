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
	#container{
		width : 1200px;
		margin : 0 auto;
		display : flex;
		flex-direction : column;
	}
	.login_box{
		padding-top : 50px;
		align-self : flex-end;
	}
	nav{
		width : 1200px;
		margin : 100px auto;
		
	}
	ul{
		display : flex;
		flex-direction : row;
		justify-content : space-around;
		
	}
	li{
		list-style-type: none;
	}
	li a{
		width : 150px;
		text-align : center;
		display : inline-block;
		text-decoration : none;
		color : black;
		font-size : 26px;
		font-weight : bold;
	}
</style>
</head>
<body>
	 
	<c:if test="${sessionScope.dto == null }"> 
		<c:redirect url="index.jsp"/>
	</c:if>
	
	<div id="container">
		<div class="login_box">
			${sessionScope.dto.name }님이 로그인하셨습니다.<br>
			<a href="logout.do">로그아웃</a> |
			<a href="#">정보수정</a>
		</div>
		<nav>
			<ul>
				<li><a href="main.jsp">홈</a></li>
				<li><a href="#">회원목록</a></li>
				<li><a href="#">회원추가</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>