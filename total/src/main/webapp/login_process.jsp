<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("id") != null){
		//로그인이 되어있는 경우이다.
		response.sendRedirect("index.jsp");
		return;
	}
	
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	if(id.equals("admin")&&pass.equals("1234")){
		//로그인 성공
		session.setAttribute("id", id);
		response.sendRedirect("index.jsp");
	}else{
		//로그인 실패
		out.write("<script>alert('아이디와 비밀번호를 입력하세요');history.back();</script>");
	}
%>