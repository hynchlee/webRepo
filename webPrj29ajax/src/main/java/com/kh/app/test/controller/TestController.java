package com.kh.app.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("method called...");
		
		PrintWriter out = resp.getWriter();
		out.write("<!DOCTYPE HTML>");
		out.write("<html>");
		out.write("<head>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>");
		out.write("hello ~~~ !!!");
		out.write("</h1>");
		out.write("</body>");
		out.write("</html>");
		
	}

}//class






















