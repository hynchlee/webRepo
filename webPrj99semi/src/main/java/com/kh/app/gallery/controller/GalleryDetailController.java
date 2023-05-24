package com.kh.app.gallery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.gallery.service.GalleryService;
import com.kh.app.gallery.vo.GalleryVo;

@WebServlet("/gallery/detail")
public class GalleryDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			String no = req.getParameter("no");
			
			GalleryService gs = new GalleryService();
			GalleryVo vo = gs.getBoardByNo(no);
					
			if(vo == null) {
				throw new IllegalStateException("갤러리 상세조회 싶래");
			}
			
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/gallery/detail.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "오류발상");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
	
}
