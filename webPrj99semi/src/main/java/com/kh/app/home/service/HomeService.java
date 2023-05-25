package com.kh.app.home.service;

import java.sql.Connection;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.home.dao.HomeDao;

public class HomeService {

	public BoardVo getBoardTopHit() throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		HomeDao dao = new HomeDao();
		BoardVo vo = dao.getBoardTopHit(conn);
		
		JDBCTemplate.close(conn);
		
		return vo;
		
	}

}
