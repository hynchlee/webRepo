package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.compiler.JDTCompiler;
import org.apache.tomcat.dbcp.dbcp2.Jdbc41Bridge;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {

	public int join(MemberVo vo) throws SQLException {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<MemberVo> selectList() throws SQLException {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		List<MemberVo> voList = dao.selectList(conn);
		
		JDBCTemplate.close(conn);
		
		return voList;
		
	}

	public MemberVo login(MemberVo vo) throws SQLException {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return loginMember;

	}

	//정보수정
	public MemberVo edit(MemberVo vo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		MemberVo updatedMember = null;
		
		try {
		
			MemberDao dao = new MemberDao();
			int result = dao.edit(conn, vo);
			
			if(result == 1) {
				updatedMember = dao.selectOneByNo(conn, vo.getNo());
				if(updatedMember == null) {
					JDBCTemplate.rollback(conn);
					throw new Exception("업데이트 되었지만 셀렉트 실패");
				}
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.rollback(conn);
			}
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return updatedMember;
		
	}

	public int del(String no) throws SQLException {
		
		Connection conn = JDBCTemplate.getConnection();
		String sql = "DELETE FROM MEMBER WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
}
