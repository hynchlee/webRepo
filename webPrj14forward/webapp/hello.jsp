<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="com.kh.app.test.TestServlet"%>
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
		String temp = (String)(request.getAttribute("result"));
	%>

	<h1><%=temp %>님 dd환영합니다.</h1>

</body>
</html>