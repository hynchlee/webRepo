<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원정보 수정</h1>
	
	<form action="/app/member/join" method="post">
        이름 : <input type="text" name="memberName">
        <br>
		아이디   : <input type="text" name="memberId" placeholder="아이디를 입력하세요">
        <br>
        비밀번호 : <input type="password" name="memberPwd" placeholder="비밀번호를 입력하세요">
        <br>
        암호확인 : <input type="password"placeholder="비밀번호를 입력하세요">
        <br>
        이메일 : <input type="email" name="memberEmail">
        <br>
        전화번호 : <input type="number" name="memberPhone">
        <br>
        등급 : 
        일반회원 <input type="radio" name="memberGrade" value="N">
        관리자 <input type="radio" name="memberGrade" value="Y">
        <br>
        <br>
        <input type="submit" value="회원가입">
	</form>

</body>
</html>