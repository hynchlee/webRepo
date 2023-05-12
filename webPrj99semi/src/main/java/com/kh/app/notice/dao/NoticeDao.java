package com.kh.app.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.common.page.PageVo;
import com.kh.app.notice.vo.NoticeReplyVo;
import com.kh.app.notice.vo.NoticeVo;

public class NoticeDao {

	public int selectCnt(Connection conn) throws SQLException {

		String sql = "SELECT COUNT(*) FROM NOTICE WHERE STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

	public List<NoticeVo> selectNoticeList(Connection conn, PageVo pv) throws Exception {

		// sql
		String sql = "SELECT NO , TITLE , CONTENT , MODIFY_DATE , TO_CHAR(ENROLL_DATE, 'YYYY-MM-DD') ENROLL_DATE , STATUS , HIT FROM ( SELECT ROWNUM RNUM,T.* FROM ( select * from notice where status = 'O' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());

		// tx||rs
		ResultSet rs = pstmt.executeQuery();

		List<NoticeVo> list = new ArrayList<>();
		while (rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String modifyDate = rs.getString("MODIFY_DATE");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");
			String hit = rs.getString("HIT");

			NoticeVo vo = new NoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setModifyDate(modifyDate);
			vo.setEnrollDate(enrollDate);
			vo.setStatus(status);
			vo.setHit(hit);

			list.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return list;
	}

	public int write(Connection conn, NoticeVo vo) throws SQLException {

		String sql = "INSERT INTO NOTICE (NO, TITLE, CONTENT) VALUES (SEQ_NOTICE_NO.NEXTVAL, ?, ?)";
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

	public NoticeVo selectNoticeOneByNo(Connection conn, String no) throws Exception {

		String sql = "SELECT TITLE, CONTENT, TO_CHAR(ENROLL_DATE, 'YYYY-MM-DD') ENROLL_DATE, MODIFY_DATE, STATUS, HIT FROM NOTICE WHERE NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();

		NoticeVo vo = null;
		
		if (rs.next()) {
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			String hit = rs.getString("HIT");

			vo = new NoticeVo();
			vo.setNo(no);
			vo.setContent(content);
			vo.setTitle(title);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setStatus(status);
			vo.setHit(hit);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	public int increaseHit(Connection conn, String no) throws Exception {
		
		String sql = "UPDATE NOTICE SET HIT = HIT+1 WHERE NO =? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int delete(Connection conn, String no) throws Exception {
		
		String sql = "UPDATE NOTICE SET STATUS = 'X' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int edit(Connection conn, NoticeVo vo) throws SQLException {

		String sql = "UPDATE NOTICE SET TITLE =?, CONTENT = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getNo());
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

	public int replyWrite(Connection conn, NoticeReplyVo vo) throws Exception {
		String sql = "INSERT INTO NOTICE_REPLY ( NO ,NOTICE_NO ,CONTENT ,WRITER_NO ) VALUES ( SEQ_NOTICE_REPLY_NO.NEXTVAL ,? ,? ,? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNoticeNo());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getWriterNo());
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

	public List<NoticeReplyVo> selectReplyList(Connection conn, String noticeNo) throws Exception {
		
		String sql = "SELECT*FROM NOTICE_REPLY WHERE NOTICE_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, noticeNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<NoticeReplyVo> voList = new ArrayList<>();
		while (rs.next()) {
			String no = rs.getString("NO");
//			String noticeNo = rs.getString("NOTICE_NO");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");
			
			NoticeReplyVo vo = new NoticeReplyVo();
			vo.setNo(no);
			vo.setNoticeNo(noticeNo);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setEnrollDate(enrollDate);
			vo.setStatus(status);
			
			voList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
		
	}

}
