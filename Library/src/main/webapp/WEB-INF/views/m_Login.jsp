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
    <title>로그인</title>
</head>
<body>
	<!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
        <div>
       		<a href="javascript:history.back();"><h3 style="color: white">ICIA LIBRARY</h3></a>
        </div>
    </nav>
    <div>
	   	<form action="m_login" method="POST" class="custom_form">	   		
	   		<input class="form-control" type="text" placeholder="id" name="MId"><br/>
	   		<input class="form-control" type="password" placeholder="pw" name="MPw"><br/>
	   		<button class="custom_button"  type="submit">로그인</button>
	   	</form>
   	</div>
</body>

</html>