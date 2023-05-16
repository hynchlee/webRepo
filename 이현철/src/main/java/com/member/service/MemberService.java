package com.member.service;

import java.sql.Connection;

import com.kh.app.util.JDBCTemplate;
import com.member.dao.MemberDao;
import com.member.vo.MemberVo;

public class MemberService {

	public int joinForm(MemberVo vo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		int result = dao.joinForm(vo, conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public MemberVo login(MemberVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(vo, conn);
		
		if(loginMember != null) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.close(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return loginMember;
	}

	public int edit(MemberVo vo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		int result = dao.edit(vo, conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	

}
