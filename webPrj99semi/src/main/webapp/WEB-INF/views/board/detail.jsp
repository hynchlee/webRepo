<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			#write-area {
				width: 600px;
				display: grid;
				grid-template-columns: 1fr 3fr 1fr 1fr;
				grid-template-rows: 30px 570px;
			}

			#write-area>textarea {
				grid-column: span 3;
			}

			#write-area label input {
				display: none;
			}
		</style>
	</head>

	<body>

		<div id="wrap">
		
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
			
			<main>
				<h1>게시글 상세조회</h1>
				
				<form action="${root}/board/edit" method="post" enctype="multipart/form-data">
					<input type="hidden" name="no" value="${vo.no}">
					<div id="write-area">
						<span>제목</span>
						<input type="text" name="title" value="${vo.title}" readonly>
						<span>카테고리</span>
						<div>${vo.categoryName}</div>
						<span>내용</span>
						<textarea name="content" readonly>${vo.content}</textarea>
						<label>
							첨부파일
						</label>
						<div id="preview-area">
							<c:forEach items="${attList}" var="att">
								<img width="100" height="100" alt="첨부파일" src="${root}/static/img/board/${att.changeName}">
							</c:forEach>
						</div>
					</div>
					<input type="submit" value="수정하기" hidden>
				</form>

					<div id="btn-area">
						<button class="btn btn-warning btn-sm" onclick="edit();">수정</button>
						<button class="btn btn-danger btn-sm" onclick="del();">삭제</button>
					</div>

				</main>

		</div>

		<script>
			const fileTag = document.querySelector("input[type=file]");
			const previewArea = document.querySelector("#preview-area");

			// 사진 취소눌러도 동작됨
			fileTag.onchange = function (e) {

				// 취소누른 경우 안되게
				if (fileTag.files.length == 0) {
					previewArea.innerHTML = '';
					return;
				}

				for (let i = 0; i < fileTag.files.length; i++) {
					const fr = new FileReader();
					fr.readAsDataURL(fileTag.files[0]);

					fr.onload = function (e) {
						const imgTag = document.createElement('img');
						imgTag.src = e.target.result;
						imgTag.alt = "미리보기 이미지 사진";
						imgTag.width = 100;
						imgTag.height = 100;
						previewArea.appendChild(imgTag);
					}

				}
			};

			//게시글 삭제
			function del(){
				const result = confirm("진짜 삭제?");
				if(!result){
					return;
				}

				location.href = '${root}/board/del?no='+ '${vo.no}';
			}

			//게시글 수정
			function edit(){
				document.querySelector("input[name=title]").readOnly=false;
				document.querySelector("textarea[name=content]").readOnly=false;
				document.querySelector("input[type=submit]").hidden=false;
			}

		</script>

	</body>

	</html>