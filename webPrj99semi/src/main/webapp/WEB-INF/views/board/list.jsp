<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    main table {
        width: 600px;
        margin: auto;
        font-size: 24px;
        text-align: center;
    }

    main table th , 
    main table td {
        border: 1px solid black;
    }

	.searchValueElem{display: none;}
	.active{display: inline-block;}
	
	#write-btn-area{
		display : flex;
		flex-direction: row-reverse;
		width:600px;
		margin:auto;
	}

	tr:hover:not(:nth-child(0)){
		background-color: antiquewhite;
	}

</style>
</head>
<body>

	<div id="wrap">

        <%@ include file="/WEB-INF/views/common/header.jsp" %>

        <main>

            <h1 align="center">자유게시판 목록 조회</h1>
            
            <div id="search-area">
            	<form action="${root}/board/list" method="get">
            		<input type="hidden" name="page" value="1">
            		<select name="searchType">
            			<option value="title">제목</option>
            			<option value="writer">작성자</option>
            			<option value="category">카테고리</option>
            		</select>
            		<input type="text" class="searchValueElem" name="searchValue" value="${searchVo.searchValue}" placeholder="검색할내용">
					<select name="searchValue" class="searchValueElem">
						<option value="0">없음</option>
						<option value="10">자유</option>
						<option value="20">코딩</option>
						<option value="30">게임</option>
						<option value="40">운동</option>
						<option value="50">요리</option>
					</select>
            		<input type="submit" value="검색">
            	</form>
            </div>
            
            <c:if test="${ not empty loginMember }">
	            <div id="write-btn-area">
		            <a href="${root}/board/write" class="btn btn-secondary">글쓰기</a>
	            </div>
            </c:if>
            

            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>카테고리</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${voList}" var="vo"> 
	                    <tr>
	                        <td>${vo.no}</td>
	                        <td>${vo.title}</td>
	                        <td>${vo.writerName}</td>
	                        <td>${vo.categoryName}</td>
	                        <td>${vo.hit}</td>
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>
            
            <div id="page-area">
            	<c:if test="${pv.currentPage > 1}">
	            	<a class="btn btn-primary btn-sm" href="${root}/board/list?page=${pv.currentPage - 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">이전</a>
            	</c:if>
	            	<c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
	            		<c:if test="${pv.currentPage != i}">
			            	<a class="btn btn-primary btn-sm" href="${root}/board/list?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">${i}</a>
	            		</c:if>
	            		<c:if test="${pv.currentPage == i}">
			            	<a class="btn btn-primary btn-sm">${i}</a>
	            		</c:if>
	            	</c:forEach>
	            <c:if test="${pv.currentPage < pv.maxPage}">
	            	<a class="btn btn-primary btn-sm" href="${root}/board/list?page=${pv.currentPage + 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">다음</a>
	            </c:if>
            </div>

        </main>

    </div>

</body>
</html>

<script>
	const searchType = '${searchVo.searchType}';
	const searchValue = '${searchVo.searchValue}';
	
	const searchValueSelectTag = document.querySelector("select[name='searchValue']");
	const searchValueInputTag = document.querySelector("input[name='searchValue']");
	
	if(searchType.length > 1){
		initSearchType();
	}
	
	// 검색 타입 초기셋팅
	function initSearchType(){
		const x = document.querySelector('select > option[value="' + searchType + '"]');
		x.selected = true;
	}
	
	
	//서치타입 변경 시 함수 실행
	const searchTypeTag = document.querySelector('select[name="searchType"]');
	searchTypeTag.addEventListener("change" , setSearchValueTag);

	function setSearchValueTag(){
		const searchType = searchTypeTag.value;
		if(searchType == 'category'){
			setSearchValueTagSelect();
		}else{
			setSearchValueTagInput();
		}
	}

	//검색값 영역을 셀렉트가 보이게 (타입이 카테고리일 때)
	function setSearchValueTagSelect(){
		searchValueSelectTag.classList.add("active");
		searchValueSelectTag.disabled = false;
		searchValueInputTag.classList.remove("active");
		searchValueInputTag.disabled = true;

		searchValueInputTag.value = '';
	}

	//검색값 영역을 인풋이 보이게 (타입이 카테고리가 아닐 때)
	function setSearchValueTagInput(){
		searchValueInputTag.classList.add("active");
		searchValueInputTag.disabled = false;
		searchValueSelectTag.classList.remove("active");
		searchValueSelectTag.disabled = true;
	}

	//카테고리로 검색한 이후에 검색값이 유지되게
	function initSearchValueSelect(){
		if(searchType != 'category'){
			return ;
		}
		const optionTag = document.querySelector("option[value='" + searchValue + "']");
		optionTag.selected = true;
	}
	
	
	setSearchValueTag();
	initSearchValueSelect();

	const tbody = document.querySelector('tbody');
	tbody.addEventListener('click', (event)=>{
		//글번호 가져와서
		const bno = event.target.parentNode.children[0].innerText;

		//요청 보내기
		location.href = '${root}/board/detail?bno='+ bno;
	});
	
</script>









