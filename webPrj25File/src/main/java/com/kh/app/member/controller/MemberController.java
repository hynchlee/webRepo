package com.kh.app.member.controller;

import java.io.IOException;

import javax.print.attribute.PrintServiceAttribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.FileUploader;

@MultipartConfig(
//		location = "",						// fileSizeThreshold 초과하면 여기에 임시 저장
//		fileSizeThreshold = "",				//ram에 할당할 최대 용량
		maxFileSize = 1024 * 1024 * 50, // 파일 하나당 크기 제한
		maxRequestSize = 1024 * 1024 * 50 * 5 // 리퀘스트 전체 크기 제한
)
@WebServlet("/member/join")
public class MemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberNick = req.getParameter("memberNick");
			// String proFile = req.getParameter("file");
			Part f = req.getPart("proFile");

			// 파일 업로드 시작
			String path = req.getServletContext().getRealPath("/resources/img/");
			String changeName = FileUploader.upload(f, path);

			// 데이터 뭉치기
			MemberVo vo = new MemberVo();
			vo.setId(memberId);
			vo.setPwd(memberPwd);
			vo.setNick(memberNick);
			vo.setProfile(changeName);

			// 서비스
			MemberService ms = new MemberService();
			int result = ms.join(vo);

			if (result == 1) {
				resp.sendRedirect("/app25/home");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("[ERROR] 회원가입 중 예외 발생");
			e.printStackTrace();
		}
	}

}
