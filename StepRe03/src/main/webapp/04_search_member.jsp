<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		$("button").click(function(){
			var d = "kind="+$("select").val()+"&search="+%("input").val();
			$.ajax({
				url : "member_search_ajax.jsp",
				data : d,
				type : "get",
				dataType : "json",
				success : function(r){
					
				}
			});
		});
	});
</script>
</head>
<body>
	<form>
		<select name="kind">
			<option value="id">아이디</option>
			<option value="name">이름</option>
			<option value="gender">성별</option>
		</select>
		<input type="text" name="search" placeholder="검색어를 입력하세요">
		<button>전송</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>암호</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
		</tbody>		
	</table>
</body>
</html>