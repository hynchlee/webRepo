<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  	<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>    

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common/header.css">

<c:if test="${ not empty alertMsg }">
	<script>
	    alert('${alertMsg}');
	</script>
</c:if>
<c:remove var="alertMsg" scope="session"/>

<header>
    <div></div>
    <div id="logo-area">
        <a href="${pageContext.request.contextPath}/home">
            <img width="100%" height="150px" src="${pageContext.request.contextPath}/static/img/logo.jpg" alt="로고이미지">
        </a>
    </div>
    <div id="member-area">
    	<c:if test="${ empty loginMember }">
	    	<form action="${pageContext.request.contextPath}/member/login" method="POST">
	         <input type="text" name="memberId" placeholder="아이디">
	         <input type="password" name="memberPwd" placeholder="비밀번호">
	         <input type="submit" id="login-btn" value="로그인">
	    	</form>
	        <button id="join-btn" onclick="location.href='${pageContext.request.contextPath}/member/join'">회원가입</button>
    	</c:if>
    	<c:if test="${ not empty loginMember }">
    		<img 
    			width="100px" 
    			height="100px" 
    			alt="프로필사진" 
    			src="${pageContext.request.contextPath}/static/img/member/profile/${loginMember.profile}">
    		<br>
    		<button onclick="location.href='${pageContext.request.contextPath}/member/logout'">로그아웃</button>
    	</c:if>
    </div>
</header>

<nav>
    <a href="${pageContext.request.contextPath}/notice/list?page=1">공지사항</a>
    <a href="${pageContext.request.contextPath}/board/list?page=1">자유게시판</a>
    <a href="${pageContext.request.contextPath}/gallery/list">갤러리</a>
    <a href="${pageContext.request.contextPath}/member/edit">마이페이지</a>
</nav>

