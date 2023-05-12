package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;

public class BoardDao {

	// 게시글 작성 메소드
	public int write(Connection conn, BoardVo boardVo) throws SQLException {
		String sql = "INSERT INTO BOARD (NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD_NO.NEXTVAL, ?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardVo.getTitle());
		pstmt.setString(2, boardVo.getContent());
		pstmt.setString(3, boardVo.getWriterNo());
		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);

		return result;
	}

	public List<BoardVo> selectList(Connection conn) throws SQLException {

		// sql
		String sql = "SELECT*FROM BOARD ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		// 행이 존재할때까지
		List<BoardVo> voList = new ArrayList<>();
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

			voList.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return voList;

	}

	public BoardVo selectOneByNo(String num, Connection conn) throws SQLException {
		// sql
		String sql = "SELECT*FROM BOARD WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		ResultSet rs = pstmt.executeQuery();

		BoardVo vo = new BoardVo();
		if (rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String enrollDate = rs.getString("ENROLL_DATE");

			vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setEnrollDate(enrollDate);

		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return vo;
	}

}
