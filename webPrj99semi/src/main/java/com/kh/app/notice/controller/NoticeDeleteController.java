package com.kh.app.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.notice.service.NoticeService;

@WebServlet("/notice/delete")
public class NoticeDeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//데꺼
			String no = req.getParameter("no");
			
			//데뭉
			
			//서비스
			NoticeService ns = new NoticeService();
			int result = ns.delete(no);
			 
			//화면
			if(result != 1) {
				throw new Exception();
			}
			
			req.getSession().setAttribute("alertMsg", "공지사항 삭제 완료");
			resp.sendRedirect(req.getContextPath() + "/home");
		} catch (Exception e) {
			System.out.println("ERROR 공지사항 삭제 중 에러");
			e.printStackTrace();
			
			req.setAttribute("alertMsg", "공지사항 삭제 완료");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}
	
}
