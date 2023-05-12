<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

    #notice-area > input{
		width: 100%;
		height: 30px;
		border: 3px solid black;
	}
	
	#notice-area > textarea{
		width: 100%;
		height: 200px;
		border: 2px solid black;
		resize: none;
	}

	#notice-area{
		width: 600px;
		height: 350px;
		border: 1px solid black;
		margin: auto;

		display: grid;
		grid-template-rows: 1fr 1fr 8fr;
		grid-template-columns: 1fr 1fr 1fr 1fr;
	}

	#notice-area > div{
		border: 1px solid black;
		box-sizing: border-box;
		width: 100%;
		height: 100%;
	}

	#notice-area > div:not(:last-child){
		display: flex;
		justify-content: center;
		align-items: center;
	}

	#notice-area > div:nth-child(2){
		grid-column:span 3;
	}

	#notice-area > div:nth-child(7){
		grid-column:span 4;
	}

	#notice-btn-area{
		display: flex;
		justify-content:space-evenly;
	}

    #notice-area input{
        width: 100%;
        height: 100%;
    }

    #notice-area textarea{
        width: 100%;
        height: 100%;

    }
</style>

</head>
<body>

    <div id="wrap">

		<%@ include file="/WEB-INF/views/common/header.jsp" %>

        <main>
            <h1 align="center">공지사항 수정</h1>
    
            <form action="${root}/notice/edit?no=${vo.no}" method="post">
    
                <div id="notice-area">
                    <div>제목</div>
                    <div><input type="text" name="title" value="${vo.title}"></div>
                    <div>작성일</div>
                    <div>${vo.enrollDate}</div>
                    <div>조회수</div>
                    <div>${vo.hit}</div>
                    <div><textarea name="content">${vo.content}</textarea></div>
        
                </div>
    
            
    
                <div id="notice-btn-area">
                    <input type="submit" class="btn btn-warning" value="수정하기"></input>
                </div>
            </form>
        </main>

    </div>

</body>
</html>