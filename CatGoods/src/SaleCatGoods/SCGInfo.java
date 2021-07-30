/**
	Date : 2021.07.22
	Author : seungseung
	Description : 고양이 용품 판매상점 만들기
	Version : 1.0
*/

package SaleCatGoods;

import java.util.Scanner;

public class SCGInfo {
	/*CREATE TABLE SCG(
		    ID          NVARCHAR2(20),
		    PW          NVARCHAR2(20),
		    NAME        NVARCHAR2(20),
		    AGE         NUMBER(10),
		    PHONE       NVARCHAR2(20),
		    C_NAME      NVARCHAR2(20),
		    C_AGE       NUMBER(5),
		    C_WEI       NUMBER(3),
		    C_GENDER    NVARCHAR2(10)
		);
	*/
	SCGInfo info = new SCGInfo();
	
	public void insert() {
		Scanner sc = new Scanner(System.in);
		System.out.println("회원 정보를 입력해주세요.");
		
		System.out.print("비밀번호 >>");
		String PW = sc.next();
		
		System.out.println("이름 >>");
		String NAME = sc.next();
		
		System.out.print("나이 >>");
		int AGE = sc.nextInt();
		
		System.out.print("전화번호 >>");
		String PHONE = sc.next();
		
		System.out.println("======================");
		System.out.println("Cat 정보를 입력합니다.");
		
		System.out.print("고양이 이름 >>");
		String C_NAME = sc.next();
		
		System.out.println("고양이 나이(주 단위로 입력) || ex) 10(주) >>");
		int C_AGE = sc.nextInt();
		
		System.out.println("고양이 몸무게 (kg단위)>>");
		int C_WEI = sc.nextInt();
		
		System.out.println("고양이 성별 >>");
		String C_GENDER = sc.next();
		
		// 입력받은 데이터 info 객체(클래스)에 담기
		info.setPW(PW);
		info.setNAME(NAME);
		info.setAGE(AGE);
		info.setPHONE(PHONE);
		info.setC_NAME(C_NAME);
		info.setC_AGE(C_AGE);
		info.setC_WEI(C_WEI);
		info.setC_GENDER(C_GENDER);
		
		//System.out.println(nmember.toString());
		
		// info()의 데이터를 sql로 보내기
		ssql.memberJoin(info);
		
	}

	

}
