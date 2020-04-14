package com.lietou.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.lietou.dto.MenuDto;
import com.lietou.mapper.MenuMapper;
import com.lietou.service.MenuService;
import com.lietou.util.RedisUtil;
import com.lietou.util.ResultResponse;
import com.lietou.vo.MenuVO;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private MenuMapper menuMapper;
	
	private static final Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Override
	public ResultResponse<?> getAllMenuTree(){
		ResultResponse<List<MenuDto>> r=new ResultResponse<List<MenuDto>>();
		r.setCode(ResultResponse.CODE_SUCCESS);
		r.setData(menuMapper.getAllMenuTree());
		return r;
	}
	
	@Override
	public ResultResponse<?> getAllMenuTreeByRoleId(MenuVO menuQueryVO){
		ResultResponse<JSONObject> r=new ResultResponse<JSONObject>();
		JSONObject rJson=new JSONObject();
		rJson.put("allMenuTree", menuMapper.getAllMenuTree());
		rJson.put("selectedMenu", menuMapper.getSelectedByRoleId(menuQueryVO));
		r.setCode(ResultResponse.CODE_SUCCESS);
		r.setData(rJson);
		return r;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> addMenuByRoleId(MenuVO menuQueryVO){
		ResultResponse<Integer> r=new ResultResponse<Integer>();
		menuMapper.deleteRoleMenu(menuQueryVO);
		if(menuQueryVO.getMenuIds() != null && menuQueryVO.getMenuIds().length > 0){
			r.setData(menuMapper.batchAddRoleMenu(menuQueryVO));
		}else{
			r.setData(0);
		}
		r.setCode(ResultResponse.CODE_SUCCESS);
		
		return r;
	}
	
	@Override
	public ResultResponse<?> getUserMenu(MenuVO menuQueryVO){
		ResultResponse<JSONObject> r=new ResultResponse<JSONObject>();
		JSONObject rJson=new JSONObject();
		List<Long> menuIds=menuMapper.getUserMenuIds(menuQueryVO);
		if(CollectionUtils.isNotEmpty(menuIds)){
			List<MenuDto> menuList=menuMapper.getMenusByMenuIds(menuIds);
			HashMap<Long,MenuDto> dtoMap=new HashMap<Long,MenuDto>(menuList.size());
			List<MenuDto> topMenudto=new ArrayList<MenuDto>();
			MenuDto parentDto;
			for(MenuDto menu : menuList){
				
				dtoMap.put(menu.getId(), menu);
				if(menu.getParentId() == 0){
					topMenudto.add(menu);
					continue;
				}
				parentDto=dtoMap.get(menu.getParentId());
				if(parentDto == null){
					continue;
				}
				if(parentDto.getChildren() == null){
					parentDto.setChildren(new ArrayList<MenuDto>());
				}
				parentDto.getChildren().add(menu);
			}
			rJson.put("menus", topMenudto);
			rJson.put("vueNames", menuMapper.getVueNameByMenuIds(menuIds));
		}else{
			rJson.put("menus", "");
			rJson.put("vueNames", "");
		}
		
		r.setCode(ResultResponse.CODE_SUCCESS);
		r.setData(rJson);
		return r;
	}
	
}
