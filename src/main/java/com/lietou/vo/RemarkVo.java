package com.lietou.vo;

import com.lietou.util.PageBaseModel;

import lombok.Data;

@Data
public class RemarkVo extends PageBaseModel{
	private Long id;

    private Long businessId;

    private String businessType;

    private String category;

    private Long cId;
    
    private Long[] ids;
    
}
