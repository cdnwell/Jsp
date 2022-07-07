<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.dto == null }">
		<c:redirect url="index.jsp"/>
	</c:if>
	<div id="container">
		<div class="login_box">
			<p>${sessionScope.dto.name }님이 로그인하셨습니다.</p>
			<p><a href="logout.do">로그아웃</a> | <a href="update_view.jsp">정보수정</a> </p>
		</div>
		<nav>
			<ul>
				<li><a href="main.jsp">홈</a></li>
				<li><a href="memberList.do">회원목록</a></li>
				<li><a href="register.jsp">회원추가</a></li>
			</ul>
		</nav>
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>나이</th>
					<th>성별</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${sessionScope.list }">
					<tr>
						<td>${m.id }</td>
						<td>${m.name }</td>
						<td>${m.age }</td>
						<td>${m.gender }</td>
						<td>${m.address }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
</body>
</html>