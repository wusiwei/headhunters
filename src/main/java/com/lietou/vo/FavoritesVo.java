package com.lietou.vo;

import java.util.List;

import com.lietou.model.Favorites;
import com.lietou.model.FavoritesShare;

import lombok.Data;

@Data
public class FavoritesVo extends Favorites{
	
	private List<FavoritesShare> share;
	
}
