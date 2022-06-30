<%@page import="vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%
	// 이름 나이 읽어옴
	// Person 생성
	// ctrl+space 자동완성 > 위에를 잘 살펴보기
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	
	//jsp도 사실 클래스다, 변수타입처럼 쓸 수 있음
	//@page > 현재 페이지에서 사용할 설정
	//person클래스 읽어오겠다. < page import="vo.Person"
	Person p = new Person(name,age);
	//setAttribute 두번째 매개변수는 object인데 어떤 것이든 저장 가능하다는 의미
	request.setAttribute("person", p);
	//person_result.jsp로 이동(request 내용 유지해야 하므로 forward로 이동해야 한다.)
	
	request.getRequestDispatcher("person_result.jsp").forward(request, response);
	
	// [문제]
	// 1. 매개변수 name과 age를 각각 Person 객체 p 에 저장한다.
	// 2. request의 어트리뷰트에 객체 p를 저장한다.
	// 3. person_result.jsp에 forward 한다.
	
%>