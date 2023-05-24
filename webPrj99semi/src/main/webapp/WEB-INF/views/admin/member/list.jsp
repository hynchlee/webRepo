<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전체 회원 조회</h1>

	<table border="1">
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>번호</th>
				<th>아이디</th>
				<th>가입일시</th>
				<th>상태</th>
				<th>제제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td><input type="checkbox" value="${vo.no}"></td>
					<td>${vo.no}</td>
					<td>${vo.id}</td>
					<td>${vo.enrollDate}</td>
					<td>${vo.status}</td>
					<td><button onclick="restrainMember(${vo.no});">⛔</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<button onclick="restrainCheckedMember();">일괄제제</button>
	
	<script>

		document.querySelector('thead input[type="checkbox"]')
		.addEventListener('change' , setAllcheckbox);
	
		function setAllcheckbox(){
			//가장 위 체크박스 의 체크 상태 가져오기
			const v = document.querySelector('thead input[type=checkbox]').checked;
			//모든 체크박스 가져오기
			const cbArr = document.querySelectorAll('tbody input[type=checkbox]');
			//checked 값 변경
			for(let cb of cbArr){
				cb.checked = v;
			}
		}
	
		function restrainCheckedMember(){
			//체크된 행 번호 가져오기
			const noArr = [];
			const cbArr = document.querySelectorAll('tbody input[type=checkbox]');
			for(let cb of cbArr){
				if(cb.checked == true){
					noArr.push(cb.value);

		
				}

			}	
			alert(noArr);

			//번호들을 서버한테 넘기기
			$.ajax({
				url : '/app/admin/member/stop' ,
				type : 'post' ,
				data : {
					noArr : JSON.stringify(noArr)
				} ,
				success : function(data){
					location.reload();
				} ,
				error : function(error){
					console.log(error);
				},
			});
		}
	
		function restrainMember(no){
			const result = confirm("회원 제제 하실?");
			if(result){
				location.href='/app/admin/member/stop?no=' + no;
			}
		}
	
	</script>

</body>
</html>