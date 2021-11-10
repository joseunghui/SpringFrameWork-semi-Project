<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link href="resources/bootstrap/assets/styles.css" rel="stylesheet"/>
    <link href="resources/bootstrap/css/styles.css" rel="stylesheet"/>
   
<title>Spot_Reservation</title>
</head>

<body>
<!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
        <div>
        	<a href="javascript:history.back();"><h3 style="color: white">ICIA LIBRARY</h3></a>
        </div>
    </nav>
    <div style="padding: 40px">
		<h2>${sessionScope.loginId} 님의 열람실 좌석 예약 페이지입니다.</h2>
		</br></br>
		
		<div id="reservArea"></div>
		
		
		<span> 
			<button type="button" id="SNo" name="SNo" onclick="spotCheck('A1')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">A1
			</button> 
					<button type="button" id="SNo" name="SNo" onclick="spotCheck('A2')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">A2
			</button> 
					<button type="button" id="SNo" name="SNo" onclick="spotCheck('A3')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">A3
			</button> 
					<button type="button" id="SNo" name="SNo" onclick="spotCheck('A4')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">A4
			</button> 
					<button type="button" id="SNo" name="SNo" onclick="spotCheck('A5')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">A5
			</button> 
			
		</span>
		</br></br>
		<br><br>
		<span> 			 
			<button type="button" id="SNo" name="SNo" onclick="spotCheck('B1')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">B1
			</button> 
			
			<button type="button" id="SNo" name="SNo" onclick="spotCheck('B2')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">B2
			</button> 
			
			<button type="button" id="SNo" name="SNo" onclick="spotCheck('B3')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">B3
			</button> 
			<button type="button" id="SNo" name="SNo" onclick="spotCheck('B4')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">B4
			</button> 
			<button type="button" id="SNo" name="SNo" onclick="spotCheck('B5')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">B5
			</button> 
		</span>
		</br></br>
		<br><br>
		<span> 
			<button type="button" id="SNo" name="SNo" onclick="spotCheck('C1')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">C1
			</button> 
					<button type="button" id="SNo" name="SNo" onclick="spotCheck('C2')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">C2
			</button> 
					<button type="button" id="SNo" name="SNo" onclick="spotCheck('C3')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">C3
			</button> 
					<button type="button" id="SNo" name="SNo" onclick="spotCheck('C4')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">C4
			</button> 
					<button type="button" id="SNo" name="SNo" onclick="spotCheck('C5')">
				<img style="width:45px; height:45px;" src="resources/image/desk.png">C5
			</button> 
		</span>
		</br></br>
		
		<div id="selectSpot"></div>
		<br>
		<div id="spotReserv1"></div>
		<div id="spotReserv2"></div>
		<br>
		
		<button onclick="location.href='S_reservDelete?MId=${sessionScope.loginId}'">예약 취소하기</button>
		<input type="hidden" id="MId" name="MId" value="${sessionScope.loginId}" />
	</div>
