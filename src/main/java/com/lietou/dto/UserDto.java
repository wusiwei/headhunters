package com.lietou.dto;

public class UserDto{
	private Long id;
	
	private Long cId;
	
	private Long[] pIds;
	
	private String username;
	
	private String jwt;
	
	private Integer fullTimeType;
	
	private String roleCode;
	
	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}


	public Integer getFullTimeType() {
		return fullTimeType;
	}

	public void setFullTimeType(Integer fullTimeType) {
		this.fullTimeType = fullTimeType;
	}

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

	public Long[] getpIds() {
		return pIds;
	}

	public void setpIds(Long[] pIds) {
		this.pIds = pIds;
	}
	
}
