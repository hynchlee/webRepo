package com.kh.app.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kh.app.member.vo.MemberVo;

@WebFilter("/admin/*")
public class AdminChecher implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("어디민 체크");
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		// 관리자 체크
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");

		if (loginMember == null || !"ADMIN".equals(loginMember.getId())) {
			throw new IllegalStateException("관리자만 가능");
		}
		
		chain.doFilter(req, response);

	}

}
