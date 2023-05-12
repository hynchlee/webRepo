package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {

	// 게시글 작성하기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}

	// 게시글 작성하기
	// INSERT INTO BOARD(TITLE, WRITER, CONTENT) VALUES(?,?,?)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// 데이터 꺼내기
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");

			// 데이터 뭉치기
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			// 서비스
			BoardService bs = new BoardService();

			int result = bs.write(vo);
			if (result == 1) {
				resp.sendRedirect("/app/board/list");
			} else {
				req.setAttribute("error", "에러");
				req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			System.out.println("ERROR 게시글 작성중 오류 발생");
			e.printStackTrace();

		}
	}

}
