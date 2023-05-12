package com.kh.app.util.page;

public class PageVo {

	private int listCount; // 총 게시글 갯수
	private int currentPage; // 현재페이지
	private int pageLimit; // 페이징 영역에 보여줄 최대 갯수
	private int boardLimit; // 한 페이지에서 보여줄 게시글 최대 갯수
	private int maxPage; // 마지막 페이지
	private int startPage; // 페이징 영역 시작값
	private int endPage; // 페이징 영역 종료값

	public PageVo(int listCount, int currentPage, int pageLimit, int boardLimit) {

		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		
		int maxPage = (int) Math.ceil((double) listCount / boardLimit);
		int startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getListCount() {
		return listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	

}
