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
	
	<script>
		$.ajax({
			url : '/app/test',
			type : 'post',
			success : function(data){
				console.log(data);
				const obj = JSON.parse(data);
				console.log(obj);
			},
			error : function (e) {
				console.log(e);
			},
		});
	</script>

</body>
</html>