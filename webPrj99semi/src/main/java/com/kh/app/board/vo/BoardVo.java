package com.kh.app.board.vo;

public class BoardVo {


	private String no;
	private String title;
	private String content;
	private String writerNo;
	private String categoryNo;
	private String enrollDate;
	private String status;
	private String modifyDate;
	private String hit;
	
	private String writerName;
	private String categoryName;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVo(String no, String title, String content, String writerNo, String categoryNo, String enrollDate,
			String status, String modifyDate, String hit, String writerName, String categoryName) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
		this.categoryNo = categoryNo;
		this.enrollDate = enrollDate;
		this.status = status;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.writerName = writerName;
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", writerNo=" + writerNo
				+ ", categoryNo=" + categoryNo + ", enrollDate=" + enrollDate + ", status=" + status + ", modifyDate="
				+ modifyDate + ", hit=" + hit + ", writerName=" + writerName + ", categoryName=" + categoryName + "]";
	}
	
	
	
}
