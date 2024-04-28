package com.futma.futma_boot.vo;

public class ManagerImg {
	private int mng_img_idx=0;
	private int mng_idx=0;
	private String img_url=null;
	private String strg_name=null;
	private String created_date=null;
	
	
	
	public String getStrg_name() {
		return strg_name;
	}
	public void setStrg_name(String strg_name) {
		this.strg_name = strg_name;
	}
	public int getMng_img_idx() {
		return mng_img_idx;
	}
	public void setMng_img_idx(int mng_img_idx) {
		this.mng_img_idx = mng_img_idx;
	}
	public int getMng_idx() {
		return mng_idx;
	}
	public void setMng_idx(int mng_idx) {
		this.mng_idx = mng_idx;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	
	
}
