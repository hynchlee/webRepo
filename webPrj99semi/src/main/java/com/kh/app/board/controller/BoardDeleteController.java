package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/board/del")
public class BoardDeleteController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			
			if(loginMember == null) {
				throw new IllegalStateException();
			}
			
			// 데이터 준비
			String no = req.getParameter("no");
			String writerNo = loginMember.getNo();
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setWriterNo(writerNo);
			
			// 서비스
			BoardService bs = new BoardService();
			int result = bs.delete(vo);
				
			
			// 화면
			if(result == 1) {
				resp.sendRedirect(req.getContextPath()+"/board/list");
			}
			else {
				req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			
			
		}

	}

}
