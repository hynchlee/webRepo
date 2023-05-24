package com.kh.app.gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.gallery.vo.GalleryVo;

public class GalleryDao {

	public int write(GalleryVo gvo, Connection conn) throws SQLException {

		System.out.println(gvo.getContent());
		String sql = "INSERT INTO GALLERY ( NO , TITLE , CONTENT ,WRITER_NO , ORIGIN_NAME , CHANGE_NAME ) VALUES ( SEQ_GALLERY_NO.NEXTVAL , ? , ? , ? , ? , ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, gvo.getTitle());
		pstmt.setString(2, gvo.getContent());
		pstmt.setString(3, gvo.getWriterNo());
		pstmt.setString(4, gvo.getOriginName());
		pstmt.setString(5, gvo.getChangeName());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}

	public List<GalleryVo> getGalleryList(Connection conn) throws Exception {

		String sql = "SELECT NO, TITLE, CONTENT, WRITER_NO, ORIGIN_NAME, CHANGE_NAME, ENROLL_DATE, STATUS, HIT FROM GALLERY WHERE STATUS = 'O' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<GalleryVo> voList = new ArrayList<>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String originName = rs.getString("ORIGIN_NAME");
			String changeName = rs.getString("CHANGE_NAME");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");
			String hit = rs.getString("HIT");
			
			GalleryVo gs = new GalleryVo();
			gs.setNo(no);
			gs.setTitle(title);
			gs.setContent(content);
			gs.setWriterNo(writerNo);
			gs.setOriginName(originName);
			gs.setChangeName(changeName);
			gs.setEnrollDate(enrollDate);
			gs.setStatus(status);
			gs.setHit(hit);
			
			voList.add(gs);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return voList;
	}

	public GalleryVo getBoardByNo(Connection conn, String no) throws Exception {

		String sql = "SELECT NO ,TITLE ,CONTENT ,WRITER_NO ,ORIGIN_NAME ,CHANGE_NAME ,ENROLL_DATE ,STATUS ,HIT FROM GALLERY WHERE NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		GalleryVo vo = null;
		if(rs.next()) {
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String originName = rs.getString("ORIGIN_NAME");
			String changeName = rs.getString("CHANGE_NAME");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");
			String hit = rs.getString("HIT");
			
			vo = new GalleryVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setOriginName(originName);
			vo.setChangeName(changeName);
			vo.setEnrollDate(enrollDate);
			vo.setStatus(status);
			vo.setHit(hit);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	public int del(String no, Connection conn) throws Exception {

		String sql = "UPDATE GALLERY SET STATUS = 'X' WHERE NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);

		return result;
	}

	public int edit(GalleryVo vo, Connection conn, String no) throws SQLException {

		String sql = "";
		sql = "UPDATE GALLERY SET TITLE = ?, CONTENT = ? WHERE NO = ? AND STATUS = 'O'";
		if(vo.getOriginName() != null || vo.getChangeName() != null) {
			sql = "UPDATE GALLERY SET TITLE = ?, CONTENT = ?, ORIGIN_NAME = ?, CHANGE_NAME=? WHERE NO = ? AND STATUS = 'O'";
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getChangeName());
		pstmt.setString(3, no);

		if(vo.getChangeName() != null) {
			pstmt.setString(3, vo.getOriginName());
			pstmt.setString(4, vo.getChangeName());
			pstmt.setString(5, no);			
		}
		
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}
