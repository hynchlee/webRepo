package com.kh.app.admin.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class AdminMemberDao {

	public List<MemberVo> getMemberList(Connection conn) throws Exception {

		String sql = "SELECT * FROM MEMBER ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		List<MemberVo> voList = new ArrayList<>();
		while (rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String profile = rs.getString("PROFILE");
			String hobby = rs.getString("HOBBY");
			String status = rs.getString("STATUS");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");

			MemberVo vo = new MemberVo();
			vo.setNo(no);
			vo.setNick(nick);
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setProfile(profile);
			vo.setHobby(hobby);
			vo.setStatus(status);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);

			voList.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return voList;

	}

	public int restrainMember(String no, Connection conn) throws SQLException {

		String sql = "UPDATE MEMBER SET STATUS = 'S' WHERE NO = ? AND STATUS != 'X'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result ;
	}

	public int restrainMembers(Connection conn, String[] noArr) throws Exception {

		String str = String.join(",", noArr);
		
		String sql = "UPDATE MEMBER SET STATUS = 'S' WHERE NO IN (" + str + ")";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		int result = pstmt.executeUpdate();
				
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}
