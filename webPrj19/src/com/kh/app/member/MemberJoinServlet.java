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
public class MemberJoinServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");

		// 서비스 로직(디비에서 insert)

		int result = 0;
		
		try {
			// 1. 디비연결 == 커넥션 준비
			Connection conn = JDBCTemplate.getConnection();

			// 2. sql 실행
			String sql = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			pstmt.setString(3, memberNick);
			result = pstmt.executeUpdate();
			
			// 3. tx || rs → obj, close
			if (result == 1) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
			
		} catch (Exception e) {
			System.out.println("[ERROR] 회원가입 중 예외 발생..");
			e.printStackTrace();
		}
		
		if(result == 1) {
			req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}

	}
}