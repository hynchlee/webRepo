<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="wrap">
		
		<%@include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<h1>갤러리 상세조회</h1>
			
			<span>${vo.title}</span>
			
			<br>
			
			<img width="500" height="500" alt="${vo.originName}" src="${root}/static/img/gallery/${vo.changeName}">
			
			<br>
			<p>${vo.content}</p>
			
		</main>
		
	</div>
	
</body>
</html>