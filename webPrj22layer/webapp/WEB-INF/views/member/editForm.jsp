<%@page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#wrap{
		width: 400px;
		display: grid;
		grid-template-columns: 1fr 2fr;
	}

	#wrap>div{
		display: flex;
		justify-content: center;
	}
	#wrap>div:last-child{
		grid-column: span 2;
	}

	#wrap>div:last-child>input{
		width: 60%;
		
	}
</style>
</head>
<body>

	<%
		MemberVo dbMember = (MemberVo)request.getAttribute("dbMember");
	%>

	<h1>회원정보 수정</h1>
	<form action="/app22/member/edit" method="post">
		<div id="wrap">
			<div></div>
			<div><input type="hidden" name="memberNo" value="<%=dbMember.getNo()%>"></div>
			
			<div>아이디</div>
			<div><input type="text" name="memberId" readonly value="<%=dbMember.getId() %>"></div>
			
			<div>비밀번호</div>
			<div><input type="password" name="memberPwd" value="<%=dbMember.getPwd()%>"></div>
			
			<div>닉네임</div>
			<div><input type="text" name="memberNick" value="<%=dbMember.getNick()%>"></div>
			
			<div><input type="submit" value="수정하기"></div>
		</div>
	</form>
	
	<br>
	<a href="/app22/member/del">회원탈퇴</a>

	
</body>
</html>