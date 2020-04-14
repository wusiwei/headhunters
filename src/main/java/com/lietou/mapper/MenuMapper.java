package com.lietou.mapper;

import java.util.List;

import com.lietou.common.BaseMapper;
import com.lietou.dto.MenuDto;
import com.lietou.model.Menu;
import com.lietou.vo.MenuVO;

public interface MenuMapper extends BaseMapper<Menu>{
    
	List<MenuDto> getAllMenuTree();
    
    List<Long> getSelectedByRoleId(MenuVO queryVO);
    
    int deleteRoleMenu(MenuVO queryVO);
    
    int batchAddRoleMenu(MenuVO queryVO);
    
    List<Long> getUserMenuIds(MenuVO queryVO);
    
    List<MenuDto> getMenusByMenuIds(List<Long> menuIds);
    
    List<String> getVueNameByMenuIds(List<Long> menuIds);
    
}