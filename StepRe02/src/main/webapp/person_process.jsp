<%@page import="vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//[문제]
	// 1. 매개변수 name과 age를 각각 Person 객체 p 에 저장한다.
	// 2. request의 어트리뷰트에 객체 p를 저장한다.
	// 3. person_result.jsp에 forward 한다.
	
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	
	Person p = new Person(name, age);
	
	request.setAttribute("person", p);
	
	request.getRequestDispatcher("person_result.jsp").forward(request, response);
	
%>