package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.common.page.PageVo;
import com.kh.app.util.file.AttachmentVo;

public class BoardDao {

	//그냥 목록 조회
	public List<BoardVo> getBoardList(Connection conn, PageVo pv) throws Exception {
		
		//SQL
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT B.NO , B.TITLE , B.CONTENT , B.WRITER_NO , B.CATEGORY_NO , B.ENROLL_DATE , B.STATUS , B.MODIFY_DATE , B.HIT , M.NICK , C.NAME AS CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON(B.WRITER_NO = M.NO) JOIN CATEGORY C ON(B.CATEGORY_NO = C.NO) WHERE B.STATUS = 'O' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		//tx || rs
		List<BoardVo> voList = new ArrayList<>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String nick = rs.getString("NICK");
			String categoryName = rs.getString("CATEGORY_NAME");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setCategoryNo(categoryNo);
			vo.setEnrollDate(enrollDate);
			vo.setStatus(status);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setWriterName(nick);
			vo.setCategoryName(categoryName);
			
			voList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}
	
	//검색해서 리스트 조회하기
	public List<BoardVo> getBoardList(Connection conn, PageVo pv , String searchType , String searchValue) throws Exception {
		
		String sql = "";
		
		if(searchType.equals("title")) {
			//SQL (제목	검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT B.NO , B.TITLE , B.CONTENT , B.WRITER_NO , B.CATEGORY_NO , B.ENROLL_DATE , B.STATUS , B.MODIFY_DATE , B.HIT , M.NICK , C.NAME AS CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON(B.WRITER_NO = M.NO) JOIN CATEGORY C ON(B.CATEGORY_NO = C.NO) WHERE B.STATUS = 'O' AND B.TITLE LIKE '%'||?||'%' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		}else if(searchType.equals("writer")) {
			//SQL (작성자	검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT B.NO , B.TITLE , B.CONTENT , B.WRITER_NO , B.CATEGORY_NO , B.ENROLL_DATE , B.STATUS , B.MODIFY_DATE , B.HIT , M.NICK , C.NAME AS CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON(B.WRITER_NO = M.NO) JOIN CATEGORY C ON(B.CATEGORY_NO = C.NO) WHERE B.STATUS = 'O' AND M.NICK LIKE '%'||?||'%' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		}else if("category".equals(searchType)) {
			//SQL (카테고리 검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT B.NO , B.TITLE , B.CONTENT , B.WRITER_NO , B.CATEGORY_NO , B.ENROLL_DATE , B.STATUS , B.MODIFY_DATE , B.HIT , M.NICK , C.NAME AS CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON(B.WRITER_NO = M.NO) JOIN CATEGORY C ON(B.CATEGORY_NO = C.NO) WHERE B.STATUS = 'O' AND B.CATEGORY_NO = ? ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		}else {
			//값이 이상함 => 기본 목록 조회
			return getBoardList(conn, pv);
		}
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString	(1, searchValue);
		pstmt.setInt	(2, pv.getBeginRow());
		pstmt.setInt	(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		//tx || rs
		List<BoardVo> voList = new ArrayList<>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String nick = rs.getString("NICK");
			String categoryName = rs.getString("CATEGORY_NAME");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setCategoryNo(categoryNo);
			vo.setEnrollDate(enrollDate);
			vo.setStatus(status);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setWriterName(nick);
			vo.setCategoryName(categoryName);
			
			voList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}

	public int getBoardListCnt(Connection conn, String searchType, String searchValue) throws Exception {
		
		//SQL
		String sql = "SELECT COUNT(*) FROM ( SELECT B.NO ,B.TITLE ,B.CONTENT ,B.WRITER_NO ,B.CATEGORY_NO ,B.ENROLL_DATE ,B.STATUS ,B.MODIFY_DATE ,B.HIT ,M.NICK FROM BOARD B JOIN MEMBER M ON (B.WRITER_NO = M.NO) ) WHERE STATUS = 'O'";
		if("title".equals(searchType)) {
			sql += "AND TITLE LIKE '%" + searchValue + "%'";
		}else if("writer".equals(searchType)) {
			sql += "AND NICK LIKE '%" + searchValue + "%'";
		}else if("category".equals(searchType)) {
			sql += "AND CATEGORY_NO = " + searchValue;
		}
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//tx || rs
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

	public int write(Connection conn, BoardVo bvo) throws Exception {
		// SQL
		String sql = "INSERT INTO BOARD ( NO ,TITLE ,CONTENT ,WRITER_NO ,CATEGORY_NO ) VALUES ( SEQ_BOARD_NO.NEXTVAL , ? , ? , ? , ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bvo.getTitle());
		pstmt.setString(2, bvo.getContent());
		pstmt.setString(3, bvo.getWriterNo());
		pstmt.setString(4, bvo.getCategoryNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public List<CategoryVo> getCategoryList(Connection conn) throws Exception {
		
		// SQL
		String sql = "SELECT * FROM CATEGORY";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// tx || rs
		List<CategoryVo> cvoList = new ArrayList<>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			
			CategoryVo vo = new CategoryVo();
			vo.setNo(no);
			vo.setName(name);
			
			cvoList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cvoList;
	}

	public int insertAttachment(Connection conn, List<AttachmentVo> attVoList) throws Exception {
		
		String sql = "INSERT ALL";
		for(AttachmentVo vo : attVoList) {
			sql += " INTO ATTACHMENT ( NO ,BNO ,ORIGIN_NAME ,CHANGE_NAME ) VALUES ( (SELECT GET_ATTACHMENT_SEQ FROM DUAL) , SEQ_BOARD_NO.CURRVAL , '" + vo.getOriginName() +"' , '" + vo.getChangeName() +"' )";
		}
		sql += " SELECT 1 FROM DUAL";
		
		System.out.println(sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}//class



















