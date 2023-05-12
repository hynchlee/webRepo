package com.kh.app.board.service;

import java.sql.Connection;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

import lee.hyun.db.JDBCTemplate;

public class BoardService {

	public int write(BoardVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//데이터 처리
		BoardDao dao = new BoardDao();
		int result = dao.write(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
	}

}
