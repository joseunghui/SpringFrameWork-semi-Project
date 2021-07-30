/**
 		Date : 2021.07.22
 		Author : seungseung
 		Description : naver로그인 만들기
 		Version : 1.0
 */
package NaverID;

import java.util.Scanner;

public class NaverMain {

	public static void main(String[] args) {
		// 메뉴를 보여주고 실행하게끔 만들어주기
		
		Scanner sc = new Scanner(System.in);
		
		// DB접속용 객체 생성
		NaverSQL nsql = new NaverSQL();
		
		// 회원 가입을 위한 데이터를 담고 있는 NMember 객체 만들기 
		NMember nmember = new NMember();
		
		
		boolean run = true;
		int menu = 0;
		
		do {
			// 메뉴 만들기
			System.out.println("========================");
			System.out.println("1. DB접속     2. DB접속해제    3. 회원 가입  ");
			System.out.println("4. 회원 조회    5. 회원 정보 수정       6. 회원 삭제  ");
			System.out.println("7. 종료 ");
			System.out.println("========================");
			System.out.println();
			
			System.out.print("메뉴 선택 >>");
			// 메뉴 입력받기
			menu = sc.nextInt();
			
			// 각 메뉴 마다의 실행문 만들기
			switch(menu) {
			case 1 :  // DB접속
				// DB접속용 메소드 호출!
				nsql.connect();
				break;
				
			case 2 :  // DB접속 해제
				// DB접속 헤제용 기본메소드 호출!
				nsql.conClose();
				break;
				
			case 3 :  // 회원 가입
				System.out.println("회원 정보를 입력해주세요.");
				
				System.out.print("아이디>>");
				String N_ID = sc.next();
				
				System.out.print("비밀번호>>");
				String N_PW = sc.next();
				
				System.out.println("이름>>");
				String N_NAME = sc.next();
				
				System.out.print("생년월일 중 년도(4자리)>>");
				String year = sc.next();
				
				System.out.print("생년월일 중 월>>");
				int month = sc.nextInt();
				
				System.out.print("생년월일 중 일>>");
				int day = sc.nextInt();
				
				System.out.println("성별>>");
				String N_GENDER = sc.next();
				
				System.out.println("이메일>>");
				String N_EMAIL = sc.next();
				
				System.out.println("전화번호>>");
				String N_PHONE = sc.next();
				
				// 전역변수로 설정!(어디서나 쓸 수 있도록)
				String month1;
				String day1;
				
				// 월을 7로만 입력해도 07로 데이터가 들어가도록!
				if (month >= 10 ) {
					month1 = Integer.toString(month);
				} else {
					month1 = "0" + Integer.toString(month);
				}
				
				// 월을 7로만 입력해도 07로 데이터가 들어가도록!
				if (day >= 10 ) {
					day1 = Integer.toString(day);
				} else {
					day1 = "0" + Integer.toString(day);
				}
				
				
				// year, month, day 를 합쳐서 BIRTH 만들기
				String N_BIRTH = year + month1 + day1;
				//               2017 + 7 + 2 라면  => 20210702 로 들어가게 만듦!!
				
				
				// 입력받은 데이터 NMember 객체(클래스)에 담기
				nmember.setN_ID(N_ID);
				nmember.setN_PW(N_PW);
				nmember.setN_NAME(N_NAME);
				nmember.setN_BIRTH(N_BIRTH);
				nmember.setN_GENDER(N_GENDER);
				nmember.setN_EMAIL(N_EMAIL);
				nmember.setN_PHONE(N_PHONE);
				
				//System.out.println(nmember.toString());
				
				// nmember()의 데이터를 sql로 보내기
				nsql.memberJoin(nmember);
				
				break;
				
			case 4 :  // 회원 조회
				nsql.select();
				break;
				
			case 5 :  // 회원 정보 수정  // 가장 어려움
				// 아이디랑 비번을 알아야 수정가능
				System.out.println("아이디 비밀번호 조회");
				
				System.out.print("아이디>>");
				String id = sc.next();
				
				System.out.print("비밀번호>>");
				String pw = sc.next();
				
				boolean check = nsql.idCheck(id, pw);
				
				if (check) { // 아이디와 비번이 일치 O
					
					// 회원 정보 입력할때 코드 가져오기!
					System.out.println(id + "님의 회원 정보를 수정해주세요.");
					
					
					System.out.print("수정 비밀번호>>");
					String N_PW1 = sc.next();
					
					System.out.println("수정 이름>>");
					String N_NAME1 = sc.next();
					
					System.out.print("수정 생년월일 중 년도(4자리)>>");
					int year1 = sc.nextInt();
					
					System.out.print("수정 생년월일 중 월>>");
					int month3 = sc.nextInt();
					
					System.out.print("수정 생년월일 중 일>>");
					int day3 = sc.nextInt();
					
					System.out.println("수정 성별>>");
					String N_GENDER1 = sc.next();
					
					System.out.println("수정 이메일>>");
					String N_EMAIL1 = sc.next();
					
					System.out.println("전화번호>>");
					String N_PHONE1 = sc.next();
					
					
					// 전역변수로 설정!(어디서나 쓸 수 있도록)
					String month4;
					String day4;
					
					// 월을 7로만 입력해도 07로 데이터가 들어가도록!
					if (month3 >= 10 ) {
						month4 = Integer.toString(month3);
					} else {
						month4 = "0" + Integer.toString(month3);
					}
					
					// 월을 7로만 입력해도 07로 데이터가 들어가도록!
					if (day3 >= 10 ) {
						day4 = Integer.toString(day3);
					} else {
						day4 = "0" + Integer.toString(day3);
					}
					
					
					// year, month, day 를 합쳐서 BIRTH 만들기
					String N_BIRTH1 = year1 + month4 + day4;
					//               2017 + 7 + 2 라면  => 20210702 로 들어가게 만듦!!
					
					
					// 입력받은 데이터 NMember 객체(클래스)에 담기
					nmember.setN_ID(id);
					nmember.setN_PW(N_PW1);
					nmember.setN_NAME(N_NAME1);
					nmember.setN_BIRTH(N_BIRTH1);
					nmember.setN_GENDER(N_GENDER1);
					nmember.setN_EMAIL(N_EMAIL1);
					nmember.setN_PHONE(N_PHONE1);
					
					nsql.modify(nmember);
					
				} else {  // 아이디 비번이 일치 X
					System.out.println("아이디와 비빌번호가 일치하지 않습니다.");
				}
				break;
				
			case 6 :  // 회원 삭제
				// 아이디랑 비번을 알아야 삭제 가능
				System.out.println("아이디 비밀번호 조회");
				
				System.out.print("아이디>>");
				String id1 = sc.next();
				
				System.out.print("비밀번호>>");
				String pw1 = sc.next();
				
				boolean check1 = nsql.idCheck(id1, pw1);  // 회원 정보 체크!
				
				if(check1) {  //아이디와 비번이 일치 O
					nsql.delete(id1);
					
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
