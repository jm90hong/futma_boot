package com.futma.futma_boot.vo;

public class Game {
	
	//play
	private long game_idx=0;
	private long user_idx=0;
	private long stadium_idx=0;
	private String start_date=null;
	private String weekday=null;
	private int start_hr=0;
	private String start_time_str=null;
	private long start_time_mill=0l;
	private long end_time_mill=0l;
	private int period_hr=0;
	private int num_to_num=0;
	private int hw_mny_team=0;
	private String gender=null;
	private String team_or_person=null;
	private String free_or_pay=null;
	private String end_game_ny=null;
	private int price=0;
	private String content=null;
	private int now_player_cnt=0;
	private int player_cnt=0;
	private String del_ny = null;
	private String modified_date=null;
	private String created_date=null;
	private String pay_link_url=null;
	
	
	//stadium
	private String name=null;
	private String location=null;
	private String std_img_url=null;
	private String address=null;
	
	
	//user
	private String nick = null;
	private String image_url=null;
	private float star_rank=0;
	private int review_cnt=0;
	
	
	
	//manager
	private String bank_name = null;
	private String bank_account = null;
	


	
	public String getPay_link_url() {
		return pay_link_url;
	}

	public void setPay_link_url(String pay_link_url) {
		this.pay_link_url = pay_link_url;
	}

	public float getStar_rank() {
		return star_rank;
	}

	public void setStar_rank(float star_rank) {
		this.star_rank = star_rank;
	}

	public int getReview_cnt() {
		return review_cnt;
	}

	public void setReview_cnt(int review_cnt) {
		this.review_cnt = review_cnt;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}

	public long getEnd_time_mill() {
		return end_time_mill;
	}

	public void setEnd_time_mill(long end_time_mill) {
		this.end_time_mill = end_time_mill;
	}

	public String getDel_ny() {
		return del_ny;
	}

	public void setDel_ny(String del_ny) {
		this.del_ny = del_ny;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}


	public int getNow_player_cnt() {
		return now_player_cnt;
	}

	public void setNow_player_cnt(int now_player_cnt) {
		this.now_player_cnt = now_player_cnt;
	}

	

	public long getGame_idx() {
		return game_idx;
	}

	public void setGame_idx(long game_idx) {
		this.game_idx = game_idx;
	}

	public long getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(long user_idx) {
		this.user_idx = user_idx;
	}

	public long getStadium_idx() {
		return stadium_idx;
	}

	public void setStadium_idx(long stadium_idx) {
		this.stadium_idx = stadium_idx;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public int getStart_hr() {
		return start_hr;
	}

	public void setStart_hr(int start_hr) {
		this.start_hr = start_hr;
	}

	public String getStart_time_str() {
		return start_time_str;
	}

	public void setStart_time_str(String start_time_str) {
		this.start_time_str = start_time_str;
	}

	public long getStart_time_mill() {
		return start_time_mill;
	}

	public void setStart_time_mill(long start_time_mill) {
		this.start_time_mill = start_time_mill;
	}

	public int getPeriod_hr() {
		return period_hr;
	}

	public void setPeriod_hr(int period_hr) {
		this.period_hr = period_hr;
	}

	public int getNum_to_num() {
		return num_to_num;
	}

	public void setNum_to_num(int num_to_num) {
		this.num_to_num = num_to_num;
	}

	public int getHw_mny_team() {
		return hw_mny_team;
	}

	public void setHw_mny_team(int hw_mny_team) {
		this.hw_mny_team = hw_mny_team;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTeam_or_person() {
		return team_or_person;
	}

	public void setTeam_or_person(String team_or_person) {
		this.team_or_person = team_or_person;
	}

	public String getFree_or_pay() {
		return free_or_pay;
	}

	public void setFree_or_pay(String free_or_pay) {
		this.free_or_pay = free_or_pay;
	}

	public String getEnd_game_ny() {
		return end_game_ny;
	}

	public void setEnd_game_ny(String end_game_ny) {
		this.end_game_ny = end_game_ny;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPlayer_cnt() {
		return player_cnt;
	}

	public void setPlayer_cnt(int player_cnt) {
		this.player_cnt = player_cnt;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStd_img_url() {
		return std_img_url;
	}

	public void setStd_img_url(String std_img_url) {
		this.std_img_url = std_img_url;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
}
