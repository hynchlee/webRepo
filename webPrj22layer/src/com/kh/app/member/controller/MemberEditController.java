package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/edit")
public class MemberEditController extends HttpServlet {

	// 회원정보 수정
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			String no = loginMember.getNo();

			// 서비스 로직
			MemberService ms = new MemberService();
			MemberVo dbMember = ms.selectOneByNo(no);

			// 화면 보여주기
			req.setAttribute("dbMember", dbMember);
			req.getRequestDispatcher("/WEB-INF/views/member/editForm.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("[ERROR] 마이페이지 화면 조회 중 예외 발생");
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//데이터 준비
			String memberPwd = req.getParameter("memberPwd");
			String memberNick = req.getParameter("memberNick");
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String MemberNo = loginMember.getNo();
			
			MemberVo vo = new MemberVo();
			vo.setPwd(memberPwd);
			vo.setNick(memberNick);
			vo.setNo(MemberNo);
			
			//서비스 로직
			MemberService ms = new MemberService();
			ms.edit(vo);
					
			//화면
			session.invalidate();
			resp.sendRedirect("/app22");
			
		} catch (Exception e) {
			System.out.println("[ERROR] 회원정보 수정 중 예외 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "회원정보 수정 중 예외 발생");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}

}











