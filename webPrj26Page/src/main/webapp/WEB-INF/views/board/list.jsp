<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#a1{
		color: gray;
	}
</style>
</head>
<body>

	<h1>게시글 목록</h1>


	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${bvoList}" var="bvo">
				<tr>
					<td>${bvo.no}</td>
					<td>${bvo.title}</td>
					<td>${bvo.content}</td>
					<td>${bvo.writerNo}</td>
					<td>${bvo.enrollDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="page_area">
		<c:if test="${pv.currentPage > 1}">
			<a href="/app26/board/list?page=${pv.currentPage-1 }">이전</a>
		</c:if>
		<c:forEach begin="${pv.startPage }" end="${pv.endPage }" step="1" var="i">
			<c:if test="${pv.currentPage !=i }">
				<a href="/app26/board/list?page=${i}">${i}</a>
			</c:if>
			<c:if test="${pv.currentPage ==i }">
				<a id="a1">${i}</a>
			</c:if>
		</c:forEach>
		<c:if test="${pv.currentPage != pv.maxPage }">
			<a href="/app26/board/list?page=${pv.currentPage+1 }">다음</a>
		</c:if>
	</div>

</body>
</html>