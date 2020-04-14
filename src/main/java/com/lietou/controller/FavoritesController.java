package com.lietou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lietou.bo.FavoritesBusinessBo;
import com.lietou.dto.UserDto;
import com.lietou.filter.ApplicationHelper;
import com.lietou.queryvo.FavoritesQueryVo;
import com.lietou.service.FavoritesService;
import com.lietou.util.ResultResponse;
import com.lietou.vo.FavoritesVo;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {
	
	@Autowired
	private FavoritesService favoritesService;
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public ResultResponse<?> add(@RequestBody FavoritesVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setcId(user.getcId());
		vo.setCreaterId(user.getId());
		return favoritesService.add(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/modify")
	public ResultResponse<?> modify(@RequestBody FavoritesVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setcId(user.getcId());
		vo.setCreaterId(user.getId());
		return favoritesService.modify(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteById/{favoritesId}")
	public ResultResponse<?> deleteById(@PathVariable Long favoritesId) {
		UserDto user =ApplicationHelper.getAccount();
		FavoritesVo vo =new FavoritesVo();
		vo.setId(favoritesId);
		vo.setcId(user.getcId());
		vo.setCreaterId(user.getId());
		return favoritesService.deleteById(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getUserFavoritesTree")
	public ResultResponse<?> getUserFavoritesTree(@RequestBody FavoritesQueryVo queryVo) {
		UserDto user =ApplicationHelper.getAccount();
		queryVo.setCId(user.getcId());
		queryVo.setCreaterId(user.getId());
		queryVo.setPIds(user.getpIds());
		return favoritesService.getUserFavoritesTree(queryVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getUserFavoritesTreeDetail")
	public ResultResponse<?> getUserFavoritesTreeDetail(@RequestBody FavoritesQueryVo queryVo) {
		UserDto user =ApplicationHelper.getAccount();
		queryVo.setCId(user.getcId());
		queryVo.setCreaterId(user.getId());
		queryVo.setPIds(user.getpIds());
		return favoritesService.getUserFavoritesTreeDetail(queryVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/addToFavorites")
	public ResultResponse<?> addToFavorites(@RequestBody FavoritesBusinessBo bo) {
		UserDto user =ApplicationHelper.getAccount();
		bo.setcId(user.getcId());
		bo.setCreaterId(user.getId());
		return favoritesService.addToFavorites(bo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/removeFromFavorites")
	public ResultResponse<?> removeFromFavorites(@RequestBody FavoritesBusinessBo bo) {
		UserDto user =ApplicationHelper.getAccount();
		bo.setcId(user.getcId());
		bo.setCreaterId(user.getId());
		return favoritesService.removeFromFavorites(bo);
	}
}
