package com.kh.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test03")
public class TestServlet03 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		
		String age = req.getParameter("age");
		int numAge = Integer.parseInt(age);
		if(numAge>20) {
			out.write("성인입니다.");
		}
		else {
			out.write("미성년입니다.");
		}
		
	}
	
}
