package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberNick = req.getParameter("memberNick");
			
			MemberVo vo = new MemberVo();
			vo.setId(memberId);
			vo.setPwd(memberPwd);
			vo.setNick(memberNick);
			
			MemberService ms = new MemberService();
			int result = ms.join(vo);
			
			if(result == 1) {
				req.getSession().setAttribute("alertMsg", "회원가입 성공!");
				resp.sendRedirect("/app24");
			}
			
			else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR] 회원가입 중 예외 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "회원가입 실패");
			req.getRequestDispatcher("에러페이지").forward(req, resp);
		}
	}
	
}
