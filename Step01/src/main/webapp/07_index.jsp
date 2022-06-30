<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>펜션</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    
</head>
<body>
<div class="flex_container">
<jsp:include page="template/pheader.jsp"></jsp:include>
<section>
    <article>
        <h2>공지사항</h2>
        <table>
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
            <tr>
                <td>5</td>
                <td>제목1</td>
                <td>2021-07-26</td>
                <td>33</td>
            </tr>
            <tr>
                <td>4</td>
                <td>제목2</td>
                <td>2021-07-25</td>
                <td>543</td>
            </tr>
            <tr>
                <td>3</td>
                <td>제목3</td>
                <td>2021-07-23</td>
                <td>331</td>
            </tr>
            <tr>
                <td>2</td>
                <td>제목4</td>
                <td>2021-07-22</td>
                <td>33</td>
            </tr>
            <tr>
                <td>1</td>
                <td>제목5</td>
                <td>2021-07-21</td>
                <td>13</td>
            </tr>
        </table>                
    </article>
    <article>
        <h2>이벤트</h2>
        <table>
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
            <tr>
                <td>5</td>
                <td>제목1</td>
                <td>2021-07-26</td>
                <td>33</td>
            </tr>
            <tr>
                <td>4</td>
                <td>제목2</td>
                <td>2021-07-25</td>
                <td>543</td>
            </tr>
            <tr>
                <td>3</td>
                <td>제목3</td>
                <td>2021-07-23</td>
                <td>331</td>
            </tr>
            <tr>
                <td>2</td>
                <td>제목4</td>
                <td>2021-07-22</td>
                <td>33</td>
            </tr>
            <tr>
                <td>1</td>
                <td>제목5</td>
                <td>2021-07-21</td>
                <td>13</td>
            </tr>
        </table>
    </article>
</section>
<jsp:include page="template/pfooter.jsp"></jsp:include>
</div>    
</body>
</html>