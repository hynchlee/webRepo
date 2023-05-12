package com.kh.app.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.notice.service.NoticeService;
import com.kh.app.notice.vo.NoticeReplyVo;

@WebServlet("/notice/reply/write")
public class NoticeReplyWriteController extends HttpServlet{

	//
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			
			String noticeNo = req.getParameter("noticeNo");
			String content= req.getParameter("content");
			String writertNo = loginMember.getNo();
			
			NoticeReplyVo vo = new NoticeReplyVo();
			vo.setNoticeNo(noticeNo);
			vo.setContent(content);
			vo.setWriterNo(writertNo);
			
			NoticeService ns = new NoticeService();
			int result = ns.replyWrite(vo);
			
			System.out.println("댓글 작성 결과 : " + result);
			PrintWriter out = resp.getWriter();
			if(result == 1) {
				out.write("zzzzzzzzzhallo");
				out.write("2md");
			}
			
			
		} catch (Exception e) {
			System.out.println("ERROR notice reply er");
			
			req.setAttribute("errorMsg", "er");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
	
}
