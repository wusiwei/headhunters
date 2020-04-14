package com.lietou.queryvo;

import lombok.Data;

@Data
public class FavoritesQueryVo {
	
	private Long id;
	
	private Long createrId;
	
	private Long cId;
	
	private Long[] pIds;
	
	private String businessType;
	
	private String favoritesIdsStr;
	
}
