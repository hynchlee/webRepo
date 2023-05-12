package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.page.PageVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7082905825060971796L;

	// SELECT * FROM BOARD
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			BoardService bs = new BoardService();

			int listCount = bs.selectCnt();
			int currentPage = Integer.parseInt(req.getParameter("page"));
			int pageLimit = 5;
			int boardLimit = 5;
			
			PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			

//			PageVo pv = Pagination.getPageVo(listCount, currentPage, pageLimit, boardLimit);

			List<BoardVo> bvoList = bs.selectBoardList(pv);

			req.setAttribute("pv", pv);
			req.setAttribute("bvoList", bvoList);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);

		} catch (Exception e) {
			System.out.println("[ERROR] 게시글 목록 조회 중 예외 발생");
			e.printStackTrace();

			req.setAttribute("errorMsg", "에러메세지");
			req.getRequestDispatcher("에러페이지").forward(req, resp);
		}

	}
	
}
