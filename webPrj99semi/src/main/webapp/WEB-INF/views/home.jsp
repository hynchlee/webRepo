<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	#dashboard{
		width: 700px;
		height: 600px;
		display: grid;
		grid-template-columns: 1fr 1fr;
		grid-template-rows: 1fr 1fr;
		place-items: center center;
	}
	
</style>
</head>
<body>

	<div id="wrap">

        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        
        <main>
        	
        	<div id="dashboard">
        		<div>
					<table class="table">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성일시</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${noticeList}" var="notice">
								<tr>
									<td>${notice.no}</td>
									<td>${notice.title}</td>
									<td>${notice.enrollDate}</td>
									<td>${notice.hit}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
        		<div>
					<table class="table">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성일시</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${boardList}" var="board">
								<tr>
									<td>${board.no}</td>
									<td>${board.title}</td>
									<td>${board.enrollDate}</td>
									<td>${board.hit}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
        		<div>
					<img width="200" height="200" src="${root}/static/img/gallery/${gv.changeName}" alt="${gv.originName}">
					<h4>${gv.title}</h4>
				</div>
        		<div id="board-top-hit">
					로딩중...
				</div>
        	</div>
        	
        </main>

    </div>

	<script>

		f01();
		setInterval(f01, 1000 * 3);

		function f01(){

			$.ajax({
			url: "${root}/home/board-top-hit",
			type: 'post',
			dataType: 'json',
			success: function(vo변수){
				console.log(vo변수);
				const div = document.querySelector('#board-top-hit');
				let str = '';
				str += '<div>'
				str += '마지막 갱신 시각 ' + new Date().toLocaleTimeString();
				str += '</div>'
				str += '<h1>';
				str += vo변수.title;
				str += '</h1>';
				str += '<div>';
				str += vo변수.content;
				str += '</div>';
				div.innerHTML = str;
			},
			error: function(err){
				console.log("err");
				},
			})

		}

	</script>

</body>
</html>

<script type="text/javascript" src="${root}/static/js/home.js"></script>







