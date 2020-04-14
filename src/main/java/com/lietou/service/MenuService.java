package com.lietou.service;

import com.lietou.util.ResultResponse;
import com.lietou.vo.MenuVO;


public interface MenuService {

	ResultResponse<?> getAllMenuTree();

	ResultResponse<?> getAllMenuTreeByRoleId(MenuVO menuQueryVO);

	ResultResponse<?> addMenuByRoleId(MenuVO menuQueryVO);

	ResultResponse<?> getUserMenu(MenuVO menuQueryVO);

}
