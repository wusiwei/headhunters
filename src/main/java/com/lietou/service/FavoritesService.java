package com.lietou.service;

import com.lietou.bo.FavoritesBusinessBo;
import com.lietou.queryvo.FavoritesQueryVo;
import com.lietou.util.ResultResponse;
import com.lietou.vo.FavoritesVo;

public interface FavoritesService {

	ResultResponse<?> add(FavoritesVo vo);

	ResultResponse<?> modify(FavoritesVo vo);

	ResultResponse<?> deleteById(FavoritesVo vo);

	ResultResponse<?> getUserFavoritesTree(FavoritesQueryVo queryVo);

	ResultResponse<?> getUserFavoritesTreeDetail(FavoritesQueryVo queryVo);

	ResultResponse<?> addToFavorites(FavoritesBusinessBo bo);

	ResultResponse<?> removeFromFavorites(FavoritesBusinessBo bo);
	
}
