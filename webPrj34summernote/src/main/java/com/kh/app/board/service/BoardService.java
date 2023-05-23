package com.kh.app.board.service;

import java.sql.Connection;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

import lee.hyun.db.JDBCTemplate;

public class BoardService {

	public int write(BoardVo vo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		BoardDao dao = new BoardDao();
		int result = dao.write(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public BoardVo detail() throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		BoardDao dao = new BoardDao();
		BoardVo vo = dao.detail(conn);
		
		JDBCTemplate.close(conn);
		
		return vo;
		
	}

}
