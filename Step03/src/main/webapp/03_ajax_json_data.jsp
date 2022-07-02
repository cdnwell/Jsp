<%@page import="org.json.JSONObject"%>
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
		<%
			int num = Integer.parseInt(request.getParameter("num"));
			JSONObject obj = new JSONObject();
			obj.put("num",num);
			
			out.write(obj.toString());
		%>
	});
	$("button").click(function(){
		$.ajax({
			url : "divisor_ajax.jsp",
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
	<form action="divisor_ajax.jsp">
		<input type="number" name="num">
		<button>숫자 전송</button>
	</form>
		<button id="receiver">숫자 받기</button>
	<div id="result"></div>
</body>
</html>