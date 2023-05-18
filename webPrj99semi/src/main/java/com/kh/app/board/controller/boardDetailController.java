package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.file.AttachmentVo;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {
	
	//게시글 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데꺼
			String bno = req.getParameter("bno");
			
			//서비스
			BoardService bs = new BoardService();
			Map<String , Object> map = bs.getBoardByNo(bno);
			
			BoardVo vo = (BoardVo) map.get("vo");
			List<AttachmentVo> attList = (List<AttachmentVo>) map.get("attList");
			
			//화면
			if(vo == null) {
				throw new Exception();
			}
			
			req.setAttribute("vo", vo);
			req.setAttribute("attList", attList);
			req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
			
		} catch (Exception e) {
			req.setAttribute("errorMsg", "잘못된 접근입니다.");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			e.printStackTrace();
		}
		
	}

}






















