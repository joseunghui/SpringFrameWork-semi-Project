<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="resources/bootstrap/css/styles.css" rel="stylesheet"/>
    <link href="resources/bootstrap/js/scripts.js" rel="stylesheet"/>
<title>Board_List</title>
</head>
<body>
	<!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
        <div>
        	        	<a href="javascript:history.back();"><h3 style="color: white">ICIA LIBRARY</h3></a>
        </div>
    </nav>
      <div style="padding: 50px">
      
<table class="table">
		<h4>게시글 목록</h4>
		<tr>
			<th>글 번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>최종 작성일</th>
			<th>첨부파일</th>
			<c:if test="${list.BWriter eq 'admin'}">
			<tr>
				<th><button>삭제</button></th>
			</tr>
			</c:if>
		</tr>
		
		<c:forEach var="list" items="${boardList}">
		<tr>
			<td>${list.BNo}</td>
			<td>${list.BWriter}</td>
			<td><a href="B_view?BNo=${list.BNo}&page=${paging.page}">${list.BTitle}</a></td>
			<td>${list.BDate}</td>
			<td><img src="resources/BoardProfile/${list.BFileName}" width="50px"></td>
		</tr>
		</c:forEach>
	</table>

	</div>


<!-- 페이징 처리 -->
	<c:if test="${paging.page <= 1}">[이전]</c:if>
	<c:if test="${paging.page > 1}"><a href="B_list?page=${paging.page-1}">[이전]</a></c:if>
	
	<!-- 현재 페이지를 숫자로 나타내기 -->
	<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">${i}</c:when>
			<c:otherwise><a href="B_list?page=${i}">${i}</a></c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${paging.page >= paging.maxPage}">[다음]</c:if>
	<c:if test="${paging.page < paging.maxPage}"><a href="B_list?page=${paging.page+1}">[다음]</a></c:if>

</body>
</html>