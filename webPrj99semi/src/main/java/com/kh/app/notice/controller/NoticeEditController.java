package com.kh.app.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.notice.service.NoticeService;
import com.kh.app.notice.vo.NoticeVo;

@WebServlet("/notice/edit")
public class NoticeEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");

		if (!"ADMIN".equals(loginMember.getId())) {
			req.setAttribute("errorMsg", "접근 권한이 없음");
			req.getRequestDispatcher("/WEB-INF/views/notice/error-page.jsp").forward(req, resp);
			return;
		}
		
		try {
			String no = req.getParameter("no");

			NoticeService ns = new NoticeService();
			NoticeVo vo = ns.selectNoticeOneByNo(no);

			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/notice/edit.jsp").forward(req, resp);

		} catch (Exception e) {
			System.out.println("ERROR 공지사항 수정 중 에러");
			e.printStackTrace();

			req.setAttribute("errorMsg", "화면 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/notice/error-page.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// 데꺼
			String no = req.getParameter("no");
			String title = req.getParameter("title");
			String content = req.getParameter("content");

			// 데뭉
			NoticeVo vo = new NoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);

			// 서비스
			NoticeService ns = new NoticeService();
			int result = ns.edit(vo);

			// 화면

			if (result != 1) {
				throw new Exception();
			}
			req.getSession().setAttribute("alertMsg", "공지사항 수정 완료");
			resp.sendRedirect(req.getContextPath() + "/notice/detail?no=" + no);
		} catch (Exception e) {
			System.out.println("ERROR 수정 중 오류 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "오류");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}

	}

}
