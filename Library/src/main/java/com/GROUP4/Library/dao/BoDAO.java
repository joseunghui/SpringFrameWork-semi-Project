package com.GROUP4.Library.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.GROUP4.Library.dto.Board;
import com.GROUP4.Library.dto.Page;

@Repository
public class BoDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public int bWrite(Board board) {
		return sql.insert("Board.bWrite", board);
	}

	public int mListCount() {
		return sql.selectOne("Board.bListCount");
	}

	public List<Board> mList(Page paging) {
		return sql.selectList("Board.bList", paging);
	}

	public Board bView(int BNo, int page) {
		return sql.selectOne("Board.bView", BNo);
	}

	public int bModi(Board board, int page) {
		return sql.update("Board.bModi", board);
	}

	public int bDel(int BNo, int page) {
		return sql.delete("Board.bDel", BNo);
	}
	
	

}
