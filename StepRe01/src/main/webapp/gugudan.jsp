<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int dan = Integer.parseInt(request.getParameter("dan"));
%>
<h2><%=dan %>단</h2>
<%
	for(int i = 1;i<10;i++){
%>
<%=dan%> * <%=i%> = <%=dan*i%> <br>
<% 
	}
%>
