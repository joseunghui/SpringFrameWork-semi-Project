<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="resources/bootstrap/css/styles.css" rel="stylesheet"/>
    <link href="resources/bootstrap/js/scripts.js" rel="stylesheet"/>
<title>게시글 작성하기</title>
</head>
<body>
	<!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
        <div>
        	        	<a href="javascript:history.back();"><h3 style="color: white">ICIA LIBRARY</h3></a>
        </div>
    </nav>
    <div style="padding: 180px">
	<form action="B_write" method="post" enctype="multipart/form-data">
		<caption>게시글 작성하기</caption></br>
		<table>
			
			<tr>
				<th>작성자</th>
				<td>${sessionScope.loginId}</td>
			</tr>
			<tr>
			
				<th>제목</th>
				<td><input type="text" name="BTitle" placeholder="제목을 입력해주세요." required></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="60" name="BContent" placeholder="내용을 입력해주세요." required></textarea></td>
			</tr>
			
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="BFile" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="BWriter"
					value="${sessionScope.loginId}"> 
					<input type="submit" value="등록"></td>
			</tr>

		</table>

	</form>
	</div>
</body>
</html>