package com.kh.app.home.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUtils;

@WebServlet("/member/profile/down")
public class MemberProfileDownController extends HttpServlet{

	//프로필 사진 다운
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filename = req.getParameter("filename");
		
		//다운로드		
		String path = req.getServletContext().getRealPath("/resources/img/");
		File f = new File(path+filename);
		FileInputStream fis = new FileInputStream(f);
		
		byte[] buf = new byte[1024*1024*50];
		int size = fis.read(buf);
		
		resp.setHeader("Content-Type", "application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment; filename=abc.png");
		resp.setHeader("Content-Length", String.valueOf(f.length()));
		
		resp.getOutputStream().write(buf,0,size);
		
	}
	
}
