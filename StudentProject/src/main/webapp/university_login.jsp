<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학적 관리 프로그램</title>
    <style>
        form{
            margin: 100px auto;
            text-align: center;
            display: flex;
            flex-direction: column;
            width: 300px;
        }
        input{
            width: 200px;
            margin: 5px;
            padding: 5px;
        }
        button{
            margin: 5px;
            width: 100px;
        }
        span{
            margin: 5px;
        }
    </style>
</head>
<body>
    <form action="login.do" method="post">
        <span>xx대학 학적 관리 프로그램</span>
        <span>허가된 교직원만 접근할 수 있습니다.</span>
        <input type="text" name="id" placeholder="아이디를 입력하세요">
        <input type="password" name="pass" placeholder="암호를 입력하세요">
        <button>로그인</button>
    </form>
</body>
</html>