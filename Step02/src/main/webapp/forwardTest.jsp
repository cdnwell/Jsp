<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- html 태그 없이도 출력 가능하다. -->
<%=request.getParameter("name")%>
<%=request.getParameter("hobby")%>
<%
	//javascript로 이동
	//client에게 전송된 다음 실행
	out.write("<script>alert('안녕하세요');</script>");
	//out.write("location.href='forwardResult.jsp'</script>");
%>
<!-- 서버쪽에서 클라이언트에게 전송되기전에 실행, action, 경고창이 뜨지 않는다. -->
<jsp:forward page="forwardResult.jsp"></jsp:forward>