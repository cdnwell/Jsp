<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입 페이지</title>
    <style>
        * {
            padding: 3px;
            margin: 0;
        }

        h3 {
            margin-top: 30px;
            margin-bottom: 10px;
            text-align: center;
        }
        h2 {
            margin: 5px 0;
        }
        p {
            font-weight: bold;
        }

        .container {
            width: 750px;
            margin: 0 auto;
            border: 1px solid #b7b7b7;
            padding: 30px;
            padding-left: calc(750px * 0.05 / 2 + 30px);
        }

        input {
            width: 95%;
            height: 40px;
            border: 0;
            border-bottom: 1px solid #979797;
            font-size: 18px;
            box-sizing: border-box;
            padding-left: 8px;
            margin: 5px 0;

            outline: none;
        }

        form>ul {
            margin-left: calc(10% / 2);
        }

        select {
            border: none;
            border-bottom: 1px solid #979797;
            border-right: 1px solid #979797;
            font-size: 17px;
            box-sizing: border-box;
            height: 45px;
            color: black;
            margin-bottom: 10px;
            outline: none;
        }



        #check_num {
            margin: 10px 0;
            width: 200px;
            border: #d4d4d4 1px solid;
            border-radius: 20px;
            background-color: white;
            height: 50px;
        }

        #submit {
            width: 95%;
            display: inline-block;
            border: none;
            background-color: #d4d4d4;
            height: 50px;
        }

        #submit:hover {
            background-color: #ffe606;
        }

        .id_box{
            display: flex;
            flex-direction: row;
            width: 95%;
        }
        .id_kacao{
            color: #676767;
            font-size: 19px;
            font-weight: bold;
            border-bottom: #979797 1px solid;
            box-sizing: border-box;
            height : 45px;
            padding-right: 10px;
        }

        
        .nick_box{
            display: flex;
            flex-direction: row;
            width: 95%;
        }
        .nick_number{
            border-bottom: 1px solid #979797;
            height: 45px;
            box-sizing: border-box;
            color: #676767;
            font-size: 19px;
            font-weight: bold;
            padding-right: 10px;
        }

    </style>
    <script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function id_check() {
            const id = $('#id');
            const id_tag = $('.id_tag');

            id_tag.css('color','red');
            if(id.val().length < 4 || id.val().length > 12){
                id_tag.html('아이디는 글자수가 4~12글자 사이로 사용하세요.');
                return false;
            }
             
            if(!isNaN(id.val())){
                id_tag.html('아이디는 숫자만 적으실 수 없습니다.');
                return false;
            }
            
            var reg = /^[A-Za-z\d]{4,12}$/

            if(!reg.test(id.val())){
                id_tag.html('아이디는 숫자와 영문자만 가능합니다.');
                return false;
            }

            id_tag.css('color','blue');
            id_tag.html('아이디가 올바르게 입력되었습니다.');
            return true;
        }
        function pass_check(){
            const pass1 = $('#pass1');
            const pass2 = $('#pass2');
            const pass_tag = $('.pass_tag');

            var reg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&^])[A-Za-z\d@$!%*#?&^]{8,20}$/;

            pass_tag.css('color','red');
            if(!reg.test(pass1.val())){
                pass_tag.html('암호는 8~20글자 영문자, 특수문자는 한 글자 이상 포함 되어야 합니다.');
                return false;
            }else if(pass1.val() != pass2.val()){
                pass_tag.html('암호가 일치하지 않습니다.');
                return false;
            }

            pass_tag.css('color','blue');
            pass_tag.html('암호가 정상적으로 입력되었습니다.');
            return true;
        }
        function name_check(){
            const name = $('#name');
            const name_tag = $('.name_tag');
            const regex = /^[가-힣]{3,5}$/;

            name_tag.css('color','red');
            if(!regex.test(name.val())){
                name_tag.html('이름은 3~5글자 한글만 쓸 수 있습니다.');
                return false;
            }

            name_tag.css('color','blue');
            name_tag.html('이름이 올바르게 입력되었습니다.');
            return true;
        }   
        function nick_check(){
            const nick = $('#nick');
            const nick_length = $('#nick').val().length;
            const nick_number = $('.nick_number');

            if(nick_length > 20){
                nick.val(nick.val().substring(0,20));
                return false;
            }

            nick_number.html(`${nick_length}/20`);
            return true;
        }
        
        function position_check(){
            const pos = $('#position');
            const pos_name = $('.pos_name');

            if(pos.val()!=0){
                const op_text = $('#position option:checked').text();
                pos_name.html(op_text);
                
                return true;
            }

            pos_name.html('');
            return false;
        }
        $(function(){
            $('#id').keyup(id_check);
            $('#pass1').keyup(pass_check);
            $('#pass2').keyup(pass_check);
            $('#name').keyup(name_check);
            $('#nick').keyup(nick_check);
            $('#position').change(position_check);
            $('#frm').submit(function(e){
                if(!id_check())
                    e.preventDefault();
                else if(!pass_check())
                    e.preventDefault();
                else if(!name_check())
                    e.preventDefault();
                else if(!nick_check())
                    e.preventDefault();
            });
        });
    </script>
    
</head>

<body>
    <h3>member</h3>
    <div class="container">
        <h2>계정 정보를 입력해 주세요</h2>
        <p>계정 이메일</p>
        <form action="register.do" method="post" id="frm">
            <div class="id_box">
                <input type="text" id="id" name="id" placeholder="아이디를 입력하세요"><span
                class="id_kacao">@member.com</span>
            </div>
            <div class="id_tag"></div>
            <ul>
                <li>입력한 메일로 계정에 로그인할 수 있습니다.</li>
                <li>한 번 만든 메일은 변경할 수 없으니, 오타가 없도록 신중히 확인해 주세요.</li>
                <li>생성한 메일로 계정과 관련한 알림을 받아볼 수 있습니다.</li>
            </ul>
            <p>비밀번호</p>
            <input type="password" id="pass1" name="passwd" placeholder="비밀번호(8~32자리)"> <br>
            <input type="password" id="pass2" placeholder="비밀번호 재입력">
            <div class="pass_tag"></div>
            <p>이름</p>
            <input type="text" id="name" name="name" placeholder="이름을 입력해주세요">
            <div class="name_tag"></div>
            <p>닉네임</p>
            <div class="nick_box">
                <input type="text" id="nick" name="nick" placeholder="닉네임을 입력하세요"><span
                class="nick_number">0/20</span>
            </div>
            <div class="pos_box">
                <select name="grade_no" id="position">
                    <option value="0">선택</option>
                    <option value="1">사원</option>
                    <option value="2">주임</option>
                    <option value="3">대리</option>
                    <option value="4">과장</option>
                    <option value="5">차장</option>
                    <option value="6">부장</option>
                    <option value="7">사장</option>
                </select>
                <span class="pos_name"></span>
            </div>
            <button id="submit">다음</button>
        </form>
    </div>
</body>

</html>