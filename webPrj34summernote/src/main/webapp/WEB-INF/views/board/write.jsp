<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<meta charset="UTF-8">
<body>

	<h1>게시글 작성하기</h1>

    <form action="/app/board/write" method="post">
        제목 : <input type="text" name="title">
        <br>
        내용 : <textarea id="summernote" name="content"></textarea>
        <br>
        <input type="submit" value="작성하기">
    </form>

    <script>
		$('#summernote').summernote({
		  placeholder: 'Hello stand alone ui',
		  tabsize: 2,
          width: 600,
		  height: 400,
          maxHeight: 500,
          maxWidth: 800, 
          callbacks: {
            onImageUpload : f01
          },
		  toolbar: [
			['style', ['style']],
			['font', ['bold', 'underline', 'clear']],
			['color', ['color']],
			['para', ['ul', 'ol', 'paragraph']],
			['table', ['table']],
			['insert', ['link', 'picture', 'video']],
			['view', ['fullscreen', 'codeview', 'help']]
		  ]
		});

        //파일업로드 발생시 동작
        function f01(fileList){

            const fd = new FormData();

            for(file of fileList){
            	fd.append("f", file);	
            }
            
            $.ajax({
                url:"/app/upload",
                type: 'post',
                data:fd,
                processData: false,
                contentType: false,
                dataType:"json",
                success: function(data){
                    console.log(data);
                    $('#summernote').summernote('insertImage', '/app/static/img/' + data);
                },
                error: function(error){
                    console.log(error)
                },
            })

        }

	  </script>
</body>
</html>