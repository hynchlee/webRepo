package com.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Position;

import com.member.service.MemberService;
import com.member.vo.MemberVo;

@WebServlet("/member/join")
public class Join extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
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
			int result = ms.joinForm(vo);
			
			if(result == 1) {
				String root = req.getContextPath();
				resp.sendRedirect(root + "/member/login");
			}
						
		} catch (Exception e) {
			System.out.println("ERROR 회원가입 중 오류");
			e.printStackTrace();
		}
	}
}
