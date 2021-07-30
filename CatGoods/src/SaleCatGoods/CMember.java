/**
	Date : 2021.07.22
	Author : seungseung
	Description : 고양이 용품 판매상점 만들기
	Version : 1.0
*/
package SaleCatGoods;

public class CMember {
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
*/  // 이 정보들로 필드에 데이터 타입과 변수 선언하기

// 데이터 베이스에 있는 칼럼들을 
// 클래스의 필드로 선언
private String ID;
private String PW;
private String NAME;
private int AGE;
private String PHONE;
private String C_NAME;
private int C_AGE;
private int C_WEI;
private String C_GENDER;
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
}
public String getPW() {
	return PW;
}
public void setPW(String pW) {
	PW = pW;
}
public String getNAME() {
	return NAME;
}
public void setNAME(String nAME) {
	NAME = nAME;
}
public int getAGE() {
	return AGE;
}
public void setAGE(int aGE) {
	AGE = aGE;
}
public String getPHONE() {
	return PHONE;
}
public void setPHONE(String pHONE) {
	PHONE = pHONE;
}
public String getC_NAME() {
	return C_NAME;
}
public void setC_NAME(String c_NAME) {
	C_NAME = c_NAME;
}
public int getC_AGE() {
	return C_AGE;
}
public void setC_AGE(int c_AGE) {
	C_AGE = c_AGE;
}
public int getC_WEI() {
	return C_WEI;
}
public void setC_WEI(int c_WEI2) {
	C_WEI = c_WEI2;
}
public String getC_GENDER() {
	return C_GENDER;
}
public void setC_GENDER(String c_GENDER) {
	C_GENDER = c_GENDER;
}
@Override
public String toString() {
	return "CMember [ID=" + ID + ", PW=" + PW + ", NAME=" + NAME + ", AGE=" + AGE + ", PHONE=" + PHONE + ", C_NAME="
			+ C_NAME + ", C_AGE=" + C_AGE + ", C_WEI=" + C_WEI + ", C_GENDER=" + C_GENDER + "]";
}
public CMember() {
	super();
}
public CMember(String iD, String pW, String nAME, int aGE, String pHONE, String c_NAME, int c_AGE, int c_WEI,
		String c_GENDER) {
	super();
	ID = iD;
	PW = pW;
	NAME = nAME;
	AGE = aGE;
	PHONE = pHONE;
	C_NAME = c_NAME;
	C_AGE = c_AGE;
	C_WEI = c_WEI;
	C_GENDER = c_GENDER;
}

}

