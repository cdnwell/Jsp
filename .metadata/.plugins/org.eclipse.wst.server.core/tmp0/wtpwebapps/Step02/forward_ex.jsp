<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String param = request.getParameter("data");
	request.setAttribute("result","request_"+param);
	//굳이 저장하지 않고 forward 메서드를 맨 뒤에 그냥 붙여서 쓰는 것이 일반적이다.
	RequestDispatcher dispatcher = request.getRequestDispatcher("forward_result.jsp");
	//request, response 같이 보냄
	//데이터를 보내줘서 유지가 됨
	dispatcher.forward(request, response);
	//forward로 하면 url을 감추는 기능도 하긴 한다.
	
	// 1.param 변수에 data 매개변수를 받아온다(request의)
	// 2.request에 키는 result, 값은 request_+(param:변수이름)으로 값을 넣어준다.
	// 3.RequestDispatcher 객체를 생성해주고 request에서 getRequestDispatcher 메서드를 실행한다. forward_result.jsp
	// 로 이동
	// 4.forward하면서 request와 response 값을 넘겨준다.
	
%>