package com.kh.app.board.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.common.page.PageVo;
import com.kh.app.util.file.AttachmentVo;

public class BoardService {

	private final BoardDao dao = new BoardDao();
	
	//그냥 조회
	public List<BoardVo> getBoardList(PageVo pv) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> voList = dao.getBoardList(conn , pv);
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
	}
	
	//검색 조회
	public List<BoardVo> getBoardList(PageVo pv , String searchType, String searchValue) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> voList = dao.getBoardList(conn , pv , searchType, searchValue);
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
	}
	

	public int getBoardListCnt(String searchType, String searchValue) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getBoardListCnt(conn , searchType , searchValue);
		
		//close
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int write(BoardVo bvo, List<AttachmentVo> attVoList) throws Exception {
		
		// 커넥션
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.write(conn , bvo);
		int result2 = 1;
		if(attVoList.size() > 0) {
			result2 = dao.insertAttachment(conn , attVoList);
		}
		
		// tx || rs
		if(result == 1 && result2 > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<CategoryVo> getCategoryList() throws Exception {
		
		// 커넥션
		Connection conn = JDBCTemplate.getConnection();

		List<CategoryVo> cvoList = dao.getCategoryList(conn);
		
		// close
		JDBCTemplate.close(conn);
		
		return cvoList;
	}

	public Map<String, Object> getBoardByNo(String bno) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.increaseHit(conn, bno);
		if(result != 1) {
			JDBCTemplate.rollback(conn);
			throw new Exception();
		}
	
		BoardVo vo = dao.getBoardByNo(conn, bno);
		List<AttachmentVo> attList = dao.getAttachmentList(conn, bno);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("vo", vo);
		map.put("attList", attList);
		
		JDBCTemplate.commit(conn);
		
		JDBCTemplate.close(conn);
		
		return map;
	}

	public int delete(BoardVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.delete(conn, vo);
		
		JDBCTemplate.close(conn);
		
		
		return result;
	}

	public int edit(BoardVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.edit(vo, conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}//class

















