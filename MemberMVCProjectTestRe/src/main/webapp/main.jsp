<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인 페이지</title>
    
</head>
<body>
    <div class="container">
        <jsp:include page="template/header.jsp"></jsp:include>
        <table>
            <caption>멤버 나이 많은 순</caption>
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
                <c:forEach var="m" items="${sessionScope.list}">
                    <tr>
                        <td>${m.id}</td>
                        <td>${m.name}</td>
                        <td>${m.age}</td>
                        <td>${m.gender}</td>
                        <td>${m.address}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>