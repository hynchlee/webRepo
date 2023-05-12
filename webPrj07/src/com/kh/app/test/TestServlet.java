package com.kh.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String nick = req.getParameter("nick");
		System.out.println(nick);
				
		//문자열 내보내기
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		out.write("<h1>"+nick+"님 환영합니다.</h1>");
		
	}
	
}
