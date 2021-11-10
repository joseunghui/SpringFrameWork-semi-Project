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
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/table.css">
</head>
<body>
	<!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
        <div>
        	        	<a href="javascript:history.back();"><h3 style="color: white">ICIA LIBRARY</h3></a>
        </div>
    </nav>
     <div style="padding: 50px">

<table>
	<h4>게시글 정보보기</h4>	
	<br/>
		<tr>
			<th>게시글 번호</th>
			<td>${view.BNo}</td>
		</tr>
		
		<tr>
			<th>작성자</th>
			<td>${view.BWriter}</td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td>${view.BTitle}</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td>${view.BContent}</td>
		</tr>
		
		<tr>
			<th>최종 작성 날짜</th>
			<td>${view.BDate}</td>
		</tr>

		<tr>
			<th>첨부파일</th>
			<td><img src="resources/BoardProfile/${view.BFileName}" width="300px"></td>
		</tr>
		
		<c:if test="${view.BWriter eq sessionScope.loginId}">
		<tr>
			<td colspan="2">
			<button onclick="location.href='B_modiForm?BNo=${view.BNo}&page=${paging.page}'">수정</button>
			<button onclick="location.href='B_delete?BNo=${view.BNo}&page=${paging.page}'">삭제</button>
			</td>
		</tr>
		</c:if>	
			
		<tr>
			<td colspan="2">
			<button onclick="location.href='B_list?page=${paging.page}'">뒤로가기</button>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>