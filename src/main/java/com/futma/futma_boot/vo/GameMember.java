package com.futma.futma_boot.vo;

public class GameMember {
	private int game_mem_idx=0;
	private long game_idx=0;
	private int user_idx=0;
	private int price=0;
	
	private String pay_ny=null;
	private String del_ny=null;
	private String pay_date=null;
	private String created_date=null;
	
	
	
	public int getGame_mem_idx() {
		return game_mem_idx;
	}
	public void setGame_mem_idx(int game_mem_idx) {
		this.game_mem_idx = game_mem_idx;
	}
	public long getGame_idx() {
		return game_idx;
	}
	public void setGame_idx(long game_idx) {
		this.game_idx = game_idx;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPay_ny() {
		return pay_ny;
	}
	public void setPay_ny(String pay_ny) {
		this.pay_ny = pay_ny;
	}
	public String getDel_ny() {
		return del_ny;
	}
	public void setDel_ny(String del_ny) {
		this.del_ny = del_ny;
	}
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
}
