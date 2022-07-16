<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse : collapse;
		margin : 10px auto;
	}
	td,th{
		padding : 10px 20px;
		border : 1px solid black;
	}	
	
</style>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>아이디</th>
				<th>닉네임</th>
				<th>조회수</th>
				<th>작성일</th>
				<th>추천</th>
				<th>비추천</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${requestScope.board_dto != null }">
				<tr>	
					<td>${requestScope.board_dto.bno }</td>
					<td>${requestScope.board_dto.title }</td>
					<td>${requestScope.board_dto.writer }</td>
					<td>${requestScope.board_dto.nick }</td>
					<td>${requestScope.board_dto.bcount }</td>
					<td>${requestScope.board_dto.bdate }</td>
					<td>${requestScope.board_dto.like }</td>
					<td>${requestScope.board_dto.hate }</td>
				</tr>
				<tr>
					<td colspan="8">글 내용</td>
				</tr>
				<tr>
					<td colspan="8">${requestScope.board_dto.content }</td>
				</tr>
				<tr>
					<td colspan="8">
						<c:if test="${requestScope.board_dto.writer.equals(sessionScope.dto.id)}">
							<div class="buttons">
								<button>삭제</button>
								<button>수정</button>
							</div>
						</c:if>
					</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</body>
</html>