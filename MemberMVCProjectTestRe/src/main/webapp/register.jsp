<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 추가</title>
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

form {
	margin: 0 auto;
	display: flex;
	flex-direction: column;
	align-items: center;
}

form>input {
	width: 220px;
	padding: 10px;
	margin-top: 7px;
}

.register_gender {
	align-self: flex-start;
	margin-top: 7px;
}

.register_buttons>button {
	margin-top: 10px;
	background-color: cornflowerblue;
	width: 80px;
	border: none;
	color: white;
	padding: 5px;
	border-radius: 5px;
}

.register_buttons {
	align-self: flex-start;
}
</style>
</head>
<body>
	<div class="container">
		<div class="login_box">
			<p>${sessionScope.dto.name }님이 로그인 하셨습니다.</p>
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
		<form action="register.do" method="post">
			<h2>회원정보 추가</h2>
			<input type="text" name="id" placeholder="아이디를 입력해주세요"> <input
				type="password" name="passwd" placeholder="비밀번호를 입력해주세요"> <input
				type="text" name="name" placeholder="이름을 입력해주세요"> <input
				type="number" name="age" placeholder="나이를 입력해주세요">
			<div class="register_gender">
				<input type="radio" name="gender" id="gender_m" value="M"><label
					for="gender_m"> 남 </label> <input type="radio" name="gender"
					id="gender_f" value="F"><label for="gender_f"> 여 </label>
			</div>
			<input type="text" name="address" placeholder="주소 입력해주세요">
			<div class="register_buttons">
				<button>회원등록</button>
				<button type="reset">취소</button>
			</div>
		</form>
	</div>
</body>
</html>