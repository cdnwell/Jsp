<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<div id="member_bar">
		<%
		String id = (String) session.getAttribute("id");

		if (id == null) {
		%>
		<div class="login_form">
			<form action="login_process.jsp" method="post">
				<input type="text" name="id" placeholder="아이디를 입력하세요"> 
				<input type="password" name="pass" placeholder="암호를 입력하세요">
				<button>로그인</button>
				<button id="btn_register" type="button">회원가입</button>
			</form>
		</div>
		<%
		} else {
		%>
		<div class="profile">
			<img src="resource/images/profile.png" alt="">
			<p>OOO로그인 하셨습니다.</p>
			<p>
				<a href="logout.jsp">로그아웃</a> | 정보수정
			</p>
		</div>
		<%
		}
		%>
	</div>


	<!-- 나중에 회원가입을 누르면 자바스크립트로 회원가입 페이지로 이동시키기 -->


	<div class="ad_img">
		<button class="left_arrow">
			<img src="resource/images/left_arrow.png" alt="">
		</button>
		<button class="right_arrow">
			<img src="resource/images/left_arrow.png" alt="">
		</button>
		<img src="resource/images/main_4.jpg" alt="">
	</div>
</header>
<nav>
	<ul>
		<li><a href="main.jsp">HOME</a></li>
		<li><a href="sub_page2.jsp">예약</a></li>
		<li><a href="#">펜션스토리</a></li>
		<li><a href="#">펜션소개</a></li>
		<li><a href="sub_page1.jsp">오시는길</a></li>
	</ul>
</nav>