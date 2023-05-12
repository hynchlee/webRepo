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
		String x = (String)request.getParameter("resultMsg");
	%>

	<h1>결과페이지</h1>
	
	<h3><%=x %></h3>

</body>
</html>