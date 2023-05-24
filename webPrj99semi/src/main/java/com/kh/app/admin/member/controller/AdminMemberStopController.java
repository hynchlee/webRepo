package com.kh.app.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.admin.member.service.AdminMemberService;

//UPDATE MEMBER SET STATUS = 'S' WHERE NO = ? AND STATUS != 'X'
@WebServlet("/admin/member/stop")
public class AdminMemberStopController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String str = req.getParameter("noArr");
			Gson gson = new Gson();
			String[] noArr = gson.fromJson(str, String[].class);
			
			System.out.println(noArr);

			AdminMemberService ams = new AdminMemberService();
			int result = ams.restrainMembers(noArr);

			if (result <= 0) {
				throw new IllegalStateException();
			}

			resp.getWriter().write("ok");
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("fail");
		}

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String no = req.getParameter("no");

			AdminMemberService ams = new AdminMemberService();
			int result = ams.restrainMember(no);

			if (result != 1) {
				throw new IllegalStateException();
			}

			resp.sendRedirect(req.getContextPath() + "/admin/member/list");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "제재 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}

	}

}
