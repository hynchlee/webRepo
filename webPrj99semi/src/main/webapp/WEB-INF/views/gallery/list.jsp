<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#gallery-area {
	display: grid;
	width: 100%;
	grid-template-columns: 1fr 1fr 1fr;
	place-items: center center;
	grid-row-gap: 50px;
}

#gallery-area div {
	height: 100px;
	width: 100px;
}
</style>
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp"%>

		<main>
			<h1>갤러리 목록</h1>

			<div id="gallery-area">
				<c:forEach items="${voList}" var="vo">
					<div>
						<a href="${root}/gallery/detail?no="${vo.no}>
							<img width="100" height="100" src="${root}/static/img/gallery/${vo.changeName}" alt="${vo.originName}">
						</a>
					</div>
				</c:forEach>
			</div>
		</main>
	</div>

</body>
</html>