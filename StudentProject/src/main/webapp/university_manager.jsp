<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학적관리 시스템</title>
    <style>
        header {
            width: 1200px;
            margin: 0 auto;
        }

        section {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            width: 1200px;
            margin: 0 auto;
        }

        .table_left {
            width : 550px;
            align-self: flex-start;
        }
		
		.table_left button{
			width : 50px; 
		}
		
		.btn_td{
			width : 100px;
		}
		
        .table_right {
            width: 550px;
            text-align : center;
        }
    </style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(function(){
			$(".update_anchor").click(function(){
				var d = "mname="+$(this).parent().parent().find("input").val();
				d += "&mno="+$(this).parent().parent().find("td:first-child").html().trim();
				$.ajax({
					url : "update.do",
					data : d,
					type : "get",
					success : function(r){
						if(r == "1")
							alert("수정이 완료되었습니다.");
						else
							alert("수정에 실패하였습니다.");
						location.href="main.do";
					}
				});
			});
			$(".delete_anchor").click(function(){
				var d = "mno="+$(this).parent().parent().find("td:first-child").html().trim();
				$.ajax({
					url : "delete.do",
					data : d,
					type : "get",
					success : function(r){
						if(r == "1")
							alert("삭제가 완료되었습니다.");
						else
							alert("삭제에 실패하였습니다.");
						location.href="main.do";
					}
				});
			});
		});
	</script>
</head>
<body>
    <c:choose>
        <c:when test="${sessionScope.dto.status == 0}">
            <span>권한이 없습니다. <a href="logout.do">로그아웃</a></span><br>
            <span>접근이 허가된 교직원만 접근하실 수 있습니다.</span>
        </c:when>
        <c:otherwise>
            <header>
                <h1>학적관리 시스템에 로그인 하셨습니다.</h1>
                <p>로그인 정보 : ${sessionScope.dto.name} ${sessionScope.dto.position} <a href="logout.do">로그아웃</a>
                </p>
            </header>
            <hr>
            <section>
                <table class="table_left">
                    <tr>
                        <th>학과번호</th>
                        <th>학과명</th>
                        <th></th>
                    </tr>
                    <form action="register.do" method="get">
                        <tr>
                            <td>
                                <input type="text" name="mno">
                            </td>
                            <td>
                                <input type="text" name="mname">
                            </td>
                            <td class="btn_td">
                                <button>등록</button>
                            </td>
                        </tr>
                    </form>
                    <c:forEach var="m" items="${sessionScope.major_list}">
                        <tr>
                            <td>
                                ${m.mno}
                            </td>
                            <td>
                            	<input type="text" value="${m.mname}">
                            </td>
                            <td>
                                <a href="#" class="update_anchor">수정</a> /
                                <a href="#" class="delete_anchor">삭제</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <table class="table_right">
                    <tr>
                        <td colspan="4">
                            <form action="search.do" method="get">
                                <select name="kind">
                                    <option value="name">
                                        이름
                                    </option>
                                    <option value="sno">
                                    	학번
                                    </option>
                                    <option value="major">
                                        전공
                                    </option>
                                </select>
                                <input type="text" name="search">
                                <button>검색</button>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <th>학번</th>
                        <th>이름</th>
                        <th>학과</th>
                        <th>평점</th>
                    </tr>
                    <c:forEach var="i" items="${sessionScope.list}">
                        <tr>
                            <td>${i.sno}</td>
                            <td>${i.name}</td>
                            <td>${i.major}</td>
                            <td>${i.score}</td>
                        </tr>
                    </c:forEach>
                </table>
            </section>
        </c:otherwise>
    </c:choose>
</body>
</html>