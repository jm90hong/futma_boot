package com.futma.futma_boot.vo;

public class Stadium {
	
	
	
	private int stadium_idx=0;
	private String name=null;
	private String location=null;
	private String address=null;
	private String search_txt =null;
	private String created_date=null;
	
	
	public String getSearch_txt() {
		return search_txt;
	}
	public void setSearch_txt(String search_txt) {
		this.search_txt = search_txt;
	}
	public int getStadium_idx() {
		return stadium_idx;
	}
	public void setStadium_idx(int stadium_idx) {
		this.stadium_idx = stadium_idx;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	
	
	
	
}
