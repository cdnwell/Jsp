<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.container{
		width : 1200px;
		margin : 0px auto;
		text-align : center;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	function limit_12() {
        var pno = $(this); 
		if(pno.val().length > 12)
			pno.val(pno.val().substring(0,12));
	}
    function limit_20() {
        var point = $(this);
        if(point.val().length > 20)
            point.val(point.val().substring(0,20));
    }
	$(function(){
		$(".product_no").keyup(limit_12);
		$(".product_name").keyup(limit_20);
        $(".maker").keyup(limit_20);
		$("#frm").submit(function(e){
            e.preventDefault();
            var d = $(this).serialize();
            console.log(d);
            $.ajax({
                url : 'insertProduct.do',
                data : d,
                type : 'get',
                dataType : 'json',
                success : function(r){
                    console.log(r);
                },
                error : function(xhr,textstatus,error){
                    console.log(xhr.responseText);
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