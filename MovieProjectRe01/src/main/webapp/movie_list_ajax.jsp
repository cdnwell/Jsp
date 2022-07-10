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
		$('button').click(function(){
			var d = "kind="+$('#kind').val()+"&search="+$('#search').val();
			$.ajax({
				url : 'search.do',
				data : d,
				type : 'get',
				dataType : 'json',
				success : function(r){
					var tag = "";
					for(i=0;i<r.length;i++){
						tag += "<tr><td>"+r[i].bno+"</td>";
						tag += "<td>"+r[i].title+"</td>";
						tag += "<td>"+r[i].openDate+"</td>";
						tag += "<td>"+r[i].count+"</td>";
						tag += "<td>"+r[i].director+"</td></tr>";
					}
					$('tbody').html(tag);
				},
				error : function(xhr, textStatus, errorThrow){
					console.log("code :",xhr.status);
					console.log("message :",xhr.responseText);
				}
			});
		});
	});
</script>
<style>

	#container{
		text-align : center;
	}

	h2{
		text-align : center;
	}
	
	table{
		border-collapse : collapse;
		margin : 0px auto;
		
	}
	
	td,th{
		border-top : 1px solid black;
		border-bottom : 1px solid black;
		width : 130px;
	}
	
</style>
</head>
<body>
	
	<div id="container">
		<h2>영화 검색 페이지</h2>
		<select id="kind">
			<option value="title">영화 제목</option>
			<option value="director">감독</option>
			<option value="year">개봉 연도</option>
		</select>
		<input type="text" placeholder="검색어 입력하세요" id="search">
		<button>검색</button>
		<hr>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>영화명</th>
					<th>개봉일</th>
					<th>누적관객수</th>
					<th>감독</th>
				</tr>
			</thead>
			<tbody></tbody>
			<tfoot>
			<tr>
			<td colspan="5">
				<c:if test="${requestScope.pagging.previousPageGroup }">
					<a href="list.do?pageNo=${requestScope.pagging.startPageOfPageGroup - 1 }">◁</a>
				</c:if>
				<c:forEach var="i" begin="${requestScope.pagging.startPageOfPageGroup }"
				end="${requestScope.pagging.endPageOfPageGroup }">
					<c:choose>
						<c:when test="${i == requestScope.pagging.currentPageNo }">
							<span class="current">${i }</span>
						</c:when>
						<c:otherwise>
							<a href="list.do?pageNo=${i }">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${requestScope.pagging.nextPageGroup }">
					<a href="list.do?pageNo=${requestScope.pagging.endPageOfGroup + 1 }">▷</a>
				</c:if>
			</td>
			</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>