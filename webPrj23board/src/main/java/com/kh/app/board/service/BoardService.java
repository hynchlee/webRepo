package com.kh.app.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;

public class BoardService {

	// 게시글 작성
	public int write(BoardVo boardvo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		// sql
		BoardDao dao = new BoardDao();
		int result = dao.write(conn, boardvo);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;

	}

	public List<BoardVo> selectList() throws SQLException {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// sql
		BoardDao dao = new BoardDao();
		List<BoardVo> voList = dao.selectList(conn);

		JDBCTemplate.close(conn);

		return voList;
	}

	// 게시글 상세 조회
	public BoardVo selectOneByNo(String num) throws SQLException {

		Connection conn = JDBCTemplate.getConnection();

		BoardDao dao = new BoardDao();
		BoardVo vo = dao.selectOneByNo(num, conn);

		JDBCTemplate.close(conn);

		return vo;

	}

}
