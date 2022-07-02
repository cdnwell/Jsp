<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	function calculator(){
		var dat = "num="+$("input").val();
		$.ajax({
			url:"divisor_ajax.jsp",
			data:dat,
			type : "get",
			dataType : "json",
			success : function(r){
				var str = "";
				for(i=0;i<r.length;i++){
					str += "<span>"+r[i]+"</span> ";
				}
				$("#result").html(str);
			}
		});
	}
	$(function(){
		$("button").submit(calculator);
		
	});
</script>
</head>
<body>
	<form>
		<input type="number" name="num"><button type="button">전송</button>
	</form>
	<div id="result"></div>
</body>
</html>