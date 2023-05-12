<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원가입</h1>
	
	<form action="/app17/member/join" method="POST">
		<input type="text" name="memberId" placeholder="아이디를 입력하세요">
		<br>	
		<input type="password" name="memberPwd" placeholder="비밀번호를 입력하세요">
		<br>	
		<input type="text" name="memberNick" placeholder="니네임을 입력하세요">
		<br>
		<input type="submit" value="회원가입">	
	</form>

</body>
</html>