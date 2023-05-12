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

@WebServlet("/member/edit")
public class MemberEditController extends HttpServlet {
	
	//회원정보 수정 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		if(loginMember != null) {
			req.getRequestDispatcher("/WEB-INF/views/member/edit-form.jsp").forward(req, resp);
		}
		else {
			req.getSession().setAttribute("alertMsg", "로그인을 먼저 해주세요");
			resp.sendRedirect(req.getContextPath()+"/home");
		}
	}

	//회원정보 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			//데꺼
			String no = loginMember.getNo();
			String memberPwd = req.getParameter("memberPwd");
			String memberNick = req.getParameter("memberNick");
			String memberProfile = req.getParameter("memberProfile");
			String[] hobbyArr = req.getParameterValues("hobby");
			String hobby = "";
			if(hobbyArr != null) {
				hobby = String.join(",", hobbyArr);
			}
			
			//데뭉
			MemberVo vo = new MemberVo();
			vo.setNo(no);
			vo.setPwd(memberPwd);
			vo.setNick(memberNick);
			vo.setProfile(memberProfile);
			vo.setHobby(hobby);
			
			//서비스
			MemberService ms = new MemberService();
			MemberVo updatedMember = ms.edit(vo);
			
			//화면
			if(updatedMember != null) {
				req.getSession().setAttribute("alertMsg", "수정 완료!");
				req.getSession().setAttribute("loginMember", updatedMember);
				resp.sendRedirect(req.getContextPath() + "/home");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] edit errrr...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "edit fail...");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}
	
}//class




















