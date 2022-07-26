<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사원정보 검색 시스템</title>
    <style>
        h2{
            text-align: center;
        }
        form{
            display: flex;
            flex-direction: row;
            justify-content: center;
        }
        .result{
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
    $(function(){
        $('#frm').submit(function(e){
        	e.preventDefault();
            var d = $(this).serialize();
            console.log(d);
            $.ajax({
                url : 'search',
                data : d,
                type : 'get',
                dataType : 'json',
                success : function(r){
                    var tag = "<table>";
                    for(i = 0;i < r.length ; i++){
                        tag += "<tr>";
                        tag += "<td>"+r[i].eno +"</td>";
                        tag += "<td>"+r[i].name +"</td>";
                        tag += "<td>"+r[i].department +"</td>";
                        tag += "<td>"+r[i].position +"</td>";
                        tag += "</tr>";
                    }
                    tag += "</table>";
                    $(".result").html(tag);
                },
                error : function(xhr,text,error){
                    alert(xhr.responseText);
                }
            });
        });
    });
    </script>
</head>
<body>
    <h2>사원정보 검색 시스템</h2>
    <form id="frm">
        <select name="search" >
            <option value="eno">사번</option>
            <option value="name">이름</option>
            <option value="position">직급</option>
        </select>
        <input type="text" name="content" >
        <button>검색</button>
    </form>
    <div class="result"></div>
</body>
</html>