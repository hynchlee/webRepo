<%@page import="javax.crypto.spec.IvParameterSpec"%>
<%@page import="com.kh.app.member.MemberVo"%>
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
	
	<%
		MemberVo vo = (MemberVo)request.getAttribute("loginMember");
	%>
	
	<form action="/app21/member/edit" method="post">
		
		아이디 <input type="text" name="memberId" value="<%=vo.getMemberId()%>">
		<br>
		비밀번호 <input type="password" name="memberPwd" value="<%=vo.getMemberPwd()%>">
		<br>
		닉네임 <input type="text" name="memberNick" value="<%=vo.getMemberNick()%>">
		<br>
		<input type="submit">
		
	</form>

</body>
</html>