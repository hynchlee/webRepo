package com.kh.app.member.vo;

public class MemberVo {
	
	private String no;
	private String id;
	private String pwd;
	private String nick;
	private String profile;
	private String hobby;
	private String status;
	private String enrollDate;
	private String modifyDate;
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", profile=" + profile
				+ ", hobby=" + hobby + ", status=" + status + ", enrollDate=" + enrollDate + ", modifyDate="
				+ modifyDate + "]";
	}
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String no, String id, String pwd, String nick, String profile, String hobby, String status,
			String enrollDate, String modifyDate) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.profile = profile;
		this.hobby = hobby;
		this.status = status;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	
	
}