</body>
<script type="text/javascript" src="resources/bootstrap/js/scripts.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/jquery3.6.0.js"></script>
<script type="text/javascript">

 	// 페이지 새로고침
	function refreshPage(){
		location.reload();
	} 

	// 좌석 번호 누르면 시간대별 버튼 보이기
	function spotCheck(sno) {
		var now = new Date();
		var hours = now.getHours();
		
		var SNo = sno;
		
		let MId = '${sessionScope.loginId}';
		let spotReserv1 = document.getElementById("spotReserv1");
		let spotReserv2 = document.getElementById("spotReserv2");

		$.ajax({
			type : "POST",
			url : "S_Reservation",
			data : {
				"SNo" : SNo,
				"MId" : MId,
				"hours" : hours
			},
			dataType : "text",
			async : false,
			success : function(data) {
				// 성공
				selectSpot.innerHTML = "아이디는 " + MId + " 선택한 좌석은 " + SNo + "입니다.";
				spotReserv1.innerHTML = "<input type='hidden' id='SNo' name='SNo' value='" + SNo + "'>";
				timeList(sno);
			},
			error : function() {
				// 실패
				alert("spotCheck 함수 통신 실패!");
			}
		});
		
	}
	
	// 해당 좌석을 누르면 시간대를 선택할 수 있는 버튼이 뜨는 것
	function timeList(sno) {
		var now = new Date();
		var hours = now.getHours();
		
		let SNo = sno;
		let MId = '${sessionScope.loginId}';
		let output = "";

		output += "<input type='hidden' id='SNo' name='SNo' value='" + SNo + "'>";
		output += "<input type='hidden' id='MId' name='MId' value='" + SNo + "'>";

		if(hours < 12 && hours >= 08){
			output += "<input type='button' id='MTime' value='08시 - 12시'>";
			output += "</br>";
			output += "<input type='button' id='ATime' value='12시 - 16시'>";
			output += "</br>";
			output += "<input type='button' id='ETime' value='16시 - 20시'>";
			output += "</br>";
		} else if(hours < 16 && hours >= 12){
			output += "<input type='button' id='MTime' disabled value='08시 - 12시'>";
			output += "</br>";
			output += "<input type='button' id='ATime' value='12시 - 16시'>";
			output += "</br>";
			output += "<input type='button' id='ETime' value='16시 - 20시'>";
			output += "</br>";
		} else if(hours < 20 && hours >= 16){
			output += "<input type='button' id='MTime' disabled value='08시 - 12시'>";
			output += "</br>";
			output += "<input type='button' id='ATime' disabled value='12시 - 16시'>";
			output += "</br>";
			output += "<input type='button' id='ETime' value='16시 - 20시'>";
			output += "</br>";
		} else {
			output += "<h4>열람실 이용 시간이 종료 되었습니다.</h4>";
			output += "</br>";
		}
		$("#spotReserv2").html(output);

		// MTime버튼을 누르면 그 시간대를 예약하도록 하는 것
		$("#MTime").click(
				function() {

					$.ajax({
						type : "POST",
						url : "S_mtimeCheck",
						data : {
							"SNo" : SNo,
							"MId" : MId
						},
						dataType : "text",
						async : false,
						success : function(result) {
							// 성공 
							if (result == MId) {
								var input = confirm("좌석 번호는 " + SNo
										+ "\n이용 시간은 08 - 12시\n예약 하시겠습니까?");
								if (input == true) {
									alert("해당 좌석이 예약되었습니다.");
									refreshPage();
								} else {
									alert("예약이 취소 되었습니다.");
								}
							} else if(result != MId) {
								alert("해당 좌석은 이미 사용 중 입니다.");
							}
						},
						error : function() {
							// 실패
							alert("좌석 이용시간은 최대 4시간 입니다.");
						}
					});

				})
		// ATime버튼을 누르면 그 시간대를 예약하도록 하는 것
		$("#ATime").click(
				function() {

					$.ajax({
						type : "POST",
						url : "S_atimeCheck",
						data : {
							"SNo" : SNo,
							"MId" : MId
						},
						dataType : "text",
						async : false,
						success : function(result) {
							// 성공 
							if (result == MId) {
								var input = confirm("좌석 번호는 " + SNo
										+ "\n이용 시간은 12 - 16시\n예약 하시겠습니까?");
								if (input == true) {
									alert("해당 좌석이 예약되었습니다.");
									refreshPage();
								} else{
									alert("예약이 취소 되었습니다.");
								}
							} else if(result != MId) {
								alert("해당 좌석은 이미 사용 중 입니다.");
							}

						},
						error : function() {
							// 실패
							alert("좌석 이용시간은 최대 4시간 입니다.");
						}
					});

				})
		// ETime버튼을 누르면 그 시간대를 예약하도록 하는 것
		$("#ETime").click(
				function() {

					$.ajax({
						type : "POST",
						url : "S_etimeCheck",
						data : {
							"SNo" : SNo,
							"MId" : MId
						},
						dataType : "text",
						async : false,
						success : function(result) {
							// 성공 
							if (result == MId) {
								var input = confirm("좌석 번호는 " + SNo
										+ "\n이용 시간은 16 - 20시\n예약 하시겠습니까?");
								if (input == true) {
									alert("해당 좌석이 예약되었습니다.");
									refreshPage();
								} else {
									alert("예약이 취소 되었습니다.");
								}
							} else if(result != MId) {
								alert("해당 좌석은 이미 사용 중 입니다.");
							}
						},
						error : function() {
							// 실패
							alert("좌석 이용시간은 최대 4시간 입니다.");
						}
					});
				})
				
	}
	
	
	// 예약 현황 조회하기
	$(document).ready(function(){
		let MId = '${sessionScope.loginId}';
		$.ajax({
			type : "POST",
			url : "S_myTime",
			data : { "MId" : MId },
			dataType : "json",
			success : function(data) {
				// 성공
				myReserv(data);
			} ,
			error : function() {
				// 실패
				alert("예약 여부 불러오기 실패!");
			} 
		});
	});	
	// 조회한 예약 현황을 현재 jsp에 HTML로 띄우기
	function myReserv(data){
		let output = "";

		output += "<h3>&lt;열람실 예약 현황&gt;</h3>";
		
		if( data[0] ){
			if (data[0].MTime != "empty"){
				output += "예약하신 좌석은 " + data[0].SNo + "시간은 8-12시 입니다.";
				output += "</br>";
			} else if(data[0].ATime != "empty"){
				output += "예약하신 좌석은 " + data[0].SNo + "시간은 12-16시 입니다.";
				output += "</br>";
			} else if(data[0].ETime != "empty"){
				output += "예약하신 좌석은 " + data[0].SNo + "시간은 16-20시 입니다.";
				output += "</br>";
			} else{
				output += "예약 내역이 없습니다.";
			}
		}
		$("#reservArea").html(output);
	}
</script>
</html>