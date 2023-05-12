package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String id = req.getParameter("memberId");
			String pwd = req.getParameter("memberPwd");		
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			if(loginMember != null) {
				req.getSession().setAttribute("loginMember", loginMember);
				req.getSession().setAttribute("loginMsg", "로그인 성공");
				String root = req.getContextPath();
				resp.sendRedirect(root+"/home");
			}
			else {
				req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			System.out.println("ERROR 로그인 중 에러 발생");
			e.printStackTrace();
		}	
		
	}
	
}
