package com.futma.futma_boot.vo;

public class Notice {
		
	
	private int nt_idx=0;
	private String type=null;
	private String title=null;
	private String content=null;
	private String img_url=null;
	private int view_cnt=0;
	private String created_date=null;
	
	public int getNt_idx() {
		return nt_idx;
	}
	public void setNt_idx(int nt_idx) {
		this.nt_idx = nt_idx;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	
	
}
