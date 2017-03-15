package com.bit2017.jblog.vo;

public class CategoryVo {
	private Long no;
	private String title;
	private String explain;
	private String regDate;
	private String id;

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", title=" + title + ", explain=" + explain + ", regDate=" + regDate + ", id="
				+ id + "]";
	}
}
