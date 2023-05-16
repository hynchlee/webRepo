package com.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.service.MemberService;
import com.member.vo.MemberVo;

@WebServlet("/member/login")
public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			
			MemberVo vo = new MemberVo();
			vo.setId(memberId);
			vo.setPwd(memberPwd);
			
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			
			if(loginMember != null) {
				req.getSession().setAttribute("loginMember", loginMember);
				String root = req.getContextPath();
				resp.sendRedirect(root+"/member/mypage");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}














