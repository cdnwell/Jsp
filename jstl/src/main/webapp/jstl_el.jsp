<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 접두사 설정 : c, 원하는 것 아무거나 가능 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h2>el 태그 테스트</h2>
	<p>request에 저장된 내용은 requestScope를 사용해서 뽑음</p>
	<!-- 더 간단하게 변수 값을 불러올 수 있게 되었다. request 영역 저장된 값 뽑기 -->
	<p>age : ${requestScope.age},${requestScope.age+10}</p>
	<p>session에 저장된 내용은 sessionScope를 사용해서 뽑음</p>
	<p>msg : ${sessionScope.msg}</p>
	<p>session에 저장된 객체 dto를 뽑음</p>
	<p>id:${sessionScope.dto.id}</p>
	<p>pass:${sessionScope.dto.pass }</p>
	<p>name:${sessionScope.dto.name }</p>
	<p>age:${sessionScope.dto.age }</p>
	<p>gender:${sessionScope.dto.gender }</p>
	<p>point:${sessionScope.dto.point }</p>
	<p>grade:${sessionScope.dto.grade }</p>
	<p>toString:${sessionScope.dto.toString() }</p>
	<h2>jstl 테스트</h2>
	<!-- 변수를 만들기, set : 변수 만들어서 데이터 초기화 -->
	<!-- jstl에서 변수 만들고 데이터를 넣어 줌 -->
	<c:set var="tnum" value="10000" />
	<!-- out : 해당 데이터 출력 -->
	<p><c:out value="${tnum}" />, ${tnum }</p>
	<!-- if문 : test가 조건식, else나 else if는 없다 -->
	<p>if문</p>
	<c:if test="${requestScope.age < 20}">
		<p>미성년자 입니다.</p>
	</c:if>
	<c:if test="${requestScope.age >= 20}">
		<p>성인 입니다.</p>
	</c:if>
	<p>여러개 조건문</p>
	<!-- 태그 두 종류 들어감, when = if, else if, otherwise = else -->
	<c:choose>
		<c:when test="${requestScope.age >= 20 && requestScope.age < 30 }">
			<p>20대 입니다.</p>
		</c:when>
		<c:when test="${requestScope.age >= 30 && requestScope.age < 40 }">
			<p>30대 입니다.</p>
		</c:when>
		<c:otherwise>
			<p>40대 이상입니다.</p>
		</c:otherwise>
	</c:choose>
	<p>반복문 - 시작값, 종료값, 증감값 설정해서 반복</p>
	<ul>
		<c:forEach var="i" begin="1" end="10">
			<li>${i}</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="i" begin="1" end="10" step="2">
			<li>${i}</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="m" items="${requestScope.list }">
			<li>${m.toString() }</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="i" begin="2" end="10" step="2">
			<li>${i }</li>
		</c:forEach>
	</ul>
	<!-- 주석 달 때 화면에 출력되는 부분에 주석을 넣어주어야 한다. 아니면 에러 발생. -->
</body>
</html>