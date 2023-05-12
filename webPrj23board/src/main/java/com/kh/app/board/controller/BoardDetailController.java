package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// 데이터 꺼내기
			String no = req.getParameter("no");

			// 데이터 뭉치기

			// 서비스
			BoardService bs = new BoardService();
			BoardVo boardVo = bs.selectOneByNo(no);

			// 화면
			if (boardVo != null) {
				req.setAttribute("boardVo", boardVo);
				req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			System.out.println("[ERROR] 게시글 조회 중 예외 발생");
			e.printStackTrace();
		}

	}

}
