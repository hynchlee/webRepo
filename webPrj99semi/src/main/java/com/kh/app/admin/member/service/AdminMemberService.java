package com.kh.app.admin.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.app.admin.member.dao.AdminMemberDao;
import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class AdminMemberService {

	public List<MemberVo> getMemberList() throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		AdminMemberDao dao = new AdminMemberDao();
		List<MemberVo> list = dao.getMemberList(conn);

		JDBCTemplate.close(conn);

		return list;
	}

	public int restrainMember(String no) throws SQLException {

		Connection conn = JDBCTemplate.getConnection();
		
		AdminMemberDao dao = new AdminMemberDao();
		int result = dao.restrainMember(no, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int restrainMembers(String[] noArr) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		AdminMemberDao dao = new AdminMemberDao();
		int result = dao.restrainMembers(conn, noArr);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
