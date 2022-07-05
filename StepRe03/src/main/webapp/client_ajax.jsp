<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
// 1. ajax로 데이터를 호출한다. url은 01_ajax_test.jsp
// 2. data는 보내지 않는다.
// 3. type은 get
// 4. dataType은 굳이 쓸 필요 없다.
// 5. success : 
// url에 데이터를 요청한다. data는 보내지 않고, 요청 방식은 get 방식을 쓴다.
// dataType은 반환되는 데이터 타입이고 txt이므로 굳이 쓸 필요 없다.
// 요청에 성공하면 result-div에 내용을 넣어준다.
	$(function(){
		$("button").click(function(){
			$.ajax({
				url : "01_ajax_test.jsp",
				type : "get",
				success : function(r){
					$("#result").html(r);
				}
			});
		});
		
	});
</script>
</head>
<body>
	<button>ajax 요청</button>
	<div id="result"></div>
</body>
</html>