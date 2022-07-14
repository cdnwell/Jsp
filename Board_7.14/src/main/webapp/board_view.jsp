<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		$("#btn_delete").click(function(){
			var d = "boardDelete.do?bno=${requestScope.board_dto.bno}";
			//alert(d);
			location.href=d;
		});
		$("#btn_update").click(function(){
			var d = "boardUpdateView.do?bno=${requestScope.board_dto.bno}";
			location.href=d;
		});
		$("#btn_like").click(function(){
			var d = "bno=${requestScope.board.bno}";
			$.ajax({
				url : "boardLike.do",
				data:d,
				type:"get",
				success:function(r){
					if(r == "1")
						alert("이 글을 추천하셨습니다.");
					else
						alert("이 글을 추천을 취소 하셨습니다.");
					location.reload();
				}
			});
		});
		$("#btn_hate").click(function(){
			var d = "bno=${requestScope.board.bno}";
			$.ajax({
				url : "boardHate.do",
				data:d,
				type:"get",
				success:function(r){
					if(r == "1")
						alert("이 글을 싫어요 하셨습니다.");
					else
						alert("이 글을 싫어요를 취소 하셨습니다.");
					location.reload();
				}
			});
		});
	});
</script>
</head>
<body>
	<table>
		<tr>
			<td>글번호</td>
			<td class="bno">${requestScope.board_dto.bno }</td>
		</tr>
		<tr>
			<td>제목 : </td>
			<td>${requestScope.board_dto.title }</td>
		</tr>
		<tr>
			<td>작성자 : </td>
			<td>${requestScope.board_dto.nick }</td>
		</tr>
		<tr>
			<td>조회수 : </td>
			<td>${requestScope.board_dto.bcount }</td>
		</tr>
		<tr>
			<td colspan="2">
				${requestScope.board_dto.content }
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="#" id="btn_like">좋아요 ${requestScope.board_dto.like }</a>
				<a href="#" id="btn_hate">싫어요 ${requestScope.board_dto.hate }</a>
			</td>
		</tr>
		<c:if test="${requestScope.board_dto.writer == sessionScope.dto.id }">
		<tr>
			<td colspan="2">
				<button id="btn_update">수정</button>
				<button id="btn_delete">삭제</button>
			</td>
		</tr>
		</c:if>
	</table>
</body>
</html>