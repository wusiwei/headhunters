package com.lietou.mapper;

import com.lietou.common.BaseMapper;
import com.lietou.model.FavoritesShare;
import com.lietou.queryvo.FavoritesQueryVo;
import com.lietou.vo.FavoritesVo;

public interface FavoritesShareMapper extends BaseMapper<FavoritesShare>{
	
	Long[] getSharedFavoritesIds(FavoritesQueryVo queryVo);
	
	int batchAddShare(FavoritesVo vo);
	
	int deleteByFavorites(FavoritesVo vo);
	
}