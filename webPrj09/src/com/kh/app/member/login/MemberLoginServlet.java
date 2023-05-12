package com.kh.app.member.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//id, pwd 꺼내기
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		// admin / 1234 들어오면 로그인 성공! 글씨 화면에 보여주기
		// 아니면 로그인 실패 글씨 보여주기
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		
		if(id.equals("admin")&&pwd.equals("1234")) {
			out.write("<script>");
			out.write("alert('로그인 성공')");
			out.write("</script>");
		}
		else {
			out.write("<script>");
			out.write("alert('로그인 실패')");
			out.write("</script>");
		}
		
	}
	
}
