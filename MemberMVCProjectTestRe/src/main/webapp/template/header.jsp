<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.container {
	width: 1200px;
	margin: 0 auto;
	display: flex;
	flex-direction: column;
}

.login_box {
	align-self: flex-end;
}

.login_box>p>a {
	text-decoration: none;
	color: gray;
}

nav {
	display: flex;
	flex-direction: row;
	width: 100%;
	background-color: indianred;
	justify-content: space-around;
	border-radius: 10px;
}

li {
	display: inline-block;
	text-align: center;
}

li>a {
	display: inline-block;
	width: 150px;
	padding: 12px;
	text-decoration: none;
	color: white;
	font-weight: bold;
}

table {
	border-collapse: collapse;
	width: 80%;
	margin: 0 auto;
}

caption {
	padding: 10px;
	font-weight: bold;
}

td, th {
	border: 1px solid #b7b7b7;
	padding: 10px;
}
</style>
<div class="login_box">
	<p>${sessionScope.dto.name}님이 로그인 하셨습니다.</p>
	<p>
		<a href="logout.do">로그아웃</a> | <a href="update_view.jsp">정보수정</a>
	</p>
</div>
<nav>
	<ul>
		<li><a href="main.jsp">홈</a></li>
		<li><a href="memberList.do">회원목록</a></li>
		<li><a href="register.jsp">회원추가</a></li>
	</ul>
</nav>