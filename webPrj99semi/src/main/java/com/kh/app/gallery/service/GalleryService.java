package com.kh.app.gallery.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.gallery.dao.GalleryDao;
import com.kh.app.gallery.vo.GalleryVo;

public class GalleryService {

	public int write(GalleryVo gvo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		GalleryDao dao = new GalleryDao();
		int result = dao.write(gvo, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<GalleryVo> getGalleryList() throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		GalleryDao dao = new GalleryDao();
		List<GalleryVo> voList = dao.getGalleryList(conn);
		
		return voList;
	}

	public GalleryVo getBoardByNo(String no) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		GalleryDao dao = new GalleryDao();
		GalleryVo vo = dao.getBoardByNo(conn, no);
				
		JDBCTemplate.close(conn);
		
		return vo;
	}

	public int del(String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		GalleryDao dao = new GalleryDao();
		int result = dao.del(no, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int edit(GalleryVo vo, String no) throws SQLException {

		Connection conn = JDBCTemplate.getConnection();
		
		GalleryDao dao = new GalleryDao();
		int result = dao.edit(vo, conn, no);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
