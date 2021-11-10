package com.GROUP4.Library.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.GROUP4.Library.dto.Spot;

@Repository
public class sDAO {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	// �¼� �ִ� �̿�ð� ��� �� ������ �� "empty"�� ����
	public int mTimeOver() {
		return sql.update("Spot.mTimeOver");
	}
	public int aTimeOver() {
		return sql.update("Spot.aTimeOver");
	}
	public int eTimeOver() {
		return sql.update("Spot.eTimeOver");
	}
	
	
	// �ش� �¼��� �ð��� ��������
	public String sReservNo(String SNo) {
		return sql.selectOne("Spot.sReservNo", SNo);
	}
	
	// �¼��� �ð��� ���� "empty"���� Ȯ��
	// �ش� �¼� ��ȣ�� MTime �ð���
	public String mtimeCheck(String SNo) {
		return sql.selectOne("Spot.mtimeCheck", SNo);
	}
	// �ش� �¼� ��ȣ�� ATime �ð���
	public String atimeCheck(String SNo) {
		return sql.selectOne("Spot.atimeCheck", SNo);
	}
	// �ش� �¼� ��ȣ�� ETime �ð���
	public String etimeCheck(String SNo) {
		return sql.selectOne("Spot.etimeCheck", SNo);
	}

	
	// ������ �¼� ����
	public String reservMTime(String SNo, String MId) {
		sql.update("Spot.reservMTimeR",SNo);
		sql.update("Spot.reservMTimeP", MId);
		return sql.selectOne("Spot.reservMTime", MId);
	}
	public String reservATime(String SNo, String MId) {
		sql.update("Spot.reservATimeR",SNo);
		sql.update("Spot.reservATimeP", MId);
		return sql.selectOne("Spot.reservATime", MId);
	}

	public String reservETime(String SNo, String MId) {
		sql.update("Spot.reservETimeR",SNo);
		sql.update("Spot.reservETimeP", MId);
		return sql.selectOne("Spot.reservETime", MId);
	}

	// ���� ������ �̿���Ȳ
	public List<Spot> myReserv(String MId) {
		return sql.selectList("Spot.myReserv", MId);
	}

	// ���� ���
	public int reservDel(String MId) {
		return sql.update("Spot.reservDel", MId);
	}


}
