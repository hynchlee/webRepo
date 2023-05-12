<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>정보수정</h1>

    <form action="/app24/member/edit" method="post">
        <input type="text" name="memberId"  disabled="disabled" placeholder="아이디" value="${loginMember.id }">
        <br>
        <input type="password" name="memberPwd" placeholder="비번">
        <br>
        <input type="text" name="memberNick" placeholder="닉네임" value="${loginMember.nick }">
        <br>
        <input type="submit" value="수정하기">
    </form>
    
    <a href="/app24/member/del">탈퇴하기</a>

</body>
</html>