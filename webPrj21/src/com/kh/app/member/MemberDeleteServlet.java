package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id = req.getParameter("id");
		
		int result = 0;
		try {
			Connection conn = JDBCTemplate.getConnection();
			String sql = "DELETE FROM MEMBER WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.rollback(conn);
			}
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		} catch (Exception e) {
			System.out.println("[ERROR] 회원 탈퇴 중 예외 발생");
			e.printStackTrace();
		}
		
		if(result == 1) {
			req.getSession().invalidate();
			resp.sendRedirect("/app21");
		}
		else {
			resp.sendRedirect("/app21/errr");
		}
		
		
		
		
	}
	
}
