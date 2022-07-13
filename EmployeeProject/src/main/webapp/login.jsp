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
        form {
            margin: 100px auto;
            display: flex;
            flex-direction: column;
            width: 300px;
            text-align: center;
        }

        button {
            margin-top: 10px;
            width: 60px;
            align-self: center;
        }
    </style>
</head>

<body>
    <form action="login.do" method="post">
        <h2>XX회사 인사관리시스템</h2>
        <div>
            이름 : <input type="text" name="name">
        </div>
        <div>
            사번 : <input type="text" name="eno">
        </div>
        <button>로그인</button>
    </form>
</body>

</html>