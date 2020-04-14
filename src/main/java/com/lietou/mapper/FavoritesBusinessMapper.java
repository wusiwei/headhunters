package com.lietou.mapper;

import com.lietou.bo.FavoritesBusinessBo;
import com.lietou.common.BaseMapper;
import com.lietou.model.FavoritesBusiness;

public interface FavoritesBusinessMapper extends BaseMapper<FavoritesBusiness>{
	
    int batchAddBusiness(FavoritesBusinessBo bo);
    
    int deleteByBusiness(FavoritesBusinessBo bo);
    
    int batchRestTalent(FavoritesBusinessBo bo);
    
    
}