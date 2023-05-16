package com.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.service.MemberService;
import com.member.vo.MemberVo;

@WebServlet("/member/edit")
public class Edit extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/edit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String name = req.getParameter("memberName");
			String id = req.getParameter("memberId");
			String pwd = req.getParameter("memberPwd");
			String email = req.getParameter("memberEmail");
			String phone = req.getParameter("memberPhone");
			String grade = req.getParameter("memberGrade");
			
			MemberVo vo = new MemberVo();
			vo.setName(name);
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setEmail(email);
			vo.setPhone(phone);
			vo.setAdminYn(grade);
			
			MemberService ms = new MemberService();
			int result = ms.edit(vo);
			
			if(result == 1) {
				req.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(req, resp);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
