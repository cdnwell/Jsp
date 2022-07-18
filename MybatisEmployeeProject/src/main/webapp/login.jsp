<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>인사 관리 시스템</title>
    <style>
        form{
            margin: 100px auto;
            display: flex;
            flex-direction: column;
            text-align: center;
        }
        button{
            align-self: center;
            width: 70px;
        }
    </style>
</head>
<body>
    <form action="login.do" method="post">
        <h2>XX회사 인사관리시스템</h2>
        <p>이름 : <input type="text" name="name"></p>
        <p>사번 : <input type="text" name="eno"></p>
        <button>로그인</button>
    </form>
</body>
</html>