package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) throws SQLException {
		String sql = "INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);

		return result;
	}

	public List<MemberVo> selectList(Connection conn) throws SQLException {
		String sql = "SELECT*FROM MEMBER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		List<MemberVo> voList = new ArrayList<>();
		while (rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");

			MemberVo vo = new MemberVo();
			vo.setNo(no);
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setNick(nick);

			voList.add(vo);
		}

		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);

		return voList;
	}

	public MemberVo login(Connection conn, MemberVo vo) throws SQLException {
		String sql = "SELECT*FROM MEMBER WHERE ID = ? AND PWD = ?";
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

			loginMember = new MemberVo();
			loginMember.setNo(no);
			loginMember.setId(id);
			loginMember.setPwd(pwd);
			loginMember.setNick(nick);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return loginMember;

	}

	public int edit(Connection conn, MemberVo vo) throws SQLException {

		String sql = "UPDATE MEMBER SET PWD = ?, NICK = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPwd());
		pstmt.setString(2, vo.getNick());
		pstmt.setString(3, vo.getNo());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);	

		return result;
	}

	//회원조회
	public MemberVo selectOneByNo(Connection conn, String no) throws SQLException {
		String sql = "SELECT*FROM MEMBER WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo vo = null;
		if(rs.next()) {
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			
			vo = new MemberVo();
			vo.setNo(no);
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setNick(nick);
		}
		
		return vo;
	}

}
