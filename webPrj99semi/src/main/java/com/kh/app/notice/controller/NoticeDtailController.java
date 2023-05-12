package com.kh.app.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.notice.service.NoticeService;
import com.kh.app.notice.vo.NoticeVo;

@WebServlet("/notice/detail")
public class NoticeDtailController extends HttpServlet {

	private static NoticeService ns = new NoticeService();

	// SELECT * FROM NOTICE WHERE NO = ? AND STATUS = 'O'
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String no = req.getParameter("no");

			NoticeVo vo = ns.selectNoticeOneByNo(no);

			if (vo != null) {
				req.setAttribute("vo", vo);
				req.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp").forward(req, resp);
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			System.out.println("ERROR 상세조회 중 에러");
			e.printStackTrace();

			req.setAttribute("errorMsg", "상세조회 실패");
			req.getRequestDispatcher("").forward(req, resp);
		}

	}
}
