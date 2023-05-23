package com.kh.app.gallery.vo;

public class GalleryVo {

	private String no;
	private String title;
	private String content;
	private String writerNo;
	private String originName;
	private String changeName;
	private String enrollDate;
	private String status;
	private String hit;
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
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
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
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public GalleryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GalleryVo(String no, String title, String content, String writerNo, String originName, String changeName,
			String enrollDate, String status, String hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
		this.originName = originName;
		this.changeName = changeName;
		this.enrollDate = enrollDate;
		this.status = status;
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", title=" + title + ", content=" + content + ", writerNo=" + writerNo
				+ ", originName=" + originName + ", changeName=" + changeName + ", enrollDate=" + enrollDate
				+ ", status=" + status + ", hit=" + hit + "]";
	}
	
	
	
}
