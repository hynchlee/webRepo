package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;
import com.kh.app.util.page.PageVo;

public class BoardDao {

	public int write(Connection conn, BoardVo vo) throws SQLException {

		String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD_NO.NEXTVAL, ?, ?, 1)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());

		int result = pstmt.executeUpdate();

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(pstmt);

		return result;
	}

	public List<BoardVo> selectBoardList(Connection conn, PageVo pv) throws SQLException {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM BOARD ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int endRow = pv.getCurrentPage()*pv.getBoardLimit();
		int startRow = endRow - pv.getBoardLimit();
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		ResultSet rs = pstmt.executeQuery();

		// BoardVo만 담을 수 있는 list 생성
		List<BoardVo> list = new ArrayList<>();
		while (rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String enrollDate = rs.getString("ENROLL_DATE");

			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setEnrollDate(enrollDate);

			list.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return list;
	}

	// 갯수 조회
	public int selectCnt(Connection conn) throws SQLException {

		String sql = "SELECT COUNT(*) cnt FROM BOARD";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);

		return cnt;
	}

}
