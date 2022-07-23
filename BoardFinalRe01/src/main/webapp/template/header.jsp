<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.dto.gradeNo == 1 }">
    <script>
        alert("로그인 권한이 없습니다.");
        history.back();
    </script>
</c:if>
<style>
    *{
        padding : 0px;
        margin : 0px;
    }
    nav{
       width: 1200px; 
       margin: 0px auto;
       text-align: center;
    }
    li{
        display: inline-block;
    }
    li > a {
        padding: 20px;
        width: 150px;
        text-align: center;
        display: inline-block;
        text-decoration: none;
        color : black;
    }
</style>
<c:if test="${sessionScope.dto.gradeNo == 7 }">
    <nav>
        <ul>
            <li><a href="main.do">홈</a></li>
            <li><a href="#">회원목록</a></li>
            <li><a href="#">회원정보 수정</a></li>
        </ul>
    </nav>
</c:if>