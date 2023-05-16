<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 전용 홈페이지</h1>
	<c:if test="${loginMember != null }">
		안녕하세요. ${loginMember.name}님 환영합니다
		<br>
		<a href="/app/member/logout">로그아웃</a>
		<a href="#">회원정보변경</a>
	</c:if>
	<c:if test="${loginMsg !=null }">
		<script>
			alert("${loginMsg}")
		</script>
	</c:if>
	<c:remove var="loginMsg" scope="session" />

</body>
</html>