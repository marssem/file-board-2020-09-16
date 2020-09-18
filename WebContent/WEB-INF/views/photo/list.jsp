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
<div class="serach">
<form action="/photo/list">
	제목 : <input type="text" name="pbTitle" value="${param.pbTitle}"><br>
	내용 : <input type="text" name="pbContent value="${param.pbContent}"><br>
	일자 : <input type="date" name="credat1" value="${param.credat1 }"> - <input type="date" name="credat2" value="${param.credat2 }"><br>
	<input type="hidden" name="page.pageNum" value="1">
	<button >검색</button>
	</form>
</div>

<form method="post" action="/photo/delete">
<table class="table">
  <thead>
    <tr>
    <th scope="col"><input type="checkbox" id="checker" onchange="allCheck(this)" ></th>
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
<c:forEach var="item" items="${pbList}" varStatus="status" >
  <tr>
 <th scope="row"><input type="checkbox" name="pbNums" value="${item.pbNum}"></th>
 		<td>${item.pbNum}</td>
      <td>${item.pbTitle}</td>
      <td>${item.pbPhotoName}</td>
      <td><img src="/resources/${item.pbPhotoPath}" width="50" ></td>
      <td>${item.credat}</td>
    </tr>
 </c:forEach>
 </c:if>
  </tbody>
</table>
 <br><button>삭제</button><button type="button" onclick="up(this)">수정</button>
 </form>
<form action="/photo/list">
<a href="/photo/list?page.pageNum=${page.pageNum-1}" id="forw"> ◀ </a>
<c:forEach begin="${page.startBlock}" end="${page.endBlock}" var="idx">
<a href="/photo/list?page.pageNum=${idx}&pbContent=${param.pbContent}&credat1=${param.credat1}&credat2=${param.credat2}" >[${idx}]</a>
</c:forEach>
<a href="/photo/list?page.pageNum=${page.pageNum+1}" > ▶ </a>
</form>
<a href="/photo/write"><button>게시판 가기</button></a>
<img src="" style="display:none" id="sImg">
<!-- <a href="/photo/write1"><button>게시판 가기1</button></a>
<a href="/photo/write2"><button>게시판 가기2</button></a> -->
<script >
	function showImg(src){
		document.querySelector('#sImg').src=img.src;
		document.querySelector('#sImg').style.display='';
	}
	function offImg(){
		document.querySelector('#sImg').style.display='none';

	}
	function allCheck(obj){
		var chkObjs = document.querySelectorAll('input[name=pbNums]');
		for(var i=0;i<chkObjs.length;i++){
			chkObjs[i].checked = obj.checked;
		}
	}
	function up(obj){
		var upObjs = document.querySelectorAll('input[name=pbNums]');
		for(var i=0;i<upObjs.length;i++){
			upObjs[i].checked = obj.checked;
			if(i>5){
				alert("하나만 고르세요");
				return;
			}
		}
	}
	
</script>
</body>
</html>