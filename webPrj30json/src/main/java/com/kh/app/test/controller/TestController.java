package com.kh.app.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/test")
public class TestController extends HttpServlet{

	//요청이 들어오면, hello라는 글자를 응답
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		List<MemberVo> voList = new ArrayList<>();
		
		MemberVo vo1 = new MemberVo();
		vo1.setMemberId("user01");
		vo1.setMemberPwd("1234");
		vo1.setMemberNick("nick01");
		voList.add(vo1);
		
		MemberVo vo2 = new MemberVo();
		vo2.setMemberId("user02");
		vo2.setMemberPwd("1234");
		vo2.setMemberNick("nick03");
		voList.add(vo2);
		
		MemberVo vo3 = new MemberVo();
		vo3.setMemberId("user03");
		vo3.setMemberPwd("1234");
		vo3.setMemberNick("nick03");
		voList.add(vo3);
		
		Gson gson = new Gson();
		String str = gson.toJson(voList);
		
		out.write(str);
		
	}
	
}
