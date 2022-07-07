<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
}

.container {
	width: 1200px;
	display: flex;
	flex-direction: column;
	margin: 50px auto;
}

header {
	text-align: right;
}

.profile {
	display: inline-block;
	text-align: left;
}

nav {
	padding: 20px 0px;
	border-bottom: 1px solid black;
}

nav ul {
	list-style-type: none;
	display: flex;
	flex-direction: row;
	justify-content: space-around;
}

nav ul li {
	width: 200px;
}

nav ul li a:link, nav ul li a:visited {
	display: inline-block;
	font-size: 20px;
	font-weight: bold;
	text-align: center;
	width: 100%;
	padding: 10px 0px;
	color: black;
	text-decoration: none;
}

form {
	display: flex;
	flex-direction: column;
	align-items : center;
	margin-top: 40px;
}

h3{
	margin-bottom : 30px;
	font-size : 26px;
}

.registerAdd input[type=text],.registerAdd input[type=number],.registerAdd input[type=password]{
	margin:3px 0;
		height:27px;
		width : 240px;
		border : 1px solid #b7b7b7;
		border-radius : 5px;
		padding : 5px;
		outline : none;
}

.registerAdd input[type=radio]:first-of-type{
	margin-left : -99px;
	
}

.registerAdd input[type=radio]:last-of-type{
	margin-left : 85px;
	
}

div button:first-of-type{
width : 110px;
		font-size : 20px;
		padding : 5px;
		background-color : cornflowerblue;
		color : white;
		border : none;
		border-radius : 5px;
		font-weight: bold;
		margin : 5px;
		display : inline-block;
}
div button:last-of-type{
display : inline-block;
	margin : 5px;
width : 110px;
		font-size : 20px;
		padding : 5px;
		background-color : gray;
		color : white;
		border : none;
		border-radius : 5px;
		font-weight: bold;
}



}
</style>
<body>
	<div class="container">
		<header>
			<div class="profile">
				${sessionScope.dto.name }님 로그인 하셨습니다. <br> <a href="logout.do">로그아웃</a>
				| <a href="#">회원정보 수정</a>
			</div>
		</header>
		<nav>
			<ul>
				<li><a href="#">홈</a></li>
				<li><a href="#">회원목록</a></li>
				<li><a href="#">회원추가</a></li>
			</ul>
		</nav>
		<div class="registerAdd">
			
			<form action="register.do" method="post">
			<h3>회원 정보 추가</h3>
			<input type="text" name="id" placeholder="아이디입력"> <input
				type="password" name="pass" placeholder="비밀번호입력"> <input
				type="text" name="name" placeholder="이름 입력"> <input
				type="number" name="age" placeholder="나이 입력"> 
				<div class="radio_box">
				<input
				type="radio" name="gender" id="man"><label for="man">남</label> <input type="radio"
				name="gender" id="woman"><label for="woman">여</label>
				</div>
				 <input type="text" name="address"
				placeholder="주소 입력">
				<div class="button_box">
			<button>회원가입</button>
			<button>취소</button>
			</div>
				</form>
			
		</div>
	</div>
</body>
</html>