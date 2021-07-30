/**
 		Date : 2021.07.22
 		Author : seungseung
 		Description : naver로그인 만들기
 		Version : 1.0
 */
/*
CREATE TABLE NAVER(
    N_ID        NVARCHAR2(20),
    N_PW        NVARCHAR2(16),
    N_NAME      NVARCHAR2(5),
    N_BIRTH     DATE,
    N_GENDER    NVARCHAR2(2),
    N_EMAIL     NVARCHAR2(50),
    N_PHONE     NVARCHAR2(20)
);
-- > 회원가입 서비스를 이용하려면 각 칼럼을 자바에서 
-- > 클래스로 다 만들어주고 데이터 타입도 맞게 해줘야함
-- > DATE는 String으로 넘기고 받아줘야함!!!
 */
package NaverID;

public class NMember {
	// 데이터 베이스에 있는 칼럼들을 
	// 클래스의 필드로 선언
	private String N_ID;
	private String N_PW;
	private String N_NAME;
	private String N_BIRTH;
	private String N_GENDER;
	private String N_EMAIL;
	private String N_PHONE;
	
	
		//getter, setter
	
	public String getN_ID() {
		return N_ID;
	}
	public void setN_ID(String n_ID) {
		N_ID = n_ID;
	}
	public String getN_PW() {
		return N_PW;
	}
	public void setN_PW(String n_PW) {
		N_PW = n_PW;
	}
	public String getN_NAME() {
		return N_NAME;
	}
	public void setN_NAME(String n_NAME) {
		N_NAME = n_NAME;
	}
	public String getN_BIRTH() {
		return N_BIRTH;
	}
	public void setN_BIRTH(String n_BIRTH) {
		N_BIRTH = n_BIRTH;
	}
	public String getN_GENDER() {
		return N_GENDER;
	}
	public void setN_GENDER(String n_GENDER) {
		N_GENDER = n_GENDER;
	}
	public String getN_EMAIL() {
		return N_EMAIL;
	}
	public void setN_EMAIL(String n_EMAIL) {
		N_EMAIL = n_EMAIL;
	}
	public String getN_PHONE() {
		return N_PHONE;
	}
	public void setN_PHONE(String n_PHONE) {
		N_PHONE = n_PHONE;
	}
	

	
	
	// toString
	// 엄청 필요한건 아니지만 공부하는 거니까 만들어주기!
	@Override
	public String toString() {
		return "NMember [N_ID=" + N_ID + ", N_PW=" + N_PW + ", N_NAME=" + N_NAME + ", N_BIRTH=" + N_BIRTH
				+ ", N_GENDER=" + N_GENDER + ", N_EMAIL=" + N_EMAIL + ", N_PHONE=" + N_PHONE + "]";
	}
	
	
	
	// constructor
	// 기본생성자
	public NMember() {
		super();
	}
	
	
	
	// 매개변수 생성자
	public NMember(String n_ID, String n_PW, String n_NAME, String n_BIRTH, String n_GENDER, String n_EMAIL,
			String n_PHONE) {
		super();
		N_ID = n_ID;
		N_PW = n_PW;
		N_NAME = n_NAME;
		N_BIRTH = n_BIRTH;
		N_GENDER = n_GENDER;
		N_EMAIL = n_EMAIL;
		N_PHONE = n_PHONE;
	}
	


}
