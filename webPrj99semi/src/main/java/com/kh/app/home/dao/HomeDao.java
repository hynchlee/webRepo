package com.kh.app.home.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.db.JDBCTemplate;

public class HomeDao {

	public BoardVo getBoardTopHit(Connection conn) throws Exception {

		String sql = "SELECT * FROM BOARD WHERE HIT = (SELECT MAX(HIT) FROM BOARD WHERE STATUS = 'O')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		BoardVo vo = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			
			vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setCategoryNo(categoryNo);
			vo.setEnrollDate(enrollDate);
			vo.setStatus(status);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

}
