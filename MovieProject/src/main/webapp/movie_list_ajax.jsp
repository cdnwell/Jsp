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
		$('button').click(function(){
			var d;
			//form으로 묶으면 submit 이벤트가 일어나서 다음 페이지로 넘어가게 되어
			//submit 이벤트 방지를 해주어야 하기 때문에 form으로 묶지 말 것을 추천
			d = "kind="+$('#kind').val();
			d += "&search="+$('#search').val();
			$.ajax({
				url : 'search.do',
				data : d,
				type : 'get',
				dataType : 'json',
				success : function(r){
					console.log(r);
					var tag = "";
					for(i=0;i<r.length;i++){
						tag += "<tr>";
						tag += "<td>"+r[i].bno+"</td>";
						tag += "<td>"+r[i].title+"</td>";
						tag += "<td>"+r[i].openDate+"</td>";
						tag += "<td>"+r[i].count+"</td>";
						tag += "<td>"+r[i].director+"</td>";
						
						tag += "</tr>";
					}
					$('tbody').html(tag);
				},
				error : function(xhr, textStatus, errorThrow){
					console.log("code : ",xhr.status);	
					console.log("message : ",xhr.responseText);	
					console.log("error : ",errorThrow);	
					console.log("textStatus : ",textStatus);
					var tag = "<tr><td colspan='6'>"+xhr.responseText+"</td></tr>";
					$('tbody').html(tag);
				}
			});
		});
	});
</script>
<style type="text/css">
	h2{
		text-align : center;
	}
	.container{
		text-align : center;
	}
   table{
      margin: 0 auto;
      border-collapse: collapse;
   }
   thead > tr{
      border-top:1px solid black;
      border-bottom:1px double black;
   }
   tbody > tr{
      border-bottom:1px solid black;
   }
   td,th{
      padding:10px 20px;
   }
   a:link, a:visited{
   		color : black;
   		text-decoration : none;
   }
   .current{
   		color : red;
   		font-weight : bold;
   }
   tfoot td{
   		text-align : center;
   }
</style>
</head>
<body>
	<h2>영화 검색 페이지</h2>
	<div class="container">
	<select id="kind">
		<option value="title">영화 제목</option>
		<option value="director">감독</option>
		<option value="year">개봉연도</option>
	</select>
	<input type="text" id="search" placeholder="검색어 입력하세요">
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
	</table>
	</div>
</body>
</html>