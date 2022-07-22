<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .container {
            width: 1200px;
            margin: 0 auto;
            text-align: center;
        }
        .result{
        	display : flex;
        	flex-direction : row;
        	justify-content: center;
        }
        .result table{
        	text-align : center;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		$(".product_no").keyup(function(){
			var proNo = $(".product_no");
			if(proNo.val().length>12){
				proNo.val(proNo.val().substring(0,12));
			}
		});
		$(".product_name").keyup(function(){
			var proName = $(".product_name");
			if(proName.val().length>20){
				proName.val(proName.val().substring(0,20));
			}
		});
		$(".maker").keyup(function(){
			var maker = $(".maker");
			if(maker.val().length>20){
				maker.val(maker.val().substring(0,20));
			}
		});
		
		$("#frm").submit(function(e){
			e.preventDefault();
			var d = $(this).serialize();
			console.log(d);
			$.ajax({
				url : "insertProduct.do",
				data : d,
				type : "get",
				dataType : "json",	//받을 데이터 타입
				success : function(r){
					//데이터 등록이 완료되면 결과값으로 현재 저장된 모든 영화 정보를 읽어와서
					//container에 출력
					var tag = "<table>";
					for(i=0;i<r.length;i++){
						tag += "<tr>";
						tag += "<td>" + r[i].product_no + "</td>";
						tag += "<td>" + r[i].product_name + "</td>";
						tag += "<td>" + r[i].maker + "</td>";
						tag += "<td>" + r[i].price + "</td>";
						tag += "<td>" + r[i].ea + "</td>";
						tag += "</tr>";
					}
					tag += "</table>";
					$(".result").html(tag);
				},
				error : function(xhr,text,error){
					//경고창으로 에러 메세지를 출력
					//등록에 실패하는 경우 숫자를 넣어야 하는데 글자를 넣은 경우
					console.log(xhr.status, xhr.responseText);
					alert(xhr.responseText);
				}
			});
		});
	});
</script>
</head>

<body>
    <div class="container">
        <form id="frm">
            <input type="number" name="product_no" class="product_no" placeholder="상품번호 입력" min="0">
            <input type="text" name="product_name" class="product_name" placeholder="상품명 입력">
            <input type="text" name="maker" class="maker" placeholder="제조사 입력">
            <input type="number" name="price" class="price" placeholder="금액 입력" min="0">
            <input type="number" name="ea" class="ea" placeholder="재고 개수 입력" min="0">
            <button>상품 등록</button>
        </form>
        <hr>
    </div>
	<div class="result">
	</div>
</body>

</html>
</html>