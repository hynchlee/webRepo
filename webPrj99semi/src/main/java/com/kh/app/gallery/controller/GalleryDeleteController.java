package com.kh.app.gallery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.gallery.service.GalleryService;

@WebServlet("/gallery/delete")
public class GalleryDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String no = req.getParameter("no");

			GalleryService gs = new GalleryService();
			int result = gs.del(no);

			System.out.println(no);
			
			if (result != 1) {
				throw new IllegalStateException("게시글 삭제 실패");
			}

			resp.sendRedirect(req.getContextPath() + "/gallery/list");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}