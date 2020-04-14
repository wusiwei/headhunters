package com.lietou.mapper;

import java.util.List;

import com.lietou.common.BaseMapper;
import com.lietou.dto.FavoritesDto;
import com.lietou.model.Favorites;
import com.lietou.queryvo.FavoritesQueryVo;
import com.lietou.vo.FavoritesVo;

public interface FavoritesMapper extends BaseMapper<Favorites>{
	
	int voInsert(FavoritesVo vo);
	
	int voUpdate(FavoritesVo vo);
	
	int checkHaveChildren(Long parentId);
	
	int deleteMainByFavorites(FavoritesVo vo);
	
	int deleteSubByFavorites(FavoritesVo vo);
	
	List<FavoritesDto> getUserNoShareDto(FavoritesQueryVo queryVo);
	
	List<FavoritesDto> getUserHaveShareDto(FavoritesQueryVo queryVo);
	
	int restBusinessCount(Long id);
}