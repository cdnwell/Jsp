<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="operator_result_re.jsp">
      <input type="number" name="n1">
      <select name="op">
         <option value="+">+</option>
         <option value="-">-</option>
         <option value="*">*</option>
         <option value="/">/</option>
         <option value="%">%</option>
         <option value="^">^</option>
      </select>
      <input type="number" name="n2">
      <button>계산하기</button>
   </form>
</body>
</html>