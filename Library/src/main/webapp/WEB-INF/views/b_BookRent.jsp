<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="joypeb">
    <link href="resources/bootstrap/css/styles.css" rel="stylesheet"/>
    <link href="resources/bootstrap/js/scripts.js" rel="stylesheet"/>
<title>도서대여</title>
</head>
<body>
	<!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
        <div>
        	<a href="javascript:history.back();"><h3 style="color: white">ICIA LIBRARY</h3></a>
        </div>
    </nav>
	<div style="padding: 150px">
	<c:forEach var="list" items="${bookList}">
	<span>${list.KNo}</span>
	<img style="width:180px; height:140px;" src="resources/bookprofile/${list.KProfileName}">
	<span>${list.KName}</span>
	<form action="b_bookRent" method="POST">
		<input type="hidden" name="KCheckin" value="${sessionScope.loginId}">
		<input type="hidden" name="KNo" value="${list.KNo}">
		<c:choose>
			<c:when test="${list.KCheckin eq null}">
				<button class="custom_button" type="submit">대여</button>
			</c:when>
			<c:otherwise>
				<span>대여 불가</span>
			</c:otherwise>
		</c:choose>
	</form>
	</c:forEach>
	</div>
</body>
</html>