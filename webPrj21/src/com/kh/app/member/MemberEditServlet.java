package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/edit")
public class MemberEditServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id = req.getParameter("id");
		
		MemberVo loginMember = null;
		try {
			Connection conn = JDBCTemplate.getConnection();
			String sql = "SELECT * FROM MEMBER WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
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
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			
		} catch (Exception e) {
			System.out.println("[ERROR] 마이페이지 화면 조회 중 에러 발생");
			e.printStackTrace();
		}
		
		//키값 전달
		req.setAttribute("loginMember", loginMember);
		req.getRequestDispatcher("/WEB-INF/views/member/edit.jsp").forward(req, resp);
	}
	
	//회원정보 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		MemberVo vo = new MemberVo();
		vo.setMemberId(memberId);
		vo.setMemberPwd(memberPwd);
		vo.setMemberNick(memberNick);
		
		int result = 0;
		try {
			Connection conn = JDBCTemplate.getConnection();
			String sql = "UPDATE MEMBER SET PWD = ? WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberPwd());
			pstmt.setString(2, vo.getMemberId());
			
			result = pstmt.executeUpdate();
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.close(conn);
			}
			
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			
		} catch (Exception e) {
			System.out.println("[ERROR] 정보 수정 중 예외 발생");
			e.printStackTrace();
		}
		
		if(result == 1) {
			req.setAttribute("msg", "수정성공");
			req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);			
		}
		else {
			req.setAttribute("msg", "수정실패");
			req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		}
	}
}
