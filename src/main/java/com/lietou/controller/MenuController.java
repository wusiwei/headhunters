package com.lietou.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lietou.dto.UserDto;
import com.lietou.filter.ApplicationHelper;
import com.lietou.service.MenuService;
import com.lietou.util.ResultResponse;
import com.lietou.vo.MenuVO;


@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	private static final Logger log = LoggerFactory.getLogger(MenuController.class);
	
	@ResponseBody
	@RequestMapping(value = "/getAllMenuTree")
	public ResultResponse<?> getAllMenuTree() {
		return menuService.getAllMenuTree();
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllMenuTreeByRoleId")
	public ResultResponse<?> getAllMenuTreeByRoleId(@RequestBody MenuVO menuQueryVO) {
		UserDto user =ApplicationHelper.getAccount();
		menuQueryVO.setcId(user.getcId());
		return menuService.getAllMenuTreeByRoleId(menuQueryVO);
	}
	
	@ResponseBody
	@RequestMapping(value = "/addMenuByRoleId")
	public ResultResponse<?> addMenuByRoleId(@RequestBody MenuVO menuQueryVO) {
		UserDto user =ApplicationHelper.getAccount();
		menuQueryVO.setcId(user.getcId());
		return menuService.addMenuByRoleId(menuQueryVO);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getUserMenu")
	public ResultResponse<?> getUserMenu() {
		MenuVO menuQueryVO =new MenuVO();
		UserDto user =ApplicationHelper.getAccount();
		menuQueryVO.setcId(user.getcId());
		menuQueryVO.setuId(user.getId());
		return menuService.getUserMenu(menuQueryVO);
	}
}
