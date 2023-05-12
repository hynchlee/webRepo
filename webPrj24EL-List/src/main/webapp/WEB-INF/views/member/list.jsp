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

	<h1>회원목록</h1>

	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>패스워드</th>
				<th>닉네임</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${voList}">
				<tr>
					<td>${vo.no}</td>
					<td>${vo.id}</td>
					<td>${vo.pwd}</td>
					<td>${vo.nick}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>