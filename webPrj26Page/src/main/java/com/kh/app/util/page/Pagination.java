package com.kh.app.util.page;

public class Pagination {

	public static PageVo getPageVo(int listCount, int currentPage, int pageLimit, int boardLimit) {

		int maxPage = (int) Math.ceil((double) listCount / boardLimit);
		int startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
//		PageVo pv = new PageVo();
//		pv.setxxx();
		return null;
		
	}

}
