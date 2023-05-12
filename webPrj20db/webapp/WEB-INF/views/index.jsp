<%@page import="java.util.Map"%>
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
		Map<String , String> x = (Map)session.getAttribute("loginMember");
		String name = "";
		if(x!= null){
			name = x.get("dbNick");	
		}
		
	%>

	<h1><%=name %>환영</h1>
	
	<a href="/app20/member/logout">로그아웃</a>

	<ul>
		<li><a href="/app20/member/join">회원가입</a></li>
		<li><a href="/app20/member/login">로그인</a></li>
	</ul>
	

</body>
</html>