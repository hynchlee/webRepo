package com.kh.app.gallery.service;

import java.sql.Connection;
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
		GalleryVo voList = dao.getBoardByNo(conn, no);
				
		JDBCTemplate.close(conn);
		
		return voList;
	}

}
