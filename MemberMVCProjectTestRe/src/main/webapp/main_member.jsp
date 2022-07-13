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
	<div class="container">
		<jsp:include page="template/header.jsp"></jsp:include>
		<table>
            <caption>멤버 리스트</caption>
            <thead>
                <tr>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>나이</th>
                    <th>성별</th>
                    <th>주소</th>
                    <th>비고</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="m" items="${sessionScope.m_list}">
                    <tr>
                        <td><a href="updateView.do?id=${m.id }">${m.id}</a></td>
                        <td>${m.name}</td>
                        <td>${m.age}</td>
                        <td>${m.gender}</td>
                        <td>${m.address}</td>
                        <td><a href="memberDelete.do?id=${m.id }">삭제</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
	</div>
</body>
</html>