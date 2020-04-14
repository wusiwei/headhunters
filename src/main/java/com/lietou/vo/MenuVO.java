package com.lietou.vo;

import com.lietou.util.PageBaseModel;

public class MenuVO extends PageBaseModel{
	
	private Long roleId;
	
	private Long uId;
	
	private Long cId;
	
	private Long[] menuIds;
			
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public Long[] getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(Long[] menuIds) {
		this.menuIds = menuIds;
	}

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}
	
}
