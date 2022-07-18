<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>인사관리 시스템</title>
    <style>
        header{
            width: 1200px;
            margin: 0 auto;
        }
        section{
            width: 1200px;
            margin: 0 auto;
            text-align: center;
        }
        table{
            width: 1000px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <header>
        <h2>인사관리 시스템에 로그인 하셨습니다.</h2>
        <p>로그인 정보 : ${sessionScope.dto.name} ${sessionScope.pos} <a href="logout.do">로그아웃</a> </p>
    </header>
    <hr>
    <section>
        <form action="search.do">
            <select name="kind">
                <option value="">이름</option>
            </select>
            <input type="text" name="search">
            <button>검색</button>
        </form>
        <table>
            <tr>
                <th>사번</th>
                <th>이름</th>
                <th>부서</th>
                <th>직급</th>
                <th>연봉</th>
                <th>비고</th>
            </tr>
            <c:forEach var="m" items="sessionScope.list">
                <tr>
                    <td>${m.eno}</td>
                    <td><input type="text" value="${m.name}"></td>
                    <td><input type="text" value="${m.department}"></td>
                    <td>
                        <select>
                            <option value="1"
                                <c:if test="${m.position == 1}">
                                    selected
                                </c:if>
                            >사원</option>
                            <option value="2"
                                <c:if test="${m.position == 2}">
                                    selected
                                </c:if>
                            >주임</option>
                            <option value="3"
                                <c:if test="${m.position == 3}">
                                    selected
                                </c:if>
                            >대리</option>
                            <option value="4"
                                <c:if test="${m.position == 4}">
                                    selected
                                </c:if>
                            >과장</option>
                            <option value="5"
                                <c:if test="${m.position == 5}">
                                    selected
                                </c:if>
                            >차장</option>
                            <option value="6"
                                <c:if test="${m.position == 6}">
                                    selected
                                </c:if>
                            >부장</option>
                            <option value="7"
                                <c:if test="${m.position == 7}">
                                    selected
                                </c:if>
                            >사장</option>
                        </select>
                    </td>
                    <td><input type="text" value="${m.salary}"></td>
                    <td><a href="#">수정</a> / <a href="#">삭제</a></td>
                </tr>
            </c:forEach>
        </table>
    </section>
</body>
</html>