<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- [풀이1]javascript로 처리 -->
<%
String id = request.getParameter("id");
String pass = request.getParameter("pass");
if(id.equals("admin") && pass.equals("1234") ){
	out.write("<script>location.href='login_success.jsp'</script>");
	%>
	<jsp:forward page="login_success.jsp"></jsp:forward>
	<%	
}else{
	out.write("<script>location.href='login_fail.jsp'</script>");
	%>
	<jsp:forward page="login_fail.jsp"></jsp:forward>
	<%
}
%>