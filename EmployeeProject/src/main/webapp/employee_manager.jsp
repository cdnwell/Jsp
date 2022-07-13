<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        header {
            width: 1200px;
            margin: 0px auto;
        }

        section {
            width: 1200px;
            margin: 0px auto;
            text-align: center;
        }

        table {
            margin: 0px auto;
        }

        td,
        th {
            padding: 10px;
        }

        th {
            padding-top: 30px;
        }
        
        .update{
        	border : none;
        	background-color : white;
        	text-decoration : underline;
        	color : blue;
        	font-size : 16px;
        	cursor : pointer;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
    </script>
</head>

<body>
	<c:if test="${sessionScope.dto.position.equals('사원') || sessionScope.dto.position.equals('주임')
				|| sessionScope.dto.position.equals('대리')}">
		<script>
		alert('로그인 권한이 없습니다.');
		history.back();
		</script>
	</c:if>
    <header>
        <h1>인사관리 시스템에 로그인 하셨습니다.</h1>
        <p>로그인 정보 : ${sessionScope.dto.name } ${sessionScope.dto.position } <a href="logout.do">로그아웃</a></p>
    </header>
    <hr>
    <section>
        <form action="search.do" method="get" class="search_box">
            <select name="kind">
                <option value="name">이름</option>
                <option value="eno">사번</option>
                <option value="department">부서</option>
            </select>
            <input type="text" name="search">
            <button>검색</button>
        </form>

        <table>
            <thead>
                <tr>
                    <th>사번</th>
                    <th>이름</th>
                    <th>부서</th>
                    <th>직급</th>
                    <th>연봉</th>
                    <th>비고</th>
                </tr>
            </thead>
            <tbody>
            	<form action="register.do" method="post" class="table_box">
	                <tr>
	                    <td>
	                        <input type="text" name="eno" id="eno" placeholder="사번을 입력하세요.4자리">
	                    </td>
	                    <td>
	                        <input type="text" name="name" placeholder="이름을 입력하세요">
	                    </td>
	                    <td>
	                        <input type="text" name="department" placeholder="부서를 입력하세요">
	                    </td>
	                    <td>
	                        <select name="position">
	                            <option value="사원">사원</option>
	                            <option value="주임">주임</option>
	                            <option value="대리">대리</option>
	                            <option value="과장">과장</option>
	                            <option value="차장">차장</option>
	                            <option value="부장">부장</option>
	                            <option value="사장">사장</option>
	                        </select>
	                    </td>
	                    <td>
	                        <input type="number" name="salary" placeholder="연봉을 입력하세요">
	                    </td>
	                    <td>
	                        <button id="register_btn">사원등록</button>
	                    </td>
	                </tr>
            	</form>
            	<c:forEach var="m" items="${sessionScope.list }">
            	<form action="update.do" method="post">
                <tr>
                    <td>
                        ${m.eno }
                    </td>
                    <td>
                        <input type="text" name="name" value="${m.name }" readonly>
                    </td>
                    <td>
                        <input type="text" name="department" value="${m.department }" readonly>
                    </td>
                    <td>
                        <select disabled>
                            <option value="사원" 
                            	<c:if test="${m.position.equals('사원') }">
                            		selected
                            	</c:if>
                            >사원</option>
                            <option value="주임"
                            	<c:if test="${m.position.equals('주임') }">
                            		selected
                            	</c:if>
                            >주임</option>
                            <option value="대리"
                            	<c:if test="${m.position.equals('대리') }">
                            		selected
                            	</c:if>
                            >대리</option>
                            <option value="과장"
                            	<c:if test="${m.position.equals('과장') }">
                            		selected
                            	</c:if>
                            >과장</option>
                            <option value="차장"
                            	<c:if test="${m.position.equals('차장') }">
                            		selected
                            	</c:if>
                            >차장</option>
                            <option value="부장"
                            	<c:if test="${m.position.equals('부장') }">
                            		selected
                            	</c:if>
                            >부장</option>
                            <option value="사장"
                            	<c:if test="${m.position.equals('사장') }">
                            		selected
                            	</c:if>
                            >사장</option>
                        </select>
                    </td>
                    <td>
                        <input type="number" name="salary" value="${m.salary }" readonly>
                    </td>
                    <td>
                        <button class="update">수정</button> / <a href="delete.do?eno=${m.eno }">삭제</a>
                    </td>
                </tr>
                </form>
                </c:forEach>
            </tbody>
        </table>

    </section>
</body>

</html>