package com.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.util.JDBCTemplate;
import com.member.vo.MemberVo;

public class MemberDao {

	public int joinForm(MemberVo vo, Connection conn) throws Exception {

		String sql = "INSERT INTO MEMBER(NAME, ID, PWD, EMAIL, PHONE, ADMIN_YN) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getId());
		pstmt.setString(3, vo.getPwd());
		pstmt.setString(4, vo.getEmail());
		pstmt.setString(5, vo.getPhone());
		pstmt.setString(6, vo.getAdminYn());

		int result = pstmt.executeUpdate();

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(pstmt);

		return result;
	}

	public MemberVo login(MemberVo vo, Connection conn) throws Exception {

		String sql = "SELECT*FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo loginMember = null;
		if(rs.next()) {
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String name = rs.getString("NAME");
			
			loginMember = new MemberVo();
			loginMember.setId(id);
			loginMember.setPwd(pwd);
			loginMember.setName(name);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return loginMember;
	}

	public int edit(MemberVo vo, Connection conn) throws Exception {

		String sql = "UPDATE MEMBER NAME = ? AND ID = ? AND PWD = ? AND PHONE = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getId());
		pstmt.setString(3, vo.getPwd());
		pstmt.setString(4, vo.getPhone());
		
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(pstmt);
		
		
		return result;
	}

	

}
