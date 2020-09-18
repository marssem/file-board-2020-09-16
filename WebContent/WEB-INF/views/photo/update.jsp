<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/common/head.jsp"></jsp:include>
</head>
<body>
<form method="post" action="/photo/list" enctype="multipart/form-data">
	번호 : <input type="text" name="pbNum" placeholder="${pbNum}" readonly="true"><br>
	제목 : <input type="text" name="pbTitle" placeholder="${pbTitle}"><br>
	내용 : <textarea name="pbContent" placeholder="${pbContent}"></textarea><br>
	사진 : <input type="file" name="pbFile" ><br>
	<button>글쓰기</button> 
</form>
</body>
</html>