<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 파라미터 값을 두개 가져온다.
	// 2. 조건을 검사하고 attribute의 id 키에 id 값을 대입한다.
	// 2-1. 로그인에 성공후 sendRedirect로 원래 페이지로 돌아간다.(상대경로)
	// 3. alert문으로 아이디와 비밀번호를 입력하세요. 문장을 띄운후 이전 페이지로 돌아간다.
	// 3-1. history.back(); <- 이전 페이지로
	
	String id = request.getParameter("id");
	int pass = Integer.parseInt(request.getParameter("pass"));
	
	if(id.equals("admin") && pass == 1234){
		session.setAttribute("id",id);
		response.sendRedirect("09_main.jsp");
	}else{
		out.write("<script>"+
			"alert('아이디와 비밀번호를 입력하세요');"+
			"history.back();"+
		"</script>");
	}
%>