<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
main>table {
	width: 500px;
	border: 3px solid black;
	border-collapse: collapse;
	margin: auto;
	text-align: center;
	line-height: 30px;
}

main>table td {
	border: 1px solid black;
}

main>table tr {
	height: 30px;
}

main>table>thead>tr>th:nth-child(1) {
	width: 10%;
}

main>table>thead>tr>th:nth-child(2) {
	width: 50%;
}

main>table>thead>tr>th:nth-child(3) {
	width: 30%;
}

main>table>thead>tr>th:nth-child(4) {
	width: 10%;
}

#page-area {
	width: 500px;
	margin: auto;
	display: flex;
	justify-content: space-evenly;
}

#write-btn-area {
	widows: 500px;
	margin: auto;
	display: flex;
	flex-direction: row-revers;
}

tbody > tr:hover{
	background-color: gainsboro;
	cursor: pointer;
}

</style>
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp"%>

		<main>

			<h1 align="center">공지사항 목록</h1>

			<c:if test="${loginMember.id == 'ADMIN' }">
			
				<div id="write-btn-area">
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/notice/write">작성하기</a>
				</div>
			</c:if>

			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성일시</th>
						<th>조회수</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${list}" var="notice">
						<tr>
							<td>${notice.no}</td>
							<td>${notice.title}</td>
							<td>${notice.enrollDate}</td>
							<td>${notice.hit}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>

			<div id="page-area">
				<c:if test="${pv.currentPage > 1 }">
					<a class="btn btn-primary" href="${pageContext.request.contextPath }/notice/list?page=${pv.currentPage-1}">이전</a>
				</c:if>
				<c:forEach begin="${pv.startPage }" end="${pv.endPage }" var="i">
					<a class="btn btn-primary" href="${pageContext.request.contextPath }/notice/list?page=${i}">${i }</a>
				</c:forEach>
				<c:if test="${pv.currentPage < pv.maxPage }">
					<a class="btn btn-primary" href="${pageContext.request.contextPath }/notice/list?page=${pv.currentPage+1}">다음</a>
				</c:if>

			</div>

		</main>
	</div>

</body>
</html>

<script>

	const tbody = document.querySelector("tbody");
	tbody.addEventListener('click', function(e){
		const no = e.target.parentNode.children[0].innerText;
		location.href = "${pageContext.request.contextPath}/notice/detail?no="+no;
	});

</script>