package com.bit2017.jblog.vo;

public class BlogVo {
	private String saveFile;
	private String title;
	private String id;

	public String getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "BlogVo [saveFile=" + saveFile + ", title=" + title + ", id=" + id + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
