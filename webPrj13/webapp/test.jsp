<%@page import="java.io.PrintWriter"%>
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
		String x = request.getParameter("id");
		String ageString = request.getParameter("age");
	%>
	
	<h1>hello</h1>
	
	<h3><%= x %> 입니다<%=ageString%></h3>
	
</body>
</html>