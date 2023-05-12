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

	<c:if test="${loginMember == null }">
		<h1>홈페이지</h1>
		<a href="/app/member/login">로그인</a>
		<a href="/app/member/join">회원가입</a>
	</c:if>
	<c:if test="${loginMember != null }">
		<h1>${loginMember.nick }님 환영합니다</h1>
		<a href="">공지사항</a>
		<a href="">자유게시판</a>
		<a href="">마이페이지</a>
		<a href="/app/member/logout">로그아웃</a>
	</c:if>
	<c:if test="${loginMsg !=null }">
		<script>
			alert("${loginMsg}")
		</script>
	</c:if>
	<c:remove var="loginMsg" scope="session" />

</body>
</html>