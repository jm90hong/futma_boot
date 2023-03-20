package com.futma.futma_boot.vo;

public class UserLike {
	
	private long u_like_idx=0;
	private int star_user_idx=0;
	private int fan_user_idx=0;
	private String created_date=null;
	
	
	public long getU_like_idx() {
		return u_like_idx;
	}
	public void setU_like_idx(long u_like_idx) {
		this.u_like_idx = u_like_idx;
	}
	
	public int getStar_user_idx() {
		return star_user_idx;
	}
	public void setStar_user_idx(int star_user_idx) {
		this.star_user_idx = star_user_idx;
	}
	public int getFan_user_idx() {
		return fan_user_idx;
	}
	public void setFan_user_idx(int fan_user_idx) {
		this.fan_user_idx = fan_user_idx;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	
	
	
}
