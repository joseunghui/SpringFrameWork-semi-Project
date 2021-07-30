/**
	Date : 2021.07.22
	Author : seungseung
	Description : 고양이 용품 판매상점 만들기
	Version : 1.0
*/
package SaleCatGoods;
import java.util.Scanner;
public class SCGMain {

	public static void main(String[] args) {
		// 메뉴를 보여주고 실행하게끔 만들어주기
		Scanner sc = new Scanner(System.in);
		
		// DB접속용 객체 생성
		SCGSQL ssql = new SCGSQL();
		
		// 회원 가입을 위한 데이터를 담고 있는 NMember 객체 만들기 
		CMember cmember = new CMember();
				
		boolean run = true;
		int menu = 0;	
		do {
			// 메뉴 만들기
			System.out.println("========================");
			System.out.println("1. DB접속            2. DB접속해제");
			System.out.println("3. 회원 가입         4. 회원 정보 조회           5. 회원 정보 수정          6. 회원 정보 삭제");
			System.out.println("7. 프로그램 종료");
			System.out.println("========================");
			System.out.println();
					
			System.out.print("메뉴 선택 >>");
			// 메뉴 입력받기
			menu = sc.nextInt();
					
			// 각 메뉴 마다의 실행문 만들기
			switch(menu) {
			case 1 :  // DB접속
				// DB접속용 메소드 호출!
				ssql.connect();
				break;
						
			case 2 :  // DB접속 해제
				// DB접속 해제용 기본메소드 호출!
				ssql.conClose();
				break;
						
			case 3 :  // 회원 가입
				// 아이디는 여기서 따로 입력받고, 나머지 회원 정보는 회원가입 메소드에서 입력받기!
				System.out.println("회원 가입을 시작합니다.");
				
				System.out.print("아이디>>");
				String ID = sc.next();
				
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
				cmember.setID(ID);
				cmember.setPW(PW);
				cmember.setNAME(NAME);
				cmember.setAGE(AGE);
				cmember.setPHONE(PHONE);
				cmember.setC_NAME(C_NAME);
				cmember.setC_AGE(C_AGE);
				cmember.setC_WEI(C_WEI);
				cmember.setC_GENDER(C_GENDER);
				
				//System.out.println(nmember.toString());
				
				// cmember()의 데이터를 sql로 보내기
				ssql.memberJoin(cmember); 
				break;
				
			case 4 :  // 회원 조회
				ssql.select();
				break;
				
			case 5 : // 회원 정보 수정  // 가장 어려움
				// 아이디랑 비번을 알아야 수정가능
				System.out.println("아이디 비밀번호 조회");
				
				System.out.print("아이디>>");
				String id = sc.next();
				
				// 아이디가 회원 정보에 없으면 일치하는 회원이 없습니다. 문구 뜨게 하기!
				boolean idchec = ssql.onlyidCheck(id);
				
				if(idchec) {
					System.out.print("비밀번호>>");
					String pw = sc.next();
				
					boolean check = ssql.idpwCheck(pw);
				
				
					if (check) { // 아이디와 비번이 일치 O
					
						// 회원 정보 입력할때 코드 가져오기!
						System.out.println(id + "님의 회원 정보를 수정해주세요.");
					
						System.out.print("수정할 비밀번호>>");
						String PW1 = sc.next();
					
						System.out.println("수정할 이름>>");
						String NAME1 = sc.next();
					
						System.out.print("수정할 나이>>");
						int AGE1 = sc.nextInt();
					
						System.out.print("수정할 번호>>");
						String PHONE1 = sc.next();
					
						System.out.println("==========반려묘 정보 수정하기==========");
					
						System.out.print("수정할 이름>>");
						String C_NAME1 = sc.next();
					
						System.out.println("수정할 나이>>");
						int C_AGE1 = sc.nextInt();
					
						System.out.println("수정할 몸무게>>");
						int C_WEI1 = sc.nextInt();
					
						System.out.println("수정할 성별>>");
						String C_GENDER1 = sc.next();
					
						// 입력받은 데이터 NMember 객체(클래스)에 담기
						cmember.setID(id);
						cmember.setPW(PW1);
						cmember.setNAME(NAME1);
						cmember.setAGE(AGE1);
						cmember.setPHONE(PHONE1);
						cmember.setC_NAME(C_NAME1);
						cmember.setC_AGE(C_AGE1);
						cmember.setC_WEI(C_WEI1);
						cmember.setC_GENDER(C_GENDER1);
					
						ssql.modify(cmember);
					
				}	else {  //비번이 일치 X
					System.out.println("비빌번호가 일치하지 않습니다.");
				}
				}
				break;
				
			case 6 :  // 회원 삭제	
				// 아이디랑 비번을 알아야 삭제 가능
				System.out.println("아이디 비밀번호 조회");
				
				System.out.print("아이디>>");
				String id1 = sc.next();
				
				System.out.print("비밀번호>>");
				String pw1 = sc.next();
				
				boolean check1 = ssql.idpwCheck(pw1);   // 회원 정보 체크!
				
				if(check1) {  //아이디와 비번이 일치 O
					ssql.delete(id1);
					
				} else {  // 비밀번호가 일치하지 X
					System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
				}
								
				break;
						
			case 7 :  // 종료
				System.out.println("시스템을 종료합니다.");
				run = false;
				break;
			
		default :
			System.out.println("잘 못 입력하셨습니다. \n다시 입력해주세요!");
			break;
		}
			
	} while(run);
 }	
}

