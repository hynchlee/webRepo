<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>인덱스
	<c:if test="${not empty loginMember }">
		<h2>${loginMember.nick}님 환영합니다</h2>	
		<a href="/app24/member/logout">로그아웃</a>
		<a href="/app24/member/edit">마이페이지</a>
	</c:if>
	</h1>
	
		<c:if test="${empty loginMember }">
			<a href="/app24/member/login">로그인</a>
	        <br>
	        <a href="/app24/member/join">회원가입</a>
		</c:if>
        
        <c:if test="${not empty loginMember }">
        	<a href="/app24/member/list">회원 리스트</a>
        </c:if>
        
        	
	<c:if test="${not empty sessionScope.alertMsg}">
		<script>
        	alert('${sessionScope.alertMsg}');
    	</script>
	</c:if>
		
	<c:remove var="alertMsg"/>
    <%-- <%session.removeAttribute("alertMsg");%> --%>
    
</body>
</html>