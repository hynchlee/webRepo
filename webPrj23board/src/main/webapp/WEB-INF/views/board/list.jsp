<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시글 목록</h1>
	
	<%
		List<BoardVo> voList = (List<BoardVo>)request.getAttribute("boardVoList");
	%>
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
			<tr>
			<%for(int i=0; i<voList.size(); i++){ %>
				<td><%=voList.get(i).getNo() %></td>
				<td><a href="/app23/board/detail?no=<%=voList.get(i).getNo() %>"><%=voList.get(i).getTitle() %></a></td>
				<td><%=voList.get(i).getWriterNo() %></td>
				<td><%=voList.get(i).getEnrollDate() %></td>
			</tr>
			<%} %>
		<tbody>
		</tbody>
	</table>
	
	<a href="/app23">홈으로</a>
	
</body>
</html>