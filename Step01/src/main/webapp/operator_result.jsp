<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 
if(op.equals("+")){
			result = n1 + n2;
		}else if(op.equals("-")){
			result = n1 - n2;
		}else if(op.equals("*")){
			result = n1 * n2;
		}else if(op.equals("/")){
			result = n1 / n2;
		}else if(op.equals("%")){
			result = n1 % n2;
		}else if(op.equals("^")){
			result = (int)Math.pow(n1, n2);
		}
 -->
<body>
	<%
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		String op = request.getParameter("op");
		int result = 0;
		
		switch(op){
		case "+":
			result = n1 + n2;
			break;
		case "-":
			result = n1 - n2;
			break;
		case "*":
			result = n1 * n2;
			break;
		case "/":
			result = n1 / n2;
			break;
		case "%":
			result = n1 % n2;
			break;
		case "^":
			result = (int)Math.pow(n1, n2);
			break;
		}
		
	%>
		<p><%=n1 %> <%=op %> <%=n2 %> = <%=result %></p>
</body>
</html>