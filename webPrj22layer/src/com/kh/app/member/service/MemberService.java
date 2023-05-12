package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {
	
	//회원가입 
	public int join(MemberVo vo) throws Exception {
		
		int result = 0; 
		
		//1. conn
		Connection conn = JDBCTemplate.getConnection();
		
		//2. SQL
		MemberDao dao = new MemberDao();
		result = dao.join(conn, vo);
		
		//3. tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//4. close
		JDBCTemplate.close(conn);
			
		return result;
	}//method

	//회원 한명 조회
	public MemberVo selectOneByNo(String no) throws Exception {
		
		//1. conn
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		MemberVo vo = dao.selectOneByNo(conn, no);
		
		//4. close
		JDBCTemplate.close(conn);
		
		return vo;
		
	}

	//회원정보 수정
	public int edit(MemberVo vo) throws Exception {
		
		//1. conn
		Connection conn = JDBCTemplate.getConnection();
		
		//2. SQL
		MemberDao dao = new MemberDao();
		int result = dao.edit(conn , vo);
		
		
		//3. tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//4. close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//회원탈퇴
	public int deleteByNo(String no) throws Exception {
		
		//1. conn
		Connection conn = JDBCTemplate.getConnection();
		
		//2. SQL
		MemberDao dao = new MemberDao();
		int result = dao.deleteByNo(conn , no);
		
		//3. tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//4. close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//로그인
	public MemberVo login(MemberVo vo) throws Exception {
		
		//1. conn
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn , vo);
		
		//4. close
		JDBCTemplate.close(conn);
		
		return loginMember;
	}

	public List<MemberVo> selectList() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT * FROM MEMBER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<MemberVo> list = new ArrayList<>();
		
		while( rs.next() ) {
		
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			
			MemberVo vo = new MemberVo();
			vo.setNo(no);
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setNick(nick);
			
			list.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		return list;
		
	}
	

}









