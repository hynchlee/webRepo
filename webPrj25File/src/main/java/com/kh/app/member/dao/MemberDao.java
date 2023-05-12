package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) throws SQLException {

		String sql = "INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		pstmt.setString(4, vo.getProfile());

		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);

		return result;
	}

	public MemberVo login(Connection conn, MemberVo vo) throws SQLException {
		// sql
		String sql = "select * from member where id = ? and pwd = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();

		MemberVo loginMember = null;
		if (rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String profile = rs.getString("PROFILE");

			loginMember = new MemberVo();
			loginMember.setNo(no);
			loginMember.setId(id);
			loginMember.setProfile(profile);
			loginMember.setPwd(pwd);
			loginMember.setNick(nick);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginMember;
	}
}
