package com.kh.app.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("method called....");
		
		//클라이언트와 연결된 통로(내보내는)
		PrintWriter pw = resp.getWriter();
		pw.write("<!DOCTYPE html>");
		pw.write("<html>");
		pw.write("<head>");
		pw.write("</head>");
		pw.write("<body>");
		pw.write("<h1>abracatabra</h1>");		
		pw.write("</body>");
		pw.write("<html>");
		
		
	}
	//req = 클라이언트한테 받은 정보를 가지고있음
	//resp = 클라이언트에게 응답할 내용
	
}
