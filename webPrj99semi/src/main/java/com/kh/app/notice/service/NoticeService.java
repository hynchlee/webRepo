package com.kh.app.notice.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.common.page.PageVo;
import com.kh.app.notice.dao.NoticeDao;
import com.kh.app.notice.vo.NoticeReplyVo;
import com.kh.app.notice.vo.NoticeVo;

public class NoticeService {
	
	private final NoticeDao dao = new NoticeDao();

	public int selectCnt() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.selectCnt(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<NoticeVo> selectNoticeList(PageVo pv) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<NoticeVo> list = dao.selectNoticeList(conn , pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int write(NoticeVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		
		int result = dao.write(conn, vo);
		
		//tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//공지사항 상세조회 (select + update)
	public NoticeVo selectNoticeOneByNo(String no) throws Exception {
		
		NoticeVo vo = null;
		//conn
		try (Connection conn = JDBCTemplate.getConnection();){
			//update
			int result = dao.increaseHit(conn , no);
			
			if(result == 1) {
				//select
				vo = dao.selectNoticeOneByNo(conn , no);
			}else {
				throw new Exception();
			}
		}
		return vo;
	}

	public int delete(String no) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.delete(conn, no);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int edit(NoticeVo vo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.edit(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int replyWrite(NoticeReplyVo vo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.replyWrite(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public List<NoticeReplyVo> selectReplyList(String noticeNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
	
		List<NoticeReplyVo> list = dao.selectReplyList(conn, noticeNo);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}

}//class


















