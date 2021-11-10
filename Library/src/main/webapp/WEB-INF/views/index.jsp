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
    
    <link href="resources/bootstrap/assets/styles.css" rel="stylesheet"/>
    <link href="resources/bootstrap/css/styles.css" rel="stylesheet"/>
    <link href="resources/bootstrap/js/scripts.js" rel="stylesheet"/>
    <title>메인화면</title>
</head>
<body>
	<%-- <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top">
		<div>
		    <a href="m_joinForm">회원가입</a>
		    <a href="m_loginForm">로그인</a>
		    <a href="m_logout">로그아웃</a>
		    <a href="m_view?MId=${sessionScope.loginId}">회원 정보</a>
		    <a href="m_modiForm?MId=${sessionScope.loginId}">회원 수정,삭제</a>
		    <button onclick="location.href='S_reservForm?MId=${sessionScope.loginId}'">열람실 좌석예약</button>
			<button onclick="location.href='B_list?MId=${sessionScope.loginId}'">게시글 목록</button>
			<button onclick="location.href='B_writeForm?MId=${sessionScope.loginId}'">게시글 작성</button>
		    <a href="b_BookList">도서 대여</a>
		    <a href="b_bookCheck?MId=${sessionScope.loginId}">도서대여확인</a>
	    </div>
	</nav> --%>
<%-- 	<header class="masthead bg-primary text-white text-center">
		<div>
			<caption align="center">${sessionScope.loginId}님 환영합니다.</caption>
		</div>
	</header> --%>
	<!-- Navigation-->
	
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
       
        <a class="navbar-brand js-scroll-trigger" href="#page-top">
        
        
            <span class="d-block d-lg-none">ICIA LIBRARY</span>
            <span class="d-none d-lg-block">
            	 <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="resources/image/desk.png"alt="..." />
           	<header class="masthead bg-primary text-white text-center">
		<div>
			<caption align="center">${sessionScope.loginId}님 환영합니다.</caption>
		</div>
	</header>
           	</span>
           	
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav">
                <li class="nav-item">
                	<a class="nav-link js-scroll-trigger" href="m_joinForm">회원가입</a>
               	</li>
                <li class="nav-item">
                	<a class="nav-link js-scroll-trigger" href="m_loginForm">로그인</a>
               	</li>
               	<li class="nav-item">
                	<a class="nav-link js-scroll-trigger" href="m_view?MId=${sessionScope.loginId}">회원 정보</a>
               	</li>
               	
                <li class="nav-item">
                	<a class="nav-link js-scroll-trigger" href="m_logout">로그아웃</a>
               	</li>
            </ul>
        </div>
    </nav>
    <!-- Page Content-->
    <div class="container-fluid p-0">
        <!-- About-->
        <section class="resume-section" id="about">
            <div class="resume-section-content">
                <h1 class="mb-0">
                    ICIA
                    <span class="text-primary">Library</span>
                </h1>
                <div class="subheading mb-5">
                    
                </div> 
                
                <div class="social-icons">                
                    
               		<button class="custom_button" onclick="location.href='S_reservForm?MId=${sessionScope.loginId}'">열람실 좌석예약</button>    	
                   	
                    
                   	<button class="custom_button" onclick="location.href='B_list?MId=${sessionScope.loginId}'">게시글 목록</button>
                    
                    
                   	<button class="custom_button" onclick="location.href='B_writeForm?MId=${sessionScope.loginId}'">게시글 작성</button>
                   	
                    <!-- <button href="b_BookList" onclick="location.href='b_BookList'">도서 대여</button> -->
                    <button class="custom_button" onclick="location.href='b_BookList'">도서 대여</button>
                   	<%-- <button href="b_bookCheck?MId=${sessionScope.loginId}">도서대여확인</button> --%>
                   	<button class="custom_button" onclick="location.href='b_bookCheck?MId=${sessionScope.loginId}'">도서대여확인</button>
                </div>
            </div>
        </section>
    </div>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
</body>
<script type="text/javascript" src="resources/js/jquery3.6.0.js"></script>
<script>
//해당 시간대의 이용시간이 종료하면 자동으로 DB 값을 다시 "empty"로 변경
$(document).ready(function(){
	var now = new Date();
	var hours = now.getHours();
	
	if(hours >= 13){
		$.ajax({
			type : "POST",
			url : "S_mTimeOver",
			data : { "hours" : hours },
			dataType : "text",
			async : false,
			success : function(data) {
			},
			error : function() {
				alert("현재 시간 새로고침 실패");
			}
		});
	} else if(hours >= 17){
		$.ajax({
			type : "POST",
			url : "S_aTimeOver",
			data : { "hours" : hours },
			dataType : "text",
			async : false,
			success : function(data) {
			},
			error : function() {
				alert("현재 시간 새로고침 실패");
			}
		});
	} else if(hours >= 21){
		$.ajax({
			type : "POST",
			url : "S_eTimeOver",
			data : { "hours" : hours },
			dataType : "text",
			async : false,
			success : function(data) {
			},
			error : function() {
				alert("현재 시간 새로고침 실패");
			}
		});
	}
	
});
</script>
</html>