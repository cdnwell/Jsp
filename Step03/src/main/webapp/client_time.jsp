<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			$.ajax({
				url : "02_ajax_json.jsp",
				//data는 보내지 않으므로 주석 처리
				//data :,
				
				//지금은 get이든 post든 상관없다.
				type : "get",
				
				//text로 먼저 받아서 출력을 한 후 json으로 바꿀 것
				dataType: "json",
				
				success:function(r){
					var str = r.year +"/";
					str += r.month + "/"+r.date +" "+r.hour + ":" + r.minute
					+":"+r.second;
					$("#result").html(str);
				}
			
			});
		});
	});
</script>
</head>
<body>
	<button>현재 날짜 시간 요청</button>
	<!-- 버튼 누르면 result에 값을 받아온다. -->
	<div id="result"></div>
</body>
</html>