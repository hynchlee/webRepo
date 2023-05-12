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

	<h1>홈페이지</h1>
	
	<input type="text" name="msg" placeholder="메세지를 입력하세요">
	<br>
	<button id="btn01">ajax 요청 보내기</button>
	
	<script>
		const btn01 = document.querySelector('#btn01');
		btn01.addEventListener('click',function () {
			const msg = document.querySelector('input[name=msg]').value;
			$.ajax({
				url : "/app27/test",
				method : "get",
				data : {
					m : msg
				},
				success : function(x) {
					console.log("성공")
					console.log(x)
				},
				error : function () {
					console.log("통신 실패")	
				}
			});
		})
	</script>

</body>
</html>