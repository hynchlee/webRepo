package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;

@MultipartConfig(
			maxFileSize = 1024 * 1024* 50,
			maxRequestSize = 1024*1024*50*10
		)

@WebServlet("/board/edit")
public class BoardEditController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			if(loginMember == null) {
				throw new IllegalStateException();
			}
			
			//데이터 준비
			String no = req.getParameter("no");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writerNO = loginMember.getNo();
			
			BoardVo vo = new BoardVo();
			vo.setWriterNo(writerNO);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setNo(no);
			
			//서비스
			BoardService bs = new BoardService();
			int result = bs.edit(vo);

			if(result == 1) {
				req.getSession().setAttribute("alertMsg", "게시글 수정 완료");;
				resp.sendRedirect(req.getContextPath()+"/board/detail?bno=" + no);
			} 
			else {
				req.setAttribute("errorMsg", "게시글 작성 실패");
				req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			System.out.println("게시글 수정 중 오류 발생");
			e.printStackTrace();
		}
		
		
	}
	
}
