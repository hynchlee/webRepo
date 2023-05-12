package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/quit")
public class MemberQuitController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			String no = loginMember.getNo();
			
			MemberService ms = new MemberService();
			int result = ms.quit(no);
			
			if(result == 1) {
				session.invalidate();
				req.getSession().setAttribute("alertMsg", "탈퇴 성공");
				resp.sendRedirect(req.getContextPath()+"/home");
			}
			else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR] 회원 탈퇴 중 오류");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "탈퇴 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
