package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.board.vo.BoardVo;

import lee.hyun.db.JDBCTemplate;

public class BoardDao {

	public int write(Connection conn, BoardVo vo) throws Exception {

		String sql = "INSERT INTO TEMP_BOARD(TITLE, CONTENT) VALUES(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public BoardVo detail(Connection conn) throws Exception {

		String sql = "SELECT * FROM TEMP_BOARD ORDER BY ROWNUM DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		BoardVo vo = new BoardVo();
		if(rs.next()) {
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			
			vo.setTitle(title);
			vo.setContent(content);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

}
