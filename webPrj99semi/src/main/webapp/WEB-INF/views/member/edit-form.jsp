<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/member/edit-form.css">
</head>
<body>

	<div id="wrap">

        <%@ include file="/WEB-INF/views/common/header.jsp" %>

        <main>

            <form onsubmit="return true;" action="${pageContext.request.contextPath}/member/edit" method="post">

                <div id="join-area">
                    <span>아이디</span>
                    <input type="text" name="memberId" value="${loginMember.id }">
                    <span>비밀번호</span>
                    <input type="password" name="memberPwd">
                    <span>닉네임</span>
                    <input type="text" name="memberNick" value="${loginMember.nick }">
                    <span>프로필 사진</span>
                    <input type="file" name="memberProfile">
                    <span>취미</span>
                    <div>
                        <label>
                            코딩<input type="checkbox" name="hobby" value="20">
                        </label>
                        <label>
                            게임<input type="checkbox" name="hobby" value="30">
                        </label>
                        <label>
                            운동<input type="checkbox" name="hobby" value="40">
                        </label>
                        <label>
                            요리<input type="checkbox" name="hobby" value="50">
                        </label>
                    </div>

                    <input type="reset" value="초기화">
                    <input type="submit" value="수정하기">
                </div>

                <button type="button" onclick="quit();">탈퇴하기</button>

            </form>

        </main>

    </div>

</body>
</html>


<script>
	const inputArr = document.querySelectorAll('input[name=hobby]');
    const hobbyArr = "${loginMember.hobby}".split(",")

    for(x of inputArr){
        if(hobbyArr.indexOf(x.value)>=0){
            x.checked = true;
        }
    }

    //비번 입력해야 수정하기 진행
    function checkValidation(){
        const pwd = document.querySelector("main input[name=memberPwd]").value;
        if(pwd.length >= 1){
            return true;
        }
        return false;
    }

    //탈퇴하기 처리
    function quit() {
        const result = confirm('정말로 탈퇴하실건가요?');
        if(result){
            location.href='${pageContext.request.contextPath}/member/quit';
        }else{

        }
    }
</script>

