<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="joypeb">
    <link href="resources/bootstrap/css/styles.css" rel="stylesheet"/>
    <link href="resources/bootstrap/js/scripts.js" rel="stylesheet"/>
<title>Spring_회원수정</title>
</head>
<body>
<form action="m_modify" method="POST" enctype="multipart/form-data">
	<!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
        <div>
        	<a href="javascript:history.back();"><h3 style="color: white">ICIA LIBRARY</h3></a>
        </div>
    </nav>
    <div style="padding: 50px">
	<caption>회원수정</caption>
	<table>
		
		<tr>
			<th>아이디</th>
			<td>${modify.MId}<input type="hidden" name="MId" value="${modify.MId}">
			<input type="hidden" name="page" value="${page}"></td>
		</tr>		
		<tr>
			<th>패스워드</th>
			<td><input type="password" name="MPw"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="MName" placeholder="${modify.MName}"></td>
		</tr>		
		<tr>
			<th>생년월일</th>
			<td><input type="date" name="MBirth"></td>
		</tr>
		
		<tr>
			<th>성별</th>
			<td><select class="form-control-sm" name="MGender">
					<option selected>성별</option>
					<option value="man">남</option>
					<option value="woman">여</option>
				</select></td>
		</tr>
					
		
		<tr>
			<th>연락처</th>
			<td><input type="text" name="MPhone" placeholder="${modify.MPhone}"></td>
		</tr>		
			
		<tr>
			<th>이메일</th>
			<td><input type="email" name="MEmail" placeholder="${modify.MEmail}"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="MAddr" placeholder="${modify.MAddr}"></td>
		</tr>
		
		<tr>
			<th>프로필사진</th>
			<td><input type="file" name="MProfile"></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
			</td>
		</tr>
	</table>
	</div>
</form>
</body>
</html>