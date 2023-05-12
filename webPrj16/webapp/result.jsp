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
		boolean joinOk = (boolean)request.getAttribute("k01");
	%>

	<%if(joinOk){%>
	<h1>회원가입 성공fd!</h1>
	<%}else{%>	
	<h1>회원가입 실패df!</h1>
	<%} %>
	
		
	
	
</body>
</html>