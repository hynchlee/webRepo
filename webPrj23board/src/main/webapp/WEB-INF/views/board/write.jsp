<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

    #wrap{
        border: 1px solid black;
        box-sizing: border-box;
        width: 400px;
        height: 500px;
        display: grid;
        grid-template-columns: 1fr 3fr;
        grid-template-rows: 1fr 5fr 1fr;
    }

    #wrap>div{
        border: 1px solid black;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    textarea[name='content']{
        width: 250px;
        height: 300px;
        resize: none;
    }

    #wrap>div:last-child{
        grid-column: span 2;
    }

    input[name='title']{
        width: 250px;
    }

</style>
</head>
<body>

	<h1>게시글 작성</h1>

    <form action="/app23/board/write" method="post">
        <div id="wrap">
            <div>제목</div>
            <div><input type="text" name="title"></div>
    
            <div>내용</div>
            <div><textarea name="content"></textarea></div>
    
            <div><input type="submit" value="작성하기"></div>
        </div>
    </form>

</body>
</html>