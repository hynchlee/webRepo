package com.kh.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test08")
public class TestServlet08 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html; charset=UTF-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		PrintWriter out = resp.getWriter();
		
		out.write(title);
		out.write(content);
		
	}
	
}
