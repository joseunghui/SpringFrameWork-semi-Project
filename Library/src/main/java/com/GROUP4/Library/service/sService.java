package com.GROUP4.Library.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.GROUP4.Library.dao.sDAO;
import com.GROUP4.Library.dto.Spot;

@Service
public class sService {
	
	@Autowired
	private sDAO dao;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav = new ModelAndView();

	// �ش� �¼��� �̿� �ð��밡 �����ϸ� �� �ð����� �¼��� ��� "empty�� ����"
	// 13��
	public int mTimeOver(String hours) {
		int result = dao.mTimeOver();
		return result;
	}
	// 17��
	public int aTimeOver(String hours) {
		int result = dao.aTimeOver();
		return result;
	}
	// 21��
	public int eTimeOver(String hours) {
		int result = dao.eTimeOver();
		return result;
	}
	
	
	
	// �ش� �¼� ��ȣ�� Ŭ���ϸ� �ð��븦 ��������
	public String sReservNo(String SNo) {
		String checkSNo = dao.sReservNo(SNo);
		return checkSNo;
	}

	// ������ �¼� ���� : String result�� 'empty'���� Ȯ�� ��, empty��� �ش� ���̵�� �����ϱ�
	// MTime == "empty"?
	public String mtimeCheck(String SNo, String MId) {
		String check = dao.mtimeCheck(SNo);
		String result = null;
		if (check.equals("empty")) {
			result = reservMTime(SNo, MId);
		} else {
			System.out.println("�ش���� ����!");
		}
		return result;
	}
	// ATime == "empty"?
	public String atimeCheck(String SNo, String MId) {
		String check = dao.atimeCheck(SNo);
		String result = null;
		if (check.equals("empty")) {
			result = reservATime(SNo, MId);
		} else {
			System.out.println("�ش���� ����!");
		}
		return result;
	}
	// ETime == "empty"?
	public String etimeCheck(String SNo, String MId) {
		String check = dao.etimeCheck(SNo);
		String result = null;
		if (check.equals("empty")) {
			result = reservETime(SNo, MId);
		} else {
			System.out.println("�ش���� ����!");
		}
		return result;
	}

	
	// �ش� ���̵�� �¼� �����ϱ�
	public String reservMTime(String SNo, String MId) {
		String result = dao.reservMTime(SNo, MId);
		return result;
	}
	public String reservATime(String SNo, String MId) {
		String result = dao.reservATime(SNo, MId);
		return result;
	}
	public String reservETime(String SNo, String MId) {
		String result = dao.reservETime(SNo, MId);
		return result;
	}

	// ���������� -> ���� ������ �̿���Ȳ Ȯ��
	public List<Spot> myReserv(String MId) {
		List<Spot> spotList = dao.myReserv(MId);
		return spotList;
	}

	// ���������� -> ���� ���
	public ModelAndView  reservDel(String MId) {
		int result = dao.reservDel(MId);
		if(result>0) {
			mav.setViewName("redirect:/S_reservForm?MId=" + MId);
		} else {
			mav.setViewName("index");
		}
		return mav;
	}

}
