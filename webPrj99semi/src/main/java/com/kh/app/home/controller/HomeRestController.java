package com.kh.app.home.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.home.service.HomeService;

@WebServlet("/home/board-top-hit")
public class HomeRestController extends HttpServlet{

	//SELECT * FROM BOARD WHERE HIT = (SELECT MAX(HIT) FROM BOARD WHERE STATUS = 'O')
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HomeService hs = new HomeService();
			BoardVo vo = hs.getBoardTopHit();
			
			Gson gson = new Gson();
			String str = gson.toJson(vo);
			
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(str);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resp.getWriter().write("errrrrr");
		}
	}
	
}
