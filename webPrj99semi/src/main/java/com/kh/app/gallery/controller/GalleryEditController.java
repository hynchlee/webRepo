package com.kh.app.gallery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.app.gallery.service.GalleryService;
import com.kh.app.gallery.vo.GalleryVo;
import com.kh.app.util.file.AttachmentVo;
import com.kh.app.util.file.FileUploader;

@MultipartConfig(
			maxFileSize = 1024*1024*50,
			maxRequestSize = 1024*1024*50*10
		)

@WebServlet("/gallery/edit")
public class GalleryEditController extends HttpServlet{

	//title, content, f
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String no = req.getParameter("no");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			Part f = req.getPart("f");
			
			GalleryVo vo = new GalleryVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			
			if(f.getSize() > 0) {
				String path = req.getServletContext().getRealPath("/static/img/gallery/");
				AttachmentVo attVo = FileUploader.saveFile(path, f);
				vo.setOriginName(attVo.getOriginName());
				vo.setChangeName(attVo.getChangeName());
			}

			GalleryService gs = new GalleryService();
			int result = gs.edit(vo, no);
			
			System.out.println(vo);
			System.out.println(no);
			
			if(result != 1) {
				throw new IllegalStateException();
			}
			req.getSession().setAttribute("alertMsg", "게시글 수정 성공");
			resp.sendRedirect(req.getContextPath() + "/gallery/detail?no="+no);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "갤러리 수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}
	
}
