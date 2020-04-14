package com.lietou.queryvo;

import com.lietou.util.PageBaseModel;

import lombok.Data;

@Data
public class TalentQueryVo extends PageBaseModel{
	private Long id;

    private Long cId;
    
    private Long createrId;
    
    private String chineseName;
    
    private String focusStr;
    
    private String status;
    
    private Long city;
    
    private Long[] ids;
    
    private String tags;
    
    private Long favoritesId;
}
