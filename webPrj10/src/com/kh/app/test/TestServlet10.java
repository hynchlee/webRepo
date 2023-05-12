package com.kh.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test10")
public class TestServlet10 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html; charset=UTF-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		PrintWriter out = resp.getWriter();

		System.out.println("입력하신 패스워드의 길이는{"+pwd.length()+"}입니다.");
	}
	
}
