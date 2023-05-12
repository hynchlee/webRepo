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
import javax.websocket.Session;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet{

	//로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(req, resp);
	}
	
	//로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setMemberId(memberId);
		vo.setMemberPwd(memberPwd);
		
		//서비스 로직
		MemberVo loginMember = null;
		try {
			Connection conn = JDBCTemplate.getConnection();
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPwd());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbId = rs.getString("ID");
				String dbPwd = rs.getString("PWD");
				String dbNick = rs.getString("NICK");
				
				loginMember = new MemberVo();
				
				loginMember.setMemberId(dbId);
				loginMember.setMemberPwd(dbPwd);
				loginMember.setMemberNick(dbNick);
			}
			
			JDBCTemplate.close(conn);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
		} catch (Exception e) {
			System.out.println("[ERROR] 예외 발생");
			e.printStackTrace();
		}
		
		if(loginMember != null) {
			
			HttpSession session = req.getSession();
			session.setAttribute("nick", loginMember.getMemberNick());
			session.setAttribute("id", loginMember.getMemberId());
			resp.sendRedirect("/app21/home");
//			req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		}
		else {

		}
		
	}
	
}
