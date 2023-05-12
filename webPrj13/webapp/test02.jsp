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
		String a = request.getParameter("a");
		String b = request.getParameter("b");
	%>
	
	<h1>a와 b의 합은<%=Integer.parseInt(a)+Integer.parseInt(b) %>입니다.</h1>

</body>
</html>