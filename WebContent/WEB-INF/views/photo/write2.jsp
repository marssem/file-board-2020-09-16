<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/photo/write2" enctype="multipart/form-data">
제목 : <input type="text" name="pbTitle"><br>
내용 : <textarea name="pbContent"></textarea><br>
이름 : <input type="file" name="pbFile"><br>
<button>올리기</button>
</form>
</body>
</html>