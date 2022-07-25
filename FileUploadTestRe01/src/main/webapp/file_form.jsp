<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(function(){
            let count = 1;
            $('#plus').click(function(){
                if(count == 5) return;
                count++;
                $('form').append("<p><input type='file' name='file"+count+"'></p>");
            });
            $('#minus').click(function(){
                if(count == 1) return;
                count--;
                $('form').children('p').last().remove();
            });
        });
    </script>
</head>
<body>
    <form action="upload.do" method="post" enctype="multipart/form-data">
        <p><input type="text" name="writer" placeholder="작성자"></p>
        <p><button>업로드</button></p>
        <p><input type="file" name="file1">
            <button type="button" id="plus">+</button>
            <button type="button" id="minus">-</button>
        </p>
    </form>
</body>
</html>