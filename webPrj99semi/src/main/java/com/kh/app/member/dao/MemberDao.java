package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) throws Exception {
		//SQL
		String sql = "INSERT INTO MEMBER(NO, ID, PWD, NICK, HOBBY, PROFILE) VALUES(SEQ_MEMBER_NO.NEXTVAL , ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		pstmt.setString(4, vo.getHobby());
		pstmt.setString(5, vo.getProfile());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		return result;
	}

	public MemberVo login(Connection conn, MemberVo vo) throws Exception {
		
		//SQL
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//tx || rs 
		MemberVo loginMember = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String profile = rs.getString("PROFILE");
			String hobby = rs.getString("HOBBY");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			
			loginMember = new MemberVo();
			loginMember.setNo(no);
			loginMember.setId(id);
			loginMember.setPwd(pwd);
			loginMember.setNick(nick);
			loginMember.setProfile(profile);
			loginMember.setHobby(hobby);
			loginMember.setEnrollDate(enrollDate);
			loginMember.setModifyDate(modifyDate);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginMember;
	}//method

	public int edit(Connection conn, MemberVo vo) throws Exception {
		String sql = "UPDATE MEMBER SET NICK = ? , HOBBY = ? ";
		if(vo.getPwd() != null && vo.getPwd().length() > 0) {
			sql += ", PWD = ?";
		}
		sql += ", MODIFY_DATE = SYSDATE WHERE NO = ? AND STATUS = 'O'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNick());
		pstmt.setString(2, vo.getHobby());
		if(vo.getPwd() != null && vo.getPwd().length() > 0) {
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getNo());
		}else {
			pstmt.setString(3, vo.getNo());
		}
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public MemberVo selectOneByNo(Connection conn, String no) throws Exception {
		
		String sql = "SELECT * FROM MEMBER WHERE NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo vo = null;
		if(rs.next()) {
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String profile = rs.getString("PROFILE");
			String hobby = rs.getString("HOBBY");
			
			vo = new MemberVo();
			vo.setNo(no);
			vo.setId(id);
			vo.setId(pwd);
			vo.setNick(nick);
			vo.setProfile(profile);
			vo.setHobby(hobby);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	public int quit(Connection conn, String no) throws Exception {

		String sql = "UPDATE MEMBER SET STATUS ='X' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
}//class

