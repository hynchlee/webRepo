package com.kh.app.util.file;

public class AttachmentVo {

	private String originName;
	private String changeName;
	@Override
	public String toString() {
		return "AttachmentVo [originName=" + originName + ", changeName=" + changeName + "]";
	}
	public AttachmentVo(String changeName) {
		super();
		this.changeName = changeName;
	}
	public AttachmentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getChangeName() {
		return changeName;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	
}
