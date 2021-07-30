/**
	Date : 2021.07.22
	Author : seungseung
	Description : 고양이 용품 판매상점 만들기
	Version : 1.0
*/
package SaleCatGoods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//=> import java.sql.*; 이렇게 해줘도 됨!!!


public class DBC {

// # 메소드를 만들면
// 1. 메소드의 데이터 타입과 같은 객체 생성
// 2. 생성한 객체를 return 하기

public static Connection DBConnect() {
// DB에 접속 정보 저장을 위한 Connection타입의 변수 con 선언
Connection con = null;

// 접속할 DB의 계정 정보
String user = "SEUNG";
String password = "1234";

// 접속할 DB의 주소 정보
String url = "jdbc:oracle:thin:@localhost:1521:XE";

// 실제 접속
try {
	// DB 접속 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	// SQL
	con = DriverManager.getConnection(url, user, password);
	
	System.out.println("DB 접속 성공!");
	
} catch(ClassNotFoundException cne) {  	// DB 접속 실패시 예외 처리
	System.out.println("DB 접속 실패 : 드라이버 로딩 실패");
	cne.printStackTrace();
	
} catch(SQLException se) {  			// DB 접속 실패시 예외 처리
	System.out.println("DB 접속 실패 : DB 계정 주소 확인 필요");
	se.printStackTrace();
}

// 리턴 값을 con으로 해주기
return con;	
}

}