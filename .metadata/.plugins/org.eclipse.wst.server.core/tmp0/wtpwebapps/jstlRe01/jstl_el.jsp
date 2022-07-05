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
	<h2>el 태그 테스트</h2>
	<p>request에 저장된 내용은 requestScope로 뽑음</p>
	<p>age : ${requestScope.list.get(0).age }</p>
	<p>name : ${requestScope.list.get(0).name }</p>	
	<hr>
	<p>메세지 : ${sessionScope.msg }</p>
	<p>age : ${sessionScope.dto.age }</p>
	<p>name : ${sessionScope.dto.name }</p>
	<p>id : ${sessionScope.dto.id }</p>
	<p>pass : ${sessionScope.dto.pass }</p>
	<p>gender : ${sessionScope.dto.gender }</p>
	<p>point : ${sessionScope.dto.point }</p>
	<p>grade : ${sessionScope.dto.grade }</p>
	<p>toString : ${sessionScope.dto.toString() }</p>
	<hr>
	<h2>jstl 테스트</h2>
	<c:set var="tnum" value="10000" />
	<p><c:out value="${tnum }" />, ${tnum }</p>
	<p>if문</p>
	<c:if test="${requestScope.age < 20 }">
	<p>미성년자입니다.</p>
	</c:if>
	<c:if test="${requestScope.age >=20 }">
	<p>성인입니다.</p>
	</c:if>
	<hr>
	<p>여러개 조건문</p>
	<c:choose>
		<c:when test="${requestScope.age >= 20 && requestScope.age < 30 }">
			<p>20대입니다.</p>
		</c:when>
		<c:when test="${requestScope.age>= 30 && requestScope.age <40 }">
			<p>30대입니다.</p>
		</c:when>
		<c:otherwise>
			<p>40대 이상입니다.</p>
		</c:otherwise>
	</c:choose>
	<hr>
	<p>반복문 - 시작값, 종료값, 중간값 설정해서 반복</p>
	<ul>
		<c:forEach var="i" begin="1" end="10">
			<li>${i }</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="i" begin="2" end="10" step="2">
			<li>${i }</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="m" items="${requestScope.list }">
			<li>${m.toString() }</li>
		</c:forEach>
	</ul>
	<ul> 
		<c:forEach var="m" items="${requestScope.list }">
			<li>${m.toString() }</li>
		</c:forEach>
	</ul>
</body>
</html>