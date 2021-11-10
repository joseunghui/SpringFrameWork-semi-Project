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
<title>Spring_회원정보</title>
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
     
	<caption>회원정보</caption>
	
	<table>
		
		<tr>
			<th>아이디</th>
			<td>${view.MId}</td>
		</tr>		
		<tr>
			<th>패스워드</th>
			<td>${view.MPw}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${view.MName}</td>
		</tr>		
		<tr>
			<th>생년월일</th>
			<td>${view.MBirth}</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${view.MGender}</td>
		</tr>
		
		<tr>
			<th>연락처</th>
			<td>${view.MPhone}</td>
		</tr>		
			
		<tr>
			<th>이메일</th>
			<td>${view.MEmail}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${view.MAddr}</td>
		</tr>
		
		<tr>
			<th>프로필사진</th>
			<td><img src="resources/profile/${view.MProfileName}" width="200px">
			<br>${view.MProfileName}</td>
		</tr>
		<c:if test="${sessionScope.loginId eq view.MId}">
		<tr>
			<td colspan="2">
				<button class="custom_button"  onclick="location.href='m_modiForm?MId=${view.MId}'">수정</button>
				<button class="custom_button"  onclick="location.href='m_delete?MId=${view.MId}'">삭제</button>
			</td>
		</tr>
		</c:if>
	</table>
	</div>
</body>
</html>