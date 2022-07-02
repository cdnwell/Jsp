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