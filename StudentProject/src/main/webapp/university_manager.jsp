<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학적관리 시스템</title>
    <style>
        header{
            width: 1200px;
            margin: 0 auto;
        }
        section{
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            width: 1200px;
            margin: 0 auto;
        }
        .table_left{
            width: 400px;
        }
        .table_right{
            width: 400px;
        }  
    </style>
</head>
<body>
	<c:if test="sessionScope.dto.status == 0">
		<script>alert('');</script>
	</c:if>
    <header>
        <h1>학적관리 시스템에 로그인 하셨습니다.</h1>
        <p>로그인 정보 : ${sessionScope.dto.name} ${sessionScope.dto.position} <a href="logout.do">로그아웃</a></p>
    </header>
    <hr>
    <section>
        <table class="table_left">
            <tr>
                <th>학과번호</th>
                <th>학과명</th>
                <th></th>
            </tr>
            <c:forEach var="m" items="sessionScope.major_list">
                <tr>
                    <td>
                        ${m.mno}
                    </td>
                    <td>
                        ${m.mname}
                    </td>
                    <td>
                        <a href="update.do">수정</a> / 
                        <a href="delete.do">삭제</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <table class="table_right">
            <tr>
                <td colspan="4">
                    <form action="search.do" method="get">
                        <select name="kind">
                            <option value="">
                                학번
                            </option>
                        </select>
                        <input type="text" name="search">
                        <button>검색</button>
                    </form>
                </td>
            </tr>
            <tr>
                <th>학번</th>
                <th>이름</th>
                <th>학과</th>
                <th>평점</th>
            </tr>
            <c:forEach var="i" items="sessionScope.list">
                <tr>
                    <td>${i.sno}</td>
                    <td>${i.name}</td>
                    <td>${i.major}</td>
                    <td>${i.score}</td>
                </tr>
            </c:forEach>
        </table>
    </section>
</body>
</html>