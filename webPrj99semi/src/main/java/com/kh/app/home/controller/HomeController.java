package com.kh.app.home.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.page.PageVo;
import com.kh.app.gallery.service.GalleryService;
import com.kh.app.gallery.vo.GalleryVo;
import com.kh.app.notice.service.NoticeService;
import com.kh.app.notice.vo.NoticeVo;

@WebServlet("/home")
public class HomeController extends HttpServlet {

	private final NoticeService ns = new NoticeService();
	private final BoardService bs = new BoardService();
	private final GalleryService gs = new GalleryService();
	private final PageVo pv = new PageVo(5, 1, 1, 5);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			List<BoardVo> boardList = bs.getBoardList(pv);
			List<NoticeVo> noticeList = ns.selectNoticeList(pv);
			GalleryVo gv = gs.getGalleryRecent();
			
			req.setAttribute("gv", gv);
			req.setAttribute("boardList", boardList);
			req.setAttribute("noticeList", noticeList);

			req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "홈화면 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}

	}

}// class
