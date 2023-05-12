<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시글 작성 중 에러 발생</h1>

	<% 
		String errorMsg = (String)request.getAttribute("errorMsg");
	%>

	<h3><%=errorMsg %>에러 발생</h3>
	
	<h3><a href="/app23">홈으로</a></h3>
 
</body>
</html>