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
	<h1>홈페이지</h1>
	<c:if test="${not empty loginMember}">
		<h2>${loginMember.nick}님환영합니다</h2>
		<img width="300px" height="300px" alt="프로필 사진" src="/app25/resources/img/${loginMember.profile}">
		<a href="/app25/member/profile/down?filename=${loginMember.profile}">다운로드</a>
		<a download href="/app25/resources/img/${loginMember.profile}">다운로드2</a>
	</c:if>
	
	<c:if test="${empty loginMember }">
		<a href="/app25/member/join">로그인</a>
		<br>
		<a href="/app25/member/login">회원가입</a>	
	</c:if>
	

</body>
</html>
