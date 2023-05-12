<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
		String x = (String)session.getAttribute("nick");
		String y = (String)session.getAttribute("id");
	%>

	<h1>
	 
		<%if(x != null){ %>		
			<%=x%>		
		<%}%>
	
	 welcome
	 </h1>
	
	<a href="/app21/member/join">회원가입</a>
	<br>
	<a href="/app21/member/login">로그인</a>
	<br>
	
	
	<%if(x != null){ %>
		<a href="/app21/member/logout">로그아웃</a>
		<br>
		<a href="/app21/member/edit?id=<%=y %>">마이페이지</a>
		<br>
		<a href="/app21/member/delete?id=<%=y %>">회원탈퇴</a>
	<% }%>
	

</body>
</html>