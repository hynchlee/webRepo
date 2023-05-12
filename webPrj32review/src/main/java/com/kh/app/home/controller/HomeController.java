package com.kh.app.home.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String x = req.getParameter("msg");
		
		req.setAttribute("msg", x);
//		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		resp.sendRedirect("/app/WEB-INF/views/home.jsp");
		
				
	}
	
}
