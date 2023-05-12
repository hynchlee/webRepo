package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/members/login")
public class MemberServlet extends HttpServlet{

	//로그인
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		//검사
		boolean loginSuccess = false;
		if(id.equals("admin") && pwd.equals("1234")) {
			loginSuccess = true;
		}
		
		if(loginSuccess) {
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/fail.jsp").forward(req, resp);
		}
		
		//문자열 내보내기
		
		
	}
}
