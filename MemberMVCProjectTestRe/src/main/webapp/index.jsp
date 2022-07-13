<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        form{
            width: 300px;
            margin: 50px auto;
            display: flex;
            flex-direction: column;
            text-align: center;
        }

        input{
            padding: 6px;
            margin-top: 5px;
        }

        button{
            margin-top: 5px;
            border: none;
            height: 30px;
            background-color: darkorange;
            color: white;
            font-weight: bold;
            border-radius: 5px;
        }

    </style>
</head>
<body>
    <form action="login.do" method="post">
        <h2>로그인 상태창</h2>
        <input type="text" name="id" placeholder="아이디를 입력해주세요">
        <input type="password" name="passwd" placeholder="비밀번호를 입력해주세요">
        <button>로그인</button>
    </form>
</body>
</html>