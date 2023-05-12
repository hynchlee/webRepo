package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/dup-check")
public class MemberDupCheckController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String memberId = req.getParameter("memberId");
		
		if("admin".equals(memberId)) {
			resp.getWriter().write("no");
		}
		else {
			resp.getWriter().write("ok");
		}
	}
}
