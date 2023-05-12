package com.kh.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class TestServlet11 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html; charset=UTF-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String []hobby = req.getParameterValues("hobby");
		
		for(String x:hobby) {
			System.out.println(x);
		}
		System.out.println(hobby);
		
		PrintWriter out = resp.getWriter();
		
		if(pwd.length()>4) {
			out.write("<h1>회원가입 성공</h1>");
		}
		else {
			out.write("<h1>실패</h1>");
		}
	}
	
}
