<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int n1 = Integer.parseInt(request.getParameter("n1"));
int n2 = Integer.parseInt(request.getParameter("n2"));
String op = request.getParameter("op");
int result = 0;
switch(op){
case "+":
	result = n1+n2;
	break;
case "-":
	result = n1-n2;
	break;
case "*":
	result = n1*n2;
	break;
case "/":
	result = n1/n2;
	break;
case "%":
	result = n1%n2;
	break;
default:
	result = (int)Math.pow(n1,n2);		
}
%>
결과 : <%=result%>