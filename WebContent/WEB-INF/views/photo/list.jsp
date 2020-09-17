<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/common/head.jsp"></jsp:include>
</head>

<body>
<h2>사진 게시판</h2>
<table class="table">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">이미지 명</th>
      <th scope="col">이미지</th>
      <th scope="col">작성일</th>
    </tr>
  </thead>
  <tbody>
  <c:if test="${empty pbList }">
  	<td colspan="4">내용이 없습니다.</td>
  </c:if>
  <c:if test="${!empty pbList }">
<c:forEach var="item" items="${pbList}" varStatus="status">
  <tr>
 <th scope="row">${item.pbNum}</th>
      <td>${item.pbTitle}</td>
      <td>${item.pbPhotoName}</td>
      <td><img src="/resources/${item.pbPhotoPath}" width="50" ></td>
      <td>${item.credat}</td>
    </tr>
 </c:forEach>
 </c:if>
  </tbody>
</table>
<a href="/photo/list?page.pageNum=${page.pageNum-1}" > ◀ </a>
<c:forEach begin="${page.startBlock}" end="${page.endBlock}" var="idx">
<a href="/photo/list?page.pageNum=${page.pageNum}+${idx}" >[${idx}]</a>
</c:forEach>
<a href="/photo/list?page.pageNum=${page.pageNum+1}" > ▶ </a>
<a href="/photo/write"><button>게시판 가기</button></a>
<img src="" style="display:none" id="sImg">
<!-- <a href="/photo/write1"><button>게시판 가기1</button></a>
<a href="/photo/write2"><button>게시판 가기2</button></a> -->
<script >
	function showImg(){
		document.querySelector('#sImg').src=img.src;
		document.querySelector('#sImg').style.display='';
	}
	function offImg(){
		document.querySelector('#sImg').style.display='none';

	}
	
</script>
</body>
</html>