<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse:collapse;
		margin : 0 auto;
	}
	td{
		border : 1px solid black;
		padding : 20px;
		text-align: center;
	}
</style>
</head>
<body>
<table>
<%
	ArrayList<HashSet<Integer>> list = (ArrayList<HashSet<Integer>>)request.getAttribute("list");
	for(int i=0;i<list.size();i++){
		%>
		<tr>
		<td><%=i+1 %>번째 번호</td>
		<%
		HashSet<Integer> set = list.get(i);
		for(int j : set){
			%>
			<td><%=j %></td>
			<%
		}
		%>
		</tr>
		<%
	}
	%>
	</table>
</body>
</html>