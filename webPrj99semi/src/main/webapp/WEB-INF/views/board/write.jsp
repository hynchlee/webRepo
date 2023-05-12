<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#write-area{
		width: 600px;
		display: grid;
		grid-template-columns: 1fr 3fr 1fr 1fr;
		grid-template-rows: 30px 570px;
	}

	#write-area > textarea {
		grid-column: span 3;
	}

	#write-area label input{
		display: none;
	}
</style>
</head>
<body>

	<div id="wrap">
		
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<h1>게시글 작성</h1>
			
			<form action="${root}/board/write" method="post" enctype="multipart/form-data">
				<div id="write-area">
					<span>제목</span>
					<input type="text" name="title">
					<span>카테고리</span>
					<select name="categoryNo">
						<c:forEach items="${cvoList}" var="cvo">
							<option value="${cvo.no}">${cvo.name}</option>	
						</c:forEach>
					</select>
					<span>내용</span>
					<textarea name="content"></textarea>
					<label for="inputf">첨부파일</label>
					<div id="preview-area">
						<input id="inputf" type="file" multiple name="f">
					</div>
				</div>
				<input type="submit" value="작성하기">
			</form>
			
		</main>
		
	</div>

	<script>
		const fileTag = document.querySelector("input[type=file]")

		fileTag.onchange = 핸들러함수;
	</script>

</body>
</html>