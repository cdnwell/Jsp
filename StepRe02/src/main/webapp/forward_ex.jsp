<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 1. data ���� �޾ƿ���
	// 2. attribute�� result Ű�� request_(+param : ����) �� �����ϱ�
	// 3. getRequestDispatcher �޼���
	// 3-1. RequestDispatcher Ŭ����
	// 4. forward �޼���
	
	String data = request.getParameter("data");
	request.setAttribute("result", "request_"+data);
	RequestDispatcher dispatcher = request.getRequestDispatcher("forward_result.jsp");
	dispatcher.forward(request, response);
%>