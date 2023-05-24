package com.kh.app.admin.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.admin.member.service.AdminMemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/admin/member/list")
public class AdminMemberListController extends HttpServlet{

	
	//SELECT * FROM MEMBER ORDER BY NO DESC
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			AdminMemberService ams = new AdminMemberService();
			List<MemberVo> list= ams.getMemberList();
						
			req.setAttribute("list", list);
			req.getRequestDispatcher("/WEB-INF/views/admin/member/list.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "유저 목록 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			
		}
		
	}
	
}
