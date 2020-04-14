package com.lietou.dto;

import java.util.List;

import com.lietou.model.Favorites;
import com.lietou.model.FavoritesShare;

import lombok.Data;

@Data
public class FavoritesDto extends Favorites{
	
	private List<FavoritesDto> children;
	
	private List<FavoritesShare> share;
}
