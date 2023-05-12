package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.board.vo.BoardVo;

import lee.hyun.db.JDBCTemplate;

public class BoardDao {

	public int write(Connection conn, BoardVo vo) throws Exception {
		
		String sql = "INSERT INTO TEMP_BOARD(TITLE, WRITER, CONTENT) VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getWriter());
		pstmt.setString(3, vo.getContent());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
}
