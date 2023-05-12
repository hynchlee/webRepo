package com.kh.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test01")
public class TestServlet01 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		
		resp.setContentType("text/html; charset=UTF=8;");
		PrintWriter out = resp.getWriter();
		
		if(name.equals("swy")) {
			System.out.println("성공");
		}
		
	}
	
}
