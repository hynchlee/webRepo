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
public class BoardWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			req.setCharacterEncoding("UTF-8");
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writerNo = "1";	//가져왔다 치고
			
			//데이터 뭉치기
			BoardVo boardVo = new BoardVo();
			boardVo.setTitle(title);
			boardVo.setContent(content);
			boardVo.setWriterNo(writerNo);
			
			System.out.println(title);
			System.out.println(content);
			
			//서비스 로직
			BoardService bs = new BoardService();
			int result = bs.write(boardVo);
			
			//화면
			if(result == 1) {
				req.getSession().setAttribute("alertMsg", "게시글 작성됨");
				resp.sendRedirect("/app23");
			}
			else {
				throw new Exception("실행 결과가 1이 아님");
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR] 게시글 작성 중 예외 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "작성시패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}
	
}
