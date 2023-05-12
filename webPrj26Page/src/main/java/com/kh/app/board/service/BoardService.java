package com.kh.app.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;
import com.kh.app.util.page.PageVo;

public class BoardService {
	
	private final BoardDao dao = new BoardDao();

	public int write(BoardVo vo) throws SQLException {

		Connection conn = JDBCTemplate.getConnection();

		int result = dao.write(conn, vo);

		JDBCTemplate.close(conn);

		return result;

	}

	public List<BoardVo> selectBoardList(PageVo pv) throws SQLException {

		Connection conn = JDBCTemplate.getConnection();

		List<BoardVo> list = dao.selectBoardList(conn, pv);

		JDBCTemplate.close(conn);

		return list;
	}

	// 게시글 갯수조회
	public int selectCnt() throws SQLException {

		Connection conn = JDBCTemplate.getConnection();

		int cnt = dao.selectCnt(conn);

		JDBCTemplate.close(conn);

		return cnt;
	}

}
