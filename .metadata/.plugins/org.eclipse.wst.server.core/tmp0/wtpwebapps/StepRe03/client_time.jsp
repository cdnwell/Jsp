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
			$.ajax({
				url : "02_ajax_json.jsp",
				type : "get",
				dataType : "json",
				success : function(r){
					//year,month,date,hour(hour_of_day),minute,second
					//r = json 객체, 객체의 각 값에 접근하기
					var str = r.year + "/" + r.month + "/" + r.date + " "
					+ r.hour + ":" + r.minute + ":" + r.second;
					$("#result").html(str);
				}
			});
		});
	});
</script>
</head>
<body>
	<button>현재 시간 요청</button>
	<div id="result"></div>
</body>
</html>