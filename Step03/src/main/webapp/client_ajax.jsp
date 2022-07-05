<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax client</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			// 1. ajax로 데이터를 호출한다. url은 01_ajax_test.jsp
			// 2. data는 보내지 않는다.
			// 3. type은 get
			// 4. dataType은 굳이 쓸 필요 없다.
			// 5. success : 
			// url에 데이터를 요청한다. data는 보내지 않고, 요청 방식은 get 방식을  쓴다.
			// dataType은 반환되는 데이터 타입이고 txt이므로 굳이 쓸 필요 없다.
			// 요청에 성공하면 result-div에 내용을 넣어준다.
			
			$.ajax({
				url : "01_ajax_test.jsp",
				//data는 보내지 않으므로 주석 처리
				//data :,
				
				//지금은 get이든 post든 상관없다.
				type : "get",
				
				//text이므로 굳이 json 쓸 필요없이 아무것도 안넣어도 된다.
				//dataType: "",
				
				success:function(r){
					$("#result").html(r);
				}
			
			});
		});
	});
</script>
</head>
<body>
	<button>ajax 요청</button>
	<!-- 버튼 누르면 result에 값을 받아온다. -->
	<div id="result"></div>
</body>
</html>