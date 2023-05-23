package com.kh.app.gallery.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.gallery.service.GalleryService;
import com.kh.app.gallery.vo.GalleryVo;

//SELECT * FROM GALLERY ORDER BY NO DESC
@WebServlet("/gallery/list")
public class GalleryListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//서비스
			GalleryService gs = new GalleryService();
			List<GalleryVo> voList = gs.getGalleryList();
						
			//결과
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/gallery/list.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("갤러리 리스트 조회 중 오류 발생");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/error-page").forward(req, resp);
		}
	}
	
	
}
