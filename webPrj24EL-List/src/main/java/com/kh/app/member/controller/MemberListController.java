package com.kh.app.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/list")
public class MemberListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//데이터 꺼내기
			
			//데이터 뭉치기			
			
			//서비스
			MemberService ms = new MemberService();
			List<MemberVo> voList = ms.selectList();
			
			//화면
			req.setAttribute("voList",voList);
			req.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("[ERROR] 회원 조회 중 오류 발생");
			e.printStackTrace();
			
			req.getRequestDispatcher("에러").forward(req, resp);
		}
		
	}
	
}
