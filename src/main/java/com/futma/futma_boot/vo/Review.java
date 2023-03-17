package com.futma.futma_boot.vo;

public class Review {
	private int rv_idx=0;
	private int wr_user_idx=0;
	private int rv_user_idx=0;
	private String content=null;
	private String reply=null;
	private int star = 0;
	private String created_date=null;
	
	
	//user
	private String nick=null;
	private String image_url=null;
	
	
	
	
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public int getRv_idx() {
		return rv_idx;
	}
	public void setRv_idx(int rv_idx) {
		this.rv_idx = rv_idx;
	}
	public int getWr_user_idx() {
		return wr_user_idx;
	}
	public void setWr_user_idx(int wr_user_idx) {
		this.wr_user_idx = wr_user_idx;
	}
	public int getRv_user_idx() {
		return rv_user_idx;
	}
	public void setRv_user_idx(int rv_user_idx) {
		this.rv_user_idx = rv_user_idx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	
	
	
	
}
