package com.kh.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test05")
public class TestServlet05 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html; charset=UTF-8;");
		String menu = req.getParameter("menu");
		PrintWriter out = resp.getWriter();
		
		out.write("<h1>주문하신 메뉴는" + menu + "이빈다.</h1>");
	}
	
}
