package com.kh.app.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileUpload;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.file.AttachmentVo;
import com.kh.app.util.file.FileUploader;

@MultipartConfig(
			maxFileSize = 1024*1024*100,
			maxRequestSize = 1024*1024*1000
			
		)
@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet { 

	//게시글 작성하기 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//로그인 안하면 에러페이지로 보내기
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		if(loginMember == null) {
			req.setAttribute("errorMsg", "로그인을 먼저 해주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			return;
		}
		
		BoardService bs = new BoardService();
		List<CategoryVo> cvoList = new ArrayList<>();
		try {
			cvoList = bs.getCategoryList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//카테고리 리스트 넘기기
		req.setAttribute("cvoList", cvoList);
		
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}
	
	//게시글 작성하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//현재 로그인 한 아이디
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			
			//파일 업로드
			List<Part> fList = new ArrayList<>();
			Collection<Part> parts = req.getParts();
			for(Part part : parts) {
				if (part.getName().equals("f")) {
					fList.add(part);
				}
			}
			
			String path = req.getServletContext().getRealPath("/static/img/board");
			List<AttachmentVo> attVoList = FileUploader.saveFile(path, fList);
			
			
			// 데꺼
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String categoryNo = req.getParameter("categoryNo");
			String writerNo = loginMember.getNo();
			
			// 데뭉
			BoardVo bvo = new BoardVo();
			bvo.setTitle(title);
			bvo.setContent(content);
			bvo.setCategoryNo(categoryNo);
			bvo.setWriterNo(writerNo);
			
			// 서비스
			BoardService bs = new BoardService();
			int result = bs.write(bvo, attVoList);
			int result2 = bs.write(bvo, attVoList);
			
			// 화면
			if(result == 1) {
				//성공
				resp.sendRedirect(req.getContextPath() + "/board/list");
			}else {
				//실패
				throw new IllegalStateException("게시글 작성 결과 1 아님 ..."); 
			}
			
		} catch (Exception e) {
			//실패
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 작성 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}
	
}//class




















