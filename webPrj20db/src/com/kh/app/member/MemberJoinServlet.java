package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		int result = 0;
		
		try {
			Connection conn = JDBCTemplate.getConnection();
			String sql = "INSERT INTO MEMBER VALUES(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			pstmt.setString(3, memberNick);
			
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.rollback(conn);
			}
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
			
		} catch (Exception e) {
			System.out.println("[ERROR] 회원가입 중 예외 발생");
			e.printStackTrace();
		}
		if(result == 1) {
			req.setAttribute("resultMsg", "성공!");			
		}
		else {
			req.setAttribute("resultMsg", "실패!");
		}
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
	}
	
}
