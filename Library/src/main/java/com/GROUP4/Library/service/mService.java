package com.GROUP4.Library.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.GROUP4.Library.dao.mDAO;
import com.GROUP4.Library.dto.Member;

@Service
public class mService {
	
	@Autowired
	private mDAO dao;

	@Autowired
	private HttpSession session;

	@Autowired
	private BCryptPasswordEncoder pwEnc;

	private ModelAndView mav = new ModelAndView();

	// ȸ������
	public ModelAndView mJoin(Member member) throws IllegalStateException, IOException {

		// ���� �̸� ��������(MProfile�� ���� ��ü, MProfileName�� �����̸�)
		// MProfile > MProfileName
		MultipartFile MProfile = member.getMProfile();
		String MProfileName = MProfile.getOriginalFilename();

		// �ּ� ��ġ��
		member.setMAddr("(" + member.getAddr1() + ") " + member.getAddr2() + ", " + member.getAddr3());

		// location D:\springWorksapce\MEMBOARD
		// ���� ������ġ
		String savePath = "C:/Users/ooo16/Downloads/sts-4.11.1.RELEASE/springFile/Library/src/main/webapp/resources/MemProfile/"
				+ MProfileName;

		// ������ ���õƴٸ�
		if (!MProfile.isEmpty()) {
			member.setMProfileName(MProfileName);
			MProfile.transferTo(new File(savePath));
		}

		// ��ȣȭ
		member.setMPw(pwEnc.encode(member.getMPw()));

		// ����
		String Mmonth = "";
		if (member.getMonth() <= 9) {
			Mmonth = "0" + member.getMonth();
		} else {
			Mmonth = "" + member.getMonth();
		}
		String birth = member.getYear() + "-" + Mmonth + "-" + member.getDay();

		member.setMBirth(birth);

		System.out.println(member.toString());

		int result = dao.mJoin(member);

		if (result > 0) {
			mav.setViewName("m_Login");
		} else {
			mav.setViewName("index");
		}

		return mav;
	}

	// �α���
	public ModelAndView mLogin(Member member) {
		
		Member encPw = dao.mLogin(member.getMId());
		if(encPw.getMPw() == null) {
			mav.setViewName("m_Login");
			return mav;
		}
		
		
		if (pwEnc.matches(member.getMPw(), encPw.getMPw())) {
			session.setAttribute("loginId", encPw.getMId());
			session.setAttribute("profile", encPw.getMProfileName());
			mav.setViewName("index");
		} else {
			mav.setViewName("m_Login");
		}

		return mav;
	}

	// ��������
	public ModelAndView mView(String MId, int page) {

		Member member = dao.mView(MId);

		mav.addObject("view", member);
		mav.addObject("page", page);
		mav.setViewName("m_View");
		return mav;
	}

	// ȸ�� ���� ������ �̵�
	public ModelAndView m_modiForm(String MId, int page) {

		Member member = dao.mView(MId);

		mav.addObject("modify", member);
		mav.addObject("page", page);
		mav.setViewName("m_Modify");
		return mav;
	}

	// ����
	public ModelAndView mDelete(String MId, int page) {

		int result = dao.mDelete(MId);

		if (result > 0) {
			session.invalidate();
			mav.setViewName("redirect:/M_list?page=" + page);
		} else {
			mav.setViewName("index");
		}

		return mav;
	}

	// ����
	public ModelAndView m_modify(Member member, int page) throws IllegalStateException, IOException {

		MultipartFile MProfile = member.getMProfile();
		String MProfileName = MProfile.getOriginalFilename();

		// ���� ������ġ
		String savePath = "" + MProfileName;

		if (!MProfile.isEmpty()) {
			member.setMProfileName(MProfileName);
			MProfile.transferTo(new File(savePath));
		}

		int result = dao.mModify(member);

		if (result > 0) {
			mav.setViewName("redirect:/m_view?MId=" + member.getMId() + "&page=" + page);
		} else {
			mav.setViewName("index");
		}

		return mav;
	}
}
