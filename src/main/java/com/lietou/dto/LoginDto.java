package com.lietou.dto;

public class LoginDto {
	private Long id;
	
	private Long cId;
	
	private Long[] pIds;
	
	private String username;
	
	private String loginType;
	
	private Boolean freezeFlag;
	
	private String jwt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public Boolean getFreezeFlag() {
		return freezeFlag;
	}

	public void setFreezeFlag(Boolean freezeFlag) {
		this.freezeFlag = freezeFlag;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public Long[] getpIds() {
		return pIds;
	}

	public void setpIds(Long[] pIds) {
		this.pIds = pIds;
	}
	
}
