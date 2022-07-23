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
        section{
            width: 1200px;
            margin: 0px auto;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        table{
            border-collapse: collapse;
        }
        th, td{
            padding: 7px;
            border-top: 1px solid gray;
        }
        tfoot a:visited, tfoot a:link{
        	text-decoration : none;
        	color : black;
        }
        span{
        	color : red;
        }
    </style>
</head>

<body>
    <jsp:include page="template/header.jsp"></jsp:include>
    <section>
        <table>
            <thead>
                <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>닉네임</th>
                    <th>작성일</th>
                    <th>조회수</th>
                    <th>좋아요</th>
                    <th>싫어요</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${requestScope.list}">
                    <tr>
                        <td>${board.bno}</td>
                        <td><a href="">${board.title}</a></td>
                        <td>${board.nick}</td>
                        <td>${board.bdate}</td>
                        <td>${board.bcount}</td>
                        <td>${board.blike}</td>
                        <td>${board.bhate}</td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="7">
                        <c:if test="${requestScope.paging.previousPageGroup }">
	                        <a href="main.do?pageNo=${requestScope.paging.startPageOfPageGroup - 1 }">
	                        ◀
	                        </a>
                        </c:if>
                        <c:forEach var="i" begin="${requestScope.paging.startPageOfPageGroup }"
                         end="${requestScope.paging.endPageOfPageGroup }">
                         	<c:choose>
                         		<c:when test="${i==requestScope.paging.currentPageNo }">
                         			<span class="curPage">${i }</span>
                         		</c:when>
                         		<c:otherwise>
                         			<a href="main.do?pageNo=${i }">${i }</a> 
                         		</c:otherwise>
                         	</c:choose>
                        </c:forEach>
                        <c:if test="${requestScope.paging.nextPageGroup }">
	                        <a href="main.do?pageNo=${requestScope.paging.endPageOfPageGroup + 1 }">
	                        ▶
	                        </a>
                        </c:if>
                        <a href="board_write_view.jsp" class="btn_write">글쓰기</a>
                    </td>
                </tr>
            </tfoot>
        </table>
    </section>
</body>

</html>