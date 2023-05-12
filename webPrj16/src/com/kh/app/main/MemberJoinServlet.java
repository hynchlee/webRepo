package com.kh.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//데이터 꺼내기
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		//유효성 검사
		boolean joinOk = true;
		if(pwd.length()<=4) {
			joinOk = false;
		}
		
		//문자열 내보내기
		req.setAttribute("k01", joinOk);
		req.getRequestDispatcher("/result.jsp").forward(req,resp);
		
//		if(joinOk) {
//			req.getRequestDispatcher("/ok.jsp").forward(req,resp);
//		}else {
//			req.getRequestDispatcher("/fail.jsp").forward(req,resp);
//		}
	}
	
}
