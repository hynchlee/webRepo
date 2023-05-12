package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/del")
public class MemberDeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			//데이터
			MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
			MemberService ms = new MemberService();
			int result = ms.del(no);
			
			if(result == 1) {
				req.getSession().setAttribute("alertMsg", "탈퇴완료");
				resp.sendRedirect("/app24");
			}
			else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR] 탈퇴 중 예외 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "er");
			req.getRequestDispatcher(getServletInfo()).forward(req, resp);
		}
		
	}
	
}
