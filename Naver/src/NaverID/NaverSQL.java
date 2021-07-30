/**
 		Date : 2021.07.22
 		Author : seungseung
 		Description : naver로그인 만들기
 		Version : 1.0
 */
package NaverID;

// 4개 모두 import java.sql.*; 로 통칭 가능
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NaverSQL {
	// SQL문을 DB에 보낼때 사용할 클래스
	// 쿼리문을 모아 놓은 클래스 NaverSQL
	
	// DB접속을 위한 변수 선언하기
	Connection con = null;
	
	// 쿼리문 전송을 위한 변수 선언하기 = > 작성할  SQL문에  ? 가 없다면 stmt 사용!
	Statement stmt = null;
	
	// 우리가 어떤 정보를 가져와서, 그 정보를 담아 DB에 넘기는 변수 선언! => 작성할  SQL문에? 있으면 pstmt 사용! 
	PreparedStatement pstmt = null;
	    // PreparedStatement : ? 를 문자로 인식할 예정! (잘 기억해두자)
	
	// 조회(SELECT)의 결과를 저장하기 위한 변수 선언
	ResultSet rs = null;
	
	// ====================================================
	
	// 1. DB접속 메소드
	public void connect() {
		// DB접속 변수인 con에 DBC에 있는 내용담기
		con = DBC.DBConnect();
		// 접속은 이게 끝!
	}
	
	// 2. DB접속 해제 메소드
	public void conClose() {
		// DBConnection 타입의 기본 메소드 사용  => try_catch문으로 생성하는 것만 눌려주면 됨
		try {
			con.close();
			// 접속 하지 않은 상태(=처음부터 메뉴2만 누르면)라면 
			// 초기값인 null이 들어가 있는 상태라서 
			// 실행 시켜줄 것이 없기 때문에 에러문구가 뜸!!!
			System.out.println("DB접속 해제!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	// 3. 회원가입 메소드
	public void memberJoin(NMember nmember) {
		System.out.println("회원가입 메소드로 잘 넘어왔는지 확인!");
		System.out.println(nmember);
		
		System.out.println("con : " + con);  // DB접속 전이면 => con : null 이라고 출력됨
		
		String sql = "INSERT INTO NAVER VALUES(?, ?, ?, TO_DATE(?), ?, ?, ?)";
		// 이문장은 디비에서 INSERT INTO NAVER VALUES('', '', '', TO_DATE(''), '',  '', ''); 만입력한 상태인 것!
		
		try {
			// DB에서  위에 써준 SQL문 작성하기
			// DB에 접속하기 전에는 con은 null 값이라서 오류가 발생함
			// SQL문에 ? 있으면 pstmt 사용! / 아니라면 stmt 사용!
			pstmt = con.prepareStatement(sql);
			
			// '' 안에 데이터 넣기!  -> parameterIndex는 ?의 순서를 말함, x는 넣을 값을 말함
			pstmt.setString(1, nmember.getN_ID());
			pstmt.setString(2, nmember.getN_PW());
			pstmt.setString(3, nmember.getN_NAME());
			pstmt.setString(4, nmember.getN_BIRTH());
			pstmt.setString(5, nmember.getN_GENDER());
			pstmt.setString(6, nmember.getN_EMAIL());
			pstmt.setString(7, nmember.getN_PHONE());
			
			// int result = 을 빼도 실행은 되지만 제대로 됐나 확인(if문)을 위해 int 로 선언
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("회원가입 성공!");	
			} else {
				System.out.println("회원가입 실패!");
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException 발생!");
			e.printStackTrace();
			
		} finally {  // try-catch에 상관없이 무조건 발생하도록 하는 finally를 이용해서 try문 닫아주기!!!
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// DB안에서 실행할 준비까지 된 것!
	}

	// 4. 회원 조회 메소드!
	public void select() {
		// 먼저 SQL문을 작성해주는 변수 만들기
		String sql = "SELECT * FROM NAVER";
		
		try {
			// SQL문에 ? 있으면 pstmt 사용! / 아니라면 stmt 사용!
			stmt = con.createStatement();
			// 위에 만들어준 rs에 작성한 SQL문을 넣어주는 것 => 정보를 담아주기
			rs = stmt.executeQuery(sql); // Resultset 타입의 executeQuery로 선언
			
			// 정보는 여러개가 있을 수 있으니 반복문 이용하기
			while (rs.next()) {  // 기록할 레코드가 더이상 존재하지 않을 때까지(rs의 개수 만큼) 반복하게 만들자
				
				System.out.println("아이디 : " + rs.getString(1));  // 1 혹은 "N_ID(칼럼이름)"라고 적어줘도 됨
				System.out.println("비밀번호 : " + rs.getString(2));
				System.out.println("이름 : " + rs.getString(3));
				System.out.println("생년월일 : " + rs.getString(4));
				System.out.println("성별 : " + rs.getString(5));
				System.out.println("이메일 : " + rs.getString(6));
				System.out.println("전화번호 : " + rs.getString(7));
				System.out.println();
			}
			
		} catch (SQLException e) {
			System.out.println("회원 조회 실패!");
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	// 5-1, 6-1 . 회원정보 수정, 삭제  > 아이디, 비밀번호 체크할 메소드
	public boolean idCheck(String id, String pw) {
		
		// (1) 메소드 데이터 타입과 같은 변수 만들기 (check는 boolean 타입!)
		boolean checkResult = false;
		
		
		String sql = "SELECT N_ID FROM NAVER WHERE N_ID = ? AND N_PW = ?"; 
		// NAVER 테이블의 ID를 모두 조회
		// 아이디와 비번이 일치해야지만 출력(AND이용)
		try {
			// SQL문에 ? 있으면 pstmt 사용! / 아니라면 stmt 사용!
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {  // 결과값(일치하는 회원이 있음)이 존재 O
				checkResult = true;
			} else {   // 결과값(일치하는 회원없음)이 존재 X
 				System.out.println(id + "로 등록된 회원 ID가 없습니다.");
 				checkResult = false;
			}  // if end
		} catch (SQLException e) {
			System.out.println("아이디와 비밀번호를 확인하세요.");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// (2) 만들어준 변수를 return 하기
		return checkResult;
	}
	
	// 5-2. 회원 정보 수정 메소드
	public void modify(NMember nmember) {

		String sql = "UPDATE NAVER SET N_PW = ?, N_NAME = ?, N_BIRTH = TO_DATE(?), N_GENDER = ?, N_EMAIL = ?, N_PHONE = ? WHERE N_ID = ?";
		try {
			// SQL문에 ? 있으면 pstmt 사용! / 아니라면 stmt 사용!
			pstmt = con.prepareStatement(sql);
			// 순서주의!!
			pstmt.setString(7, nmember.getN_ID());
			
			pstmt.setString(1, nmember.getN_PW());
			pstmt.setString(2, nmember.getN_NAME());
			pstmt.setString(3, nmember.getN_BIRTH());
			pstmt.setString(4, nmember.getN_GENDER());
			pstmt.setString(5, nmember.getN_EMAIL());
			pstmt.setString(6, nmember.getN_PHONE());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("회원 정보 수정 성공!");
			} else {
				System.out.println("회원 정보 수정 실패!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	// 6-2. 회원 삭제 메소드
	public void delete(String id1) {
		// 아이디만 가져오기
		
		// SQL문 먼저 작성하기 (삭제 DELETE 사용)
		String sql = "DELETE NAVER WHERE N_ID = ?";
		try {
			// SQL문에 ? 있으면 pstmt 사용! / 아니라면 stmt 사용!
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id1);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("회원정보 삭제 성공!");
			} else {
				System.out.println("회원정보 삭제 실패!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {  // 다시 try문으로 닫기 close()
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}	
}
