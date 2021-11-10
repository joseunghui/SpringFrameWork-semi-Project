package com.GROUP4.Library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.GROUP4.Library.dto.Book;
import com.GROUP4.Library.service.bService;

@Controller
public class bController {
	@Autowired
	private bService bsvc;

	@Autowired
	JavaMailSender mailsender;

	private ModelAndView mav = new ModelAndView();
	
	// ���� ����Ʈ
	@RequestMapping(value = "/b_BookList", method = RequestMethod.GET)
	public ModelAndView bBookList() {
		mav = bsvc.bBookList();
		return mav;
	}

	// ���� �뿩
	@RequestMapping(value = "/b_bookRent", method = RequestMethod.POST)
	public ModelAndView bbookRent(@ModelAttribute Book book) {
		System.out.println(book.toString());
		mav = bsvc.bBookRent(book);
		return mav;
	}

	// ���� �뿩 Ȯ��
	@RequestMapping(value = "/b_bookCheck", method = RequestMethod.GET)
	public ModelAndView bbookCheck(@RequestParam String MId) {
		System.out.println("��Ʈ�ѷ�" + MId);
		mav = bsvc.bbookCheck(MId);
		return mav;
	}

	// ���� �ݳ�
	@RequestMapping(value = "/b_BookReturn", method = RequestMethod.POST)
	public ModelAndView bBookReturn(@RequestParam(name = "bookReturn") List<Integer> KNo) {
		System.out.println(KNo);
		mav = bsvc.bBookReturn(KNo);
		return mav;
	}
}

