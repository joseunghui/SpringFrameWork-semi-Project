package com.GROUP4.Library.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.GROUP4.Library.dto.Board;
import com.GROUP4.Library.service.BoService;

@Controller
public class BoController {

	@Autowired
	private BoService bsvc;

	@Autowired
	private HttpSession session;

	private ModelAndView mav = new ModelAndView();

	@RequestMapping(value = "B_writeForm", method = RequestMethod.GET)
	public String B_writeForm(@RequestParam("MId") String Mid, Board board) {
		session.setAttribute("loginId", Mid);
		return "B_Write";
	}

	@RequestMapping(value = "/B_write", method = RequestMethod.POST)
	public ModelAndView bWrite(@ModelAttribute Board board) throws IllegalStateException, IOException {
		mav = bsvc.bWrite(board);
		return mav;
	}

	@RequestMapping(value = "/B_list")
	public ModelAndView bList(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		if (page <= 0) {
			page = 1;
		}
		mav = bsvc.bList(page);
		return mav;
	}

	@RequestMapping(value = "/B_view")
	public ModelAndView bView(@RequestParam("BNo") int BNo, @RequestParam(value = "paging", required = false, defaultValue = "1") int page) {
		Board board = new Board();
		mav = bsvc.bView(BNo, page);
		return mav;
	}

	@RequestMapping(value = "/B_modiForm", method = RequestMethod.GET)
	public ModelAndView bModiForm(@RequestParam("BNo") int BNo, @RequestParam(value = "paging", required = false, defaultValue = "1") int page) throws IllegalStateException, IOException {
		mav = bsvc.bModiForm(BNo, page);
		return mav;
	}

	@RequestMapping(value = "/B_modi", method = RequestMethod.POST)
	public ModelAndView bModi(@ModelAttribute Board board, @RequestParam(value = "paging", required = false, defaultValue = "1") int page) throws IllegalStateException, IOException {
		mav = bsvc.bModi(board, page);
		return mav;
	}
	
	@RequestMapping(value="/B_delete", method = RequestMethod.GET)
	public ModelAndView bDel(@RequestParam("BNo") int BNo,  @RequestParam(value="paging", required=false, defaultValue="1") int page) {
		mav = bsvc.bDel(BNo, page);
		return mav;
	}

}
