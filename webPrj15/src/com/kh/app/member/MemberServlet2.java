package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberServlet2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if(pwd.length()>4) {
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/fail.jsp").forward(req, resp);
		}
	}
	
}
