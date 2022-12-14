package com.futma.futma_boot.vo;

public class User {
	
	
	private long user_idx=0;
	private String id = null;
	private String login_type = null;
	private String nick=null;
	private String tel=null;
	private String image_url=null;
	private String small_image_url=null;
	private String manager_ny=null;
	private String mng_req_state=null;
	private float star_rank=0;
	private int reply_cnt=0;
	private String created_date = null;
	

	
	
	
	
	
	public String getSmall_image_url() {
		return small_image_url;
	}
	public void setSmall_image_url(String small_image_url) {
		this.small_image_url = small_image_url;
	}
	public float getStar_rank() {
		return star_rank;
	}
	public void setStar_rank(float star_rank) {
		this.star_rank = star_rank;
	}
	public int getReply_cnt() {
		return reply_cnt;
	}
	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getMng_req_state() {
		return mng_req_state;
	}
	public void setMng_req_state(String mng_req_state) {
		this.mng_req_state = mng_req_state;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getManager_ny() {
		return manager_ny;
	}
	public void setManager_ny(String manager_ny) {
		this.manager_ny = manager_ny;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public long getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(long user_idx) {
		this.user_idx = user_idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin_type() {
		return login_type;
	}
	public void setLogin_type(String login_type) {
		this.login_type = login_type;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	
}
