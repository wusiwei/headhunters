package com.lietou.bo;

import com.lietou.model.FavoritesBusiness;

import lombok.Data;

@Data
public class FavoritesBusinessBo extends FavoritesBusiness{
	
	private Long[] businessIds;
	
}
