<%@page import="view.Person"%>
<%@page import="org.omg.CORBA.IDLTypeOperations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	Person p = new Person(name,age);
	request.setAttribute("person",p);
	request.getRequestDispatcher("person_result.jsp").forward(request,response);
%>