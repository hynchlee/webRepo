package com.kh.app.notice.vo;

public class NoticeReplyVo {

	private String no;
	private String noticeNo;
	private String content;
	private String writerNo;
	private String enrollDate;
	private String status;
	public NoticeReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeReplyVo(String no, String noticeNo, String content, String writerNo, String enrollDate,
			String status) {
		super();
		this.no = no;
		this.noticeNo = noticeNo;
		this.content = content;
		this.writerNo = writerNo;
		this.enrollDate = enrollDate;
		this.status = status;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
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
	@Override
	public String toString() {
		return "NoticeReplyVo [no=" + no + ", noticeNo=" + noticeNo + ", content=" + content + ", writerNo=" + writerNo
				+ ", enrollDate=" + enrollDate + ", status=" + status + "]";
	}
	
	
}
