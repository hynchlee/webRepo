<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시글 작성하기</h1>
	
	<form action="/app/board/write" method="post">
		제목 : <input type="text" name="title">
		<br>
		작성자 : <input type="text" name="writer">
		<br>
		내용 : <input type="text" name="content">
		<br>
		<button type="submit">작성하기</button>
	</form>
	
</body>
</html>