<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	
	<form action="/app19/member/login" method="post">
		<input type="text" name="memberId" placeholder="아이디">
		<br>
		<input type="password" name="memberPwd" placeholder="비번">
		<br>
		<input type="submit">
	</form>
</body>
</html>