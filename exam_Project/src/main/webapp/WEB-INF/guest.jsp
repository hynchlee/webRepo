<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*, body{
		margin: auto 0;
	}
</style>
</head>
<body>
	
	
	<div style="height: 300px; background-color: rgb(246, 246, 206);">
		<h1>전자 방명록</h1>
		<table border="1">
			<thead>
				<tr>
					<th>이름</th>
					<th>나이</th>
					<th>주소</th>
					<th>개인정보<br> 이용 제공<br> 동의 여부</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>홍길동</td>
					<td>10</td>
					<td>서울시 중랑구</td>
					<td><input type="checkbox" checked></td>
				</tr>
				<tr>
					<td>국길동</td>
					<td>13</td>
					<td>서울시 성북구</td>
					<td><input type="checkbox" checked></td>
				</tr>
				<tr>
					<td>황길동</td>
					<td>9</td>
					<td>서울시 은평구</td>
					<td><input type="checkbox"></td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>