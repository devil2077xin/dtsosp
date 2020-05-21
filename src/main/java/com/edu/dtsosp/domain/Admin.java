package com.edu.dtsosp.domain;


public class Admin {
	private Long id;
	private String userid;
	private String username;
	private String password;
	private Integer status;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserid() { return userid; }
	public void setUserid(String userid) { this.userid = userid; }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() { return status; }
	public void setStatus(Integer status) { this.status = status; }
}
