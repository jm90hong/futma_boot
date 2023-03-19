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
	private int review_cnt=0;
	private String created_date = null;
	private int make_cnt=0;
	private int join_cnt=0;
	private String text_msg=null;
	
	
	//manager 
	private String act_addr1=null;
	private String act_addr2=null;
	private String owner_ny=null;

	
	
	
	public int getReview_cnt() {
		return review_cnt;
	}
	public void setReview_cnt(int review_cnt) {
		this.review_cnt = review_cnt;
	}
	public String getText_msg() {
		return text_msg;
	}
	public void setText_msg(String text_msg) {
		this.text_msg = text_msg;
	}
	public int getMake_cnt() {
		return make_cnt;
	}
	public void setMake_cnt(int make_cnt) {
		this.make_cnt = make_cnt;
	}
	public int getJoin_cnt() {
		return join_cnt;
	}
	public void setJoin_cnt(int join_cnt) {
		this.join_cnt = join_cnt;
	}
	public String getAct_addr1() {
		return act_addr1;
	}
	public void setAct_addr1(String act_addr1) {
		this.act_addr1 = act_addr1;
	}
	public String getAct_addr2() {
		return act_addr2;
	}
	public void setAct_addr2(String act_addr2) {
		this.act_addr2 = act_addr2;
	}
	public String getOwner_ny() {
		return owner_ny;
	}
	public void setOwner_ny(String owner_ny) {
		this.owner_ny = owner_ny;
	}
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
