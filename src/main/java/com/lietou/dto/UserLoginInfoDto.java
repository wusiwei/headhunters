package com.lietou.dto;

import java.util.List;

import com.lietou.model.Role;

import lombok.Data;

@Data
public class UserLoginInfoDto {
	private Long id;
	
	private Long cId;
	
	private String username;
	
	private String jwt;
	
	private List<Role> roles;
	
	private List<MenuDto> menus;
	
	private List<String> vueNames;
}
