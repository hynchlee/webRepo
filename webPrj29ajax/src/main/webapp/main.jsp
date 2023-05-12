<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>

	<h1>메인화면</h1>

    <button onclick="f01();">AJAX로 요청 보내기</button>


    <script>

        //ajax 메소드 (==화면 새로고침 없이 요청 보내는거)//제이쿼리 방식
        $.ajax({
            url : '/app/test' ,
            method : 'post' ,  
            data : {
                'age' : '20' ,
            } ,
            success : function(x){
                alert("통신 성공 !");
                console.log(x);
            } ,
            error : function(){
                alert("통신 실패 ...");
            } ,
        });

    </script>

</body>
</html>