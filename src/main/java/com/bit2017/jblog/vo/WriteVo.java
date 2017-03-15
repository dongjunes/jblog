package com.bit2017.jblog.vo;

public class WriteVo {

	private Long no;
	private String title;
	private String content;
	private String regDate;
	private String category;
	private Long categoryNo;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	@Override
	public String toString() {
		return "WriteVo [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", category=" + category + ", categoryNo=" + categoryNo + "]";
	}
	
}
