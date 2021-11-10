package com.GROUP4.Library.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.GROUP4.Library.dao.BoDAO;
import com.GROUP4.Library.dto.Board;
import com.GROUP4.Library.dto.Page;


@Service
public class BoService {
	
	@Autowired
	private BoDAO dao;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav = new ModelAndView();

	public ModelAndView bWrite(Board board) throws IllegalStateException, IOException {
		MultipartFile BFile = board.getBFile();
		String BFileName = BFile.getOriginalFilename();
		
		String savePath="C:/Users/ooo16/Downloads/sts-4.11.1.RELEASE/springFile/Library/src/main/webapp/resources/BoardProfile/" + BFileName;
		if(!BFile.isEmpty()) {
			board.setBFileName(BFileName);
			BFile.transferTo(new File(savePath));
		}
		int result = dao.bWrite(board);
		if(result>0) {
			mav.setViewName("redirect:/B_list");
		} else {
			mav.setViewName("index");
		}
		
		return mav;
	}


	private static final int PAGE_LIMIT = 5;
	private static final int BLOCK_LIMIT = 5;

	public ModelAndView bList(int page) {
		Page paging = new Page();
		
		int listCount = dao.mListCount();
		
		int startRow = (page-1)* PAGE_LIMIT + 1;
		int endRow = page*PAGE_LIMIT;
		
		int maxPage = (int)(Math.ceil((double)listCount / PAGE_LIMIT));
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) -1 ) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		paging.setPage(page);
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		paging.setMaxPage(maxPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		
		List<Board> boardList = dao.mList(paging);
		mav.addObject("boardList", boardList);
		mav.addObject("paging", paging);
		mav.setViewName("B_List");
		
		return mav;
	}
	
	public ModelAndView bView(int BNo, int page) {
		Page paging = new Page();
		Board board = dao.bView(BNo, page);
		mav.addObject("view", board);
		mav.addObject("paging", paging);
		mav.setViewName("B_View");
		return mav;
	}
	
	public ModelAndView bModiForm(int BNo, int page) {
		Board board = dao.bView(BNo, page);
		mav.addObject("modi", board);
		mav.setViewName("B_Modi");
		return mav;
	}
	public ModelAndView bModi(Board board, int page) throws IllegalStateException, IOException {
		MultipartFile BFile = board.getBFile();
		String BFileName = BFile.getOriginalFilename();
		
		String savePath="C:/Users/ooo16/Downloads/sts-4.11.1.RELEASE/springFile/Library/src/main/webapp/resources/BoardProfile/" + BFileName;
		
		if(!BFile.isEmpty()) {
			board.setBFileName(BFileName);
			BFile.transferTo(new File(savePath));
		}
		int result = dao.bModi(board, page);
		if(result>0) {
			mav.setViewName("redirect:/B_list?page=" + page );
		} else {
			mav.setViewName("index");
		}
		return mav;
	}

	public ModelAndView bDel(int BNo, int page) {
		int result = dao.bDel(BNo, page);
		if(result>0) {
			mav.setViewName("redirect:/B_list?page=" + page);
		} else {
			mav.setViewName("index");
		}
		return mav;
	}

}
